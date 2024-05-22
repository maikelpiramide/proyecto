package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.ActividadFisica;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.ActividadFisicaRepository;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActividadFisicaRepository actividadFisicaRepository;
    @GetMapping("/login")
    public ModelAndView index(HttpSession httpSession, Model model) {
        if(httpSession.getAttribute("user") != null) {
            Optional<Usuario> usuario = usuarioRepository.findById((long)httpSession.getAttribute("user"));
            if(usuario.isPresent()) {
                model.addAttribute("usuario",usuario);
                return new ModelAndView("redirect:/home/usuario");
            }
        }
        return new ModelAndView("index");
    }

    @PostMapping("/login/usuario")
    public ModelAndView loginUsuario(Model model, @RequestParam String email, @RequestParam String token, HttpSession httpSession) {

        //si no se encuentra en caché, hacer login y meter el user en cache
        Optional<Usuario> usuario = usuarioRepository.getUserByEmailAndToken(email,token);
        if(usuario.isPresent()){
            httpSession.setAttribute("user",usuario.get().getId());
            model.addAttribute("usuario",usuario);
            return new ModelAndView("redirect:/home/usuario");
        }else{
            model.addAttribute("confirm",false);
        }
        return new ModelAndView("redirect:/login");
    }

}
