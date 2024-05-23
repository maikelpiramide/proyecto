package org.example.mikeli.Class;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class MotivoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String motivo;
    @OneToMany(mappedBy = "motivoCita")
    private Set<UsuarioCentroCita> usuarioCentroCita;

    public MotivoCita() {}

    public long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public Set<UsuarioCentroCita> getUsuarioCentroCita() {
        return usuarioCentroCita;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setUsuarioCentroCita(Set<UsuarioCentroCita> usuarioCentroCita) {
        this.usuarioCentroCita = usuarioCentroCita;
    }
}
