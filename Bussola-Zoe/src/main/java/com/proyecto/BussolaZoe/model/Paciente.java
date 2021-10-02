package com.proyecto.BussolaZoe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Paciente {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
        @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
        private Long id;

    private String nombre;
    private String apellido;
        private Integer DNI;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @JoinColumn(name = "domicilio_id")
        private Domicilio domicilio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDNI() {
            return DNI;
        }

        public void setDNI(Integer DNI) {
            this.DNI = DNI;
        }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
            return domicilio;
        }

        public void setDomicilio(Domicilio domicilio) {
            this.domicilio = domicilio;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Paciente(String nombre, String apellido, Integer DNI, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(){

}
}
