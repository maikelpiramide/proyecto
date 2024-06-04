package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.Usuario;

import org.example.mikeli.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EditarPerfilController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home/editarPerfil")
    public String editarPerfil(Model model, HttpSession httpSession) {
        Optional<Usuario> usuario = usuarioRepository.findById((long)httpSession.getAttribute("user")) ;
        usuario.ifPresent(user->{
            model.addAttribute("usuario", user);
        });
        return "editarPerfil";
    }


    @PostMapping("/home/editarPerfil/setPerfil")
    public ModelAndView editarPerfilUsuario(Usuario usuario, Model model, @RequestParam String token, @RequestParam String confirmToken,HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("editarPerfil");
        Optional<Usuario> usuario2 = usuarioRepository.findById((long)httpSession.getAttribute("user"));
        System.out.println(httpSession.getAttribute("user"));
        System.out.println(usuario);
        if(token.equals(confirmToken)) {
            try{
                usuarioRepository.save(usuario);
            }catch (Exception e){
                model.addAttribute("saveError",true);
                usuario2.ifPresent(user->{
                    model.addAttribute("usuario",user);
                });

                return mv;
            }
        }else{
            model.addAttribute("confirmFailed",true);
            usuario2.ifPresent(user->{
                model.addAttribute("usuario",user);
            });
            return mv;
        }

        return new ModelAndView("redirect:/home/editarPerfil");
    }

}
