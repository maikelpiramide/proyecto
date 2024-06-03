package org.example.mikeli.Service;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.ActividadFisica;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Repository.ActividadFisicaRepository;
import org.example.mikeli.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
//servicio para crear registros de actividad física automaticamente cada 24h
@Service
public class ActividadFisicaService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActividadFisicaRepository actividadFisicaRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?") // Ejecutar todos los días a las 00:00
    public void executeTask() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        usuarios.forEach(user->{
            LocalDate fecha = LocalDate.now();
            LocalTime tiempoActividad = LocalTime.of(0,0,0);
            ActividadFisica actividadFisica = new ActividadFisica(0,tiempoActividad,0,fecha,user);
            //actividadFisica.setUsuario(user);
            actividadFisicaRepository.save(actividadFisica);
        });
    }
}
