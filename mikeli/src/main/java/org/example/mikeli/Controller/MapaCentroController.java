package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MapaCentroController {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/home/mapaCentros")
    public String mapaCentros(Model model, HttpSession session) {

        Optional<Usuario> usuario = usuarioRepository.findById((long)httpSession.getAttribute("user"));
        usuario.ifPresent(user->{
            model.addAttribute("usuario", user);
        });
        return "mapaCentros";
    }
}
