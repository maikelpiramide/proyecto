package org.example.mikeli.Class;

import jakarta.persistence.*;

@Entity
public class UsuarioCentroCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario",nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "fk_id_cita",referencedColumnName = "id")
    private CitaMedica citaMedica;

    @ManyToOne
    @JoinColumn(name = "fk_id_centro",nullable = false)
    private CentroMedico centroMedico;

    @ManyToOne
    @JoinColumn(name = "fk_id_motivo_cita",nullable = false)
    private MotivoCita motivoCita;

    private String descripcionMotivo;

    public UsuarioCentroCita() {}

    public long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public CentroMedico getCentroMedico() {
        return centroMedico;
    }

    public MotivoCita getMotivoCita() {
        return motivoCita;
    }

    public String getDescripcionMotivo() {
        return descripcionMotivo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    public void setCentroMedico(CentroMedico centroMedico) {
        this.centroMedico = centroMedico;
    }

    public void setMotivoCita(MotivoCita motivoCita) {
        this.motivoCita = motivoCita;
    }

    public void setDescripcionMotivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsuarioCentroCita{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", citaMedica=" + citaMedica +
                ", centroMedico=" + centroMedico +
                ", motivoCita=" + motivoCita +
                ", descripcionMotivo='" + descripcionMotivo + '\'' +
                '}';
    }
}
