package org.example.mikeli.Class;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String alias;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String token;
    private String numeroTarjetaSanitaria;
    private String dni;
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    private Set<ActividadFisica> actividadesFisicas;

    public Usuario(){}

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getNumeroTarjetaSanitaria() {
        return numeroTarjetaSanitaria;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }
    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<ActividadFisica> getActividadesFisicas() {
        return actividadesFisicas;
    }

    public void setActividadesFisicas(Set<ActividadFisica> actividadesFisicas) {
        this.actividadesFisicas = actividadesFisicas;
    }

    public void setNumeroTarjetaSanitaria(String numeroTarjetaSanitaria) {
        this.numeroTarjetaSanitaria = numeroTarjetaSanitaria;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alias='" + alias + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", numeroTarjetaSanitaria='" + numeroTarjetaSanitaria + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
