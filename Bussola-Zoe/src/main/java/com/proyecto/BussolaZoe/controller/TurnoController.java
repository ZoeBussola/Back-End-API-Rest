package com.proyecto.BussolaZoe.controller;


import com.proyecto.BussolaZoe.login.AppUserRole;
import com.proyecto.BussolaZoe.model.*;
import com.proyecto.BussolaZoe.service.OdontologoService;
import com.proyecto.BussolaZoe.service.PacienteService;
import com.proyecto.BussolaZoe.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/turnos")
public class TurnoController {


    private final TurnoService turnoService;

    private final PacienteService pacienteService;

    private final OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }


    @PostMapping("/test")
    public Object turnotest(){
       Usuario us = new Usuario("Tomas","apellido","usu","134", AppUserRole.USER);
        Domicilio dm =new Domicilio("Calle","134","Este Lugar","Provincia");
        Odontologo od = new Odontologo(685416,"Juan","Perez",dm);
        Paciente pc = new Paciente("Juana","Peres",4135486,dm);
        odontologoService.saveOdontologo(od);
        pacienteService.save(pc);
        return turnoService.save(new Turno(LocalDateTime.now(),od,pc));

    }
    @PostMapping("/save")
    public ResponseEntity saveTurno(@RequestBody Turno turno) {
        ResponseEntity respuesta;

        if(odontologoService.findOdontologoById(turno.getOdontologo().getId()).isEmpty()) {
            respuesta = new ResponseEntity("Odontologo no encontrado!", HttpStatus.NOT_FOUND);
        } else if (pacienteService.findPacienteById(turno.getPaciente().getId()).isEmpty()){
            respuesta = new ResponseEntity("Paciente no encontrado!", HttpStatus.NOT_FOUND);
        }else {
            respuesta = new ResponseEntity(turnoService.save(turno), HttpStatus.OK);
        }
        return respuesta;
    }

  @GetMapping("/{id}")
  public Turno findTurnoById(@PathVariable Long id) {
     return turnoService.findTurnoById(id).get();
  }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> findAll() {
        return ResponseEntity.ok(turnoService.findAll());
    }



    @PutMapping("/{id}")
    public ResponseEntity updateTurno(@RequestBody Turno modificacion) {
        ResponseEntity respuesta;

        if(turnoService.findTurnoById(modificacion.getId()).isPresent()) {
            respuesta = new ResponseEntity(turnoService.updateTurno(modificacion), HttpStatus.OK);
        } else {
            respuesta = new ResponseEntity("Turno no encontrado", HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }


    @DeleteMapping("/{id}")
    public String deleteTurno(@PathVariable Long id) {
            return turnoService.delete(id);

    }


}
