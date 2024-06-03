package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Class.UsuarioCentroCita;
import org.example.mikeli.Repository.CitaMedicaRepository;
import org.example.mikeli.Repository.UsuarioCentroCitaRepository;
import org.example.mikeli.Repository.UsuarioRepository;
import org.example.mikeli.Service.UsuarioCentroCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class VerCitasController {
    @Autowired
    private UsuarioCentroCitaRepository usuarioCentroCitaRepository;

    @Autowired
    private UsuarioCentroCitasService usuarioCentroCitasService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home/verCitas")
    public String verCitas(HttpSession httpSession, Model model, @RequestParam(defaultValue = "0") int pagina, @RequestParam(defaultValue = "5") int tamano) {

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        Optional<Usuario> usuario = usuarioRepository.findById((long)httpSession.getAttribute("user"));

        usuario.ifPresent((u) -> {
            Page<UsuarioCentroCita> page = usuarioCentroCitasService.findPaginatedByUserLastTen(u,pagina,tamano);
            model.addAttribute("formatoFecha", formatoFecha);
            model.addAttribute("formatoHora", formatoHora);
            model.addAttribute("citas",usuarioCentroCitaRepository.findByUsuario(u));
            model.addAttribute("entidades",page.getContent());
            model.addAttribute("paginaActual", pagina);
            model.addAttribute("totalPaginas", page.getTotalPages());
            model.addAttribute("tamanoPagina", tamano);
            model.addAttribute("tienePaginaAnterior", page.hasPrevious());
            model.addAttribute("tienePaginaSiguiente", page.hasNext());
            model.addAttribute("usuario", usuario.get());
        });

        return "verCitas";
    }
}
