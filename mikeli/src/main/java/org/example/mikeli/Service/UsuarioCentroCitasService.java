package org.example.mikeli.Service;

import org.example.mikeli.Class.Usuario;

import org.example.mikeli.Class.UsuarioCentroCita;
import org.example.mikeli.Repository.UsuarioCentroCitaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCentroCitasService {
    @Autowired
    private UsuarioCentroCitaRepository userCentroCitaRepository;

    public Page<UsuarioCentroCita> findPaginatedByUserLastTen(Usuario user) {
        Pageable pageable = PageRequest.of(0, 10);

        return  userCentroCitaRepository.findAllByUsuarioOrderByIdDesc(user,pageable);
    }
}
