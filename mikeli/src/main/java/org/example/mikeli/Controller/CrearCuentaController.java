package org.example.mikeli.Controller;


import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CrearCuentaController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping("/crearCuenta")
    public String crearCuenta(Model model) {
        model.addAttribute("usuario",new Usuario());

        return "crearCuenta";
    }
    @PostMapping("/crearCuenta/CrearUsuario")
    public String crearUsuario(Model model, Usuario usuario) {
        System.out.println(usuario);
        usuarioRepository.save(usuario);
        //intentar return de la pagina de inicio del usuario no de la inicial
        return "crearCuenta";
    }
}
