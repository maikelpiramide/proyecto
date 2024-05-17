package org.example.mikeli.Repository;

import org.example.mikeli.Class.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    @Query("select u from Usuario u where u.email = :email and u.token = :token")
    Optional<Usuario> getUserByEmailAndToken(String email,String token);
}
