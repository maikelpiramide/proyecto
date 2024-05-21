package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;

import org.example.mikeli.Class.CentroMedico;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.CentroMedicoRepository;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    @GetMapping("/home/usuario")
    public String homeUser(HttpSession httpSession, Model model){
        //obtenemos el id del usuario que almacenamos en el httpSesión al iniciar este la sesión
        long idUsuario = (long) httpSession.getAttribute("user");

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        //System.out.println(usuario);

        //obtener la actividad diaria del dia
        LocalDate fechaActual = LocalDate.now();

        usuario.ifPresent((user) -> {
            //System.out.println(usuarioRepository.getActividadFisicaByUserAndDate(user,fechaActual));
            model.addAttribute("actividadUsuario",usuarioRepository.getActividadFisicaByUserAndDate(user,fechaActual));
        });

        
        return "home";
    }
}
