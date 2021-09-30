package com.proyecto.BussolaZoe.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    @SequenceGenerator(name= "turno_sequence", sequenceName = "turno_sequence")
   // @Column(name= "idTurno")
    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime fechaHora;


    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }


    public Turno(LocalDateTime fechaHora, Odontologo odontologo, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Turno(){

}

}