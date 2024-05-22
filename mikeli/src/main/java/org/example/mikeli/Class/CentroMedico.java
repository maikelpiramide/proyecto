package org.example.mikeli.Class;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
public class CentroMedico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private float longitud;
    private float latitud;
    private LocalTime apertura;
    private LocalTime cierre;
    private boolean urgencias;

    @OneToMany(mappedBy = "centroMedico")
    @JsonIgnore
    private Set<UsuarioCentroCita> usuarioCentroCita;

    public CentroMedico() {}

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getLongitud() {
        return longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public boolean isUrgencias() {
        return urgencias;
    }

    public Set<UsuarioCentroCita> getUsuarioCentroCita() {
        return usuarioCentroCita;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public void setUrgencias(boolean urgencias) {
        this.urgencias = urgencias;
    }

    public void setUsuarioCentroCita(Set<UsuarioCentroCita> usuarioCentroCita) {
        this.usuarioCentroCita = usuarioCentroCita;
    }

    @Override
    public String toString() {
        return "CentroMedico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", apertura=" + apertura +
                ", cierre=" + cierre +
                ", urgencias=" + urgencias +
                '}';
    }
}
