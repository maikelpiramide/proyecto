package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.Usuario;
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
    @GetMapping("/login")
    public String index() {
        return "index";
    }

    @PostMapping("/login/usuario")
    public ModelAndView loginUsuario(Model model, @RequestParam String email, @RequestParam String token, HttpSession httpSession) {

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
