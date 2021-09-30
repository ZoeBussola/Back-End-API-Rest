package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.model.Domicilio;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.model.Usuario;
import com.dh.clinicaodontologica.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    private final PacienteService pacienteService;
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/")
    public List<Paciente> findAllPacientes(){
        logger.debug("Busqueda de Todos los Pacientes");
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findPacienteById(@PathVariable Long id){
        logger.debug("Búsqueda Paciente ID: " + id);
        return pacienteService.findPacienteById(id).get();
    }


    @PostMapping("/save")
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @PostMapping("/test")
    public Object testPaciente(){
        Usuario us = new Usuario("Juan", "Peres", "usu", "134");
        Domicilio dm = new Domicilio("Calle","666", "estelugar", "estaprovincia");
        return pacienteService.save(new Paciente(123456789, 1354, dm, us));
    }



    @PutMapping("/")
    public ResponseEntity updatePaciente(@RequestBody Paciente paciente){

        ResponseEntity response;

        if(pacienteService.findPacienteById(paciente.getId()).isPresent()){
            response = new ResponseEntity(pacienteService.update(paciente), HttpStatus.OK);
            logger.debug("Paciente Actualizado");
        }else{
            response = new ResponseEntity("Paciente no encontrado ID:" + paciente.getId(), HttpStatus.NO_CONTENT);
            logger.debug("Actualizacion fallida, Paciente no encontrado");
        }

        return response;
    }




    @DeleteMapping("/{id}")
    public String deletePaciente(@PathVariable Long id){
        return pacienteService.delete(id);
    }




}
