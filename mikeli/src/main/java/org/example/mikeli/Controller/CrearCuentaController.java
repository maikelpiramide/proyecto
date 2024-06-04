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
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class CrearCuentaController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActividadFisicaRepository actividadFisicaRepository;

    @GetMapping("/crearCuenta")
    public String crearCuenta(Model model) {
        model.addAttribute("usuario",new Usuario());

        return "crearCuenta";
    }
    @PostMapping("/crearCuenta/CrearUsuario")
    public ModelAndView crearUsuario(Model model, Usuario usuario, HttpSession httpSession) {
        System.out.println(usuario);
        try {
            usuarioRepository.save(usuario);
            httpSession.setAttribute("user",usuario.getId());
        }catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("error",true);
            return new ModelAndView("crearCuenta");
        }

        //creamo su registro de actividad
        LocalDate fecha = LocalDate.now();
        LocalTime tiempoActividad = LocalTime.of(0,0,0);
        ActividadFisica actividadFisica = new ActividadFisica(0,tiempoActividad,0,fecha,usuario);
        actividadFisica.setUsuario(usuario);
        actividadFisicaRepository.save(actividadFisica);
        //intentar return de la pagina de inicio del usuario no de la inicial
        return  new ModelAndView("redirect:/home/usuario");
    }
}
