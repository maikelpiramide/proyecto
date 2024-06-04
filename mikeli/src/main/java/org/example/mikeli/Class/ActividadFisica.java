package org.example.mikeli.Class;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ActividadFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int pasos;
    private LocalTime tiempoActividad;
    private int caloriasQuemadas;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario",nullable = false)
    private Usuario usuario;

    public ActividadFisica() {}

    public ActividadFisica(int pasos, LocalTime tiempoActividad, int caloriasQuemadas, LocalDate fecha, Usuario usuario) {
        this.pasos = pasos;
        this.tiempoActividad = tiempoActividad;
        this.caloriasQuemadas = caloriasQuemadas;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public int getPasos() {
        return pasos;
    }

    public LocalTime getTiempoActividad() {
        return tiempoActividad;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setTiempoActividad(LocalTime tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "ActividadFisica{" +
                "id=" + id +
                ", pasos=" + pasos +
                ", tiempoActividad=" + tiempoActividad +
                ", caloriasQuemadas=" + caloriasQuemadas +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                '}';
    }
}
