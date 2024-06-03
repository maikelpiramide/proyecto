package org.example.mikeli.Class;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fecha;
    private boolean activa;
    @OneToOne(mappedBy = "citaMedica")
    private UsuarioCentroCita usuarioCentroCitas;

    public CitaMedica(){}

    public CitaMedica(LocalDateTime fecha, boolean activa) {
        this.fecha = fecha;
        this.activa = activa;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isActiva() {
        return activa;
    }

    public UsuarioCentroCita getUsuarioCentroCitas() {
        return usuarioCentroCitas;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuarioCentroCitas(UsuarioCentroCita usuarioCentroCitas) {
        this.usuarioCentroCitas = usuarioCentroCitas;
    }
}
