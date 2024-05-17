package org.example.mikeli.Controller;

import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String loginUsuario(Model model, @RequestParam String email, @RequestParam String token){

        Optional<Usuario> usuario = usuarioRepository.getUserByEmailAndToken(email,token);
        if(usuario.isPresent()){
            model.addAttribute("usuario",usuario);
            return "home";
        }else{
            model.addAttribute("confirm",false);
        }
        return "index";

    }

}
