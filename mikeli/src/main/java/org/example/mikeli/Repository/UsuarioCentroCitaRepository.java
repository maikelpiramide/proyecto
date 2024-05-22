package org.example.mikeli.Repository;

import org.example.mikeli.Class.Usuario;
import org.example.mikeli.Class.UsuarioCentroCita;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCentroCitaRepository extends CrudRepository<UsuarioCentroCita, Integer> {
    Page<UsuarioCentroCita> findAllByUsuarioOrderByIdDesc(Usuario usuario, Pageable pageable);
}
