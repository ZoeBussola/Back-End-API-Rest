package com.proyecto.BussolaZoe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime fechaIngreso;

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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
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


    public Paciente(Usuario usuario, Integer DNI, LocalDateTime fechaIngreso, Domicilio domicilio) {
        this.usuario = usuario;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(){

}
}
