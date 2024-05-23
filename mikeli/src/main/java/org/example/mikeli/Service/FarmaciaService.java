package org.example.mikeli.Service;

import org.example.mikeli.Class.Farmacia;
import org.example.mikeli.Repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getFarmacias")
public class FarmaciaService {
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @GetMapping
    public List<Farmacia> getFarmacias() {
        return (List<Farmacia>) farmaciaRepository.findAll();
    }
}
