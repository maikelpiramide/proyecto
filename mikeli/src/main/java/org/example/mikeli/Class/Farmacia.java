package org.example.mikeli.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private float latitud;
    private float longitud;
    private LocalTime apertura;
    private LocalTime cierre;
    private boolean guardia;

    public Farmacia(){}

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public boolean isGuardia() {
        return guardia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public void setGuardia(boolean guardia) {
        this.guardia = guardia;
    }
}
