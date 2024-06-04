package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;

import org.example.mikeli.Class.ActividadFisica;
import org.example.mikeli.Class.Usuario;

import org.example.mikeli.Repository.ActividadFisicaRepository;
import org.example.mikeli.Repository.UsuarioRepository;
import org.example.mikeli.Service.UsuarioCentroCitasService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioCentroCitasService usuarioCentroCitasService;


    @GetMapping("/home/usuario")
    public String homeUser(HttpSession httpSession, Model model){
        //obtenemos el id del usuario que almacenamos en el httpSesión al iniciar este la sesión
        long idUsuario = (long) httpSession.getAttribute("user");

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        //System.out.println(usuario);

        //obtener la actividad diaria del dia
        LocalDate fechaActual = LocalDate.now();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        usuario.ifPresent((user) -> {
            //System.out.println(usuarioRepository.getActividadFisicaByUserAndDate(user,fechaActual));
            //System.out.println(usuarioCentroCitasService.findPaginatedByUserLastTen(user,0,5));
            model.addAttribute("citasUsuario", usuarioCentroCitasService.findPaginatedByUserLastTen(user,0,5));
            model.addAttribute("formatoFecha", formatoFecha);
            model.addAttribute("formatoHora",formatoHora);
            model.addAttribute("actividadUsuario",usuarioRepository.getActividadFisicaByUserAndDate(user,fechaActual));
            model.addAttribute("usuario",user);
        });
        
        return "home";
    }


}
