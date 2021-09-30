package com.dh.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
        @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
        private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
        private Integer DNI;
        private Integer fechaIngreso;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @JoinColumn(name = "domicilio_id")
        private Domicilio domicilio;


    public Long getId() {
        return id;
    }

        public Integer getDNI() {
            return DNI;
        }

        public void setDNI(Integer DNI) {
            this.DNI = DNI;
        }

    public Integer getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Integer fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
            return domicilio;
        }

        public void setDomicilio(Domicilio domicilio) {
            this.domicilio = domicilio;
        }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


        public Paciente(Integer DNI, Integer fechaIngreso, Domicilio domicilio, Usuario usuario) {
            this.DNI = DNI;
            this.fechaIngreso = fechaIngreso;
            this.domicilio = domicilio;
            this.usuario = usuario;
        }

public Paciente(){

}
}
