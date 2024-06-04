package org.example.mikeli.Controller;



import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.CitaMedica;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Class.UsuarioCentroCita;
import org.example.mikeli.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Controller
public class FormularioCitaController {
    @Autowired
    private CentroMedicoRepository centroMedicoRepository;
    @Autowired
    private MotivoCitaRepository motivoCitaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioCentroCitaRepository usuarioCentroCitaRepository;

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @GetMapping("/home/solicitarCita")
    public String pedirCita(Model model, HttpSession httpSession) {
        model.addAttribute("centros",centroMedicoRepository.findAll());
        model.addAttribute("motivosCita",motivoCitaRepository.findAll());
        model.addAttribute("usuarioCentroCita", new UsuarioCentroCita());
        Optional<Usuario> usuario = usuarioRepository.findById((long)httpSession.getAttribute("user"));
        usuario.ifPresent(user->{
            model.addAttribute("usuario",user);
        });
        return "formularioCita";
    }

    @PostMapping("/home/solicitarCita/newCita")
    public ModelAndView newCita(@ModelAttribute UsuarioCentroCita usuarioCentroCita, Model model, @RequestParam String nombre, @RequestParam String primerApellido, @RequestParam String segundoApellido, @RequestParam String email, RedirectAttributes redirectAttributes, @RequestParam LocalDate dia,@RequestParam LocalTime hora ) {

        Optional<Usuario> usuarioCita = usuarioRepository.getUserForCitaMedicaForm(nombre,primerApellido,segundoApellido,email);
        if(usuarioCita.isPresent()) {
            UsuarioCentroCita usuarioCentroCitaForm = usuarioCentroCita;
            usuarioCentroCitaForm.setUsuario(usuarioCita.get());

            LocalDateTime fecha = LocalDateTime.of(dia,hora);

            CitaMedica citaMedica = new CitaMedica(fecha,true);
            citaMedicaRepository.save(citaMedica);

            usuarioCentroCitaForm.setCitaMedica(citaMedica);
            usuarioCentroCitaRepository.save(usuarioCentroCitaForm);

            return new ModelAndView("redirect:/home/usuario");
            //System.out.println(usuarioCentroCitaForm);
        }
        redirectAttributes.addFlashAttribute("errorUser", true);
        return new ModelAndView("redirect:/home/solicitarCita");
    }
}
