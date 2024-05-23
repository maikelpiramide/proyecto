package org.example.mikeli.Service;

import org.example.mikeli.Class.CentroMedico;
import org.example.mikeli.Repository.CentroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getCentrosMedicos")
public class CentroService {
    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    @GetMapping
    public List<CentroMedico> getCentros(){
        return (List<CentroMedico>) centroMedicoRepository.findAll();
    }
}
