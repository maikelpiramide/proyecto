package org.example.mikeli.Repository;

import org.example.mikeli.Class.ActividadFisica;
import org.example.mikeli.Class.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    @Query("select u from Usuario u where u.email = :email and u.token = :token")
    Optional<Usuario> getUserByEmailAndToken(String email,String token);

    @Query("select a from ActividadFisica a where a.usuario = :usuario and a.fecha = :fecha")
    ActividadFisica getActividadFisicaByUserAndDate(Usuario usuario, LocalDate fecha);
}
