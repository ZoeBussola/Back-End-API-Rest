package com.proyecto.BussolaZoe.controller;




import com.proyecto.BussolaZoe.login.UsuarioRoles;
import com.proyecto.BussolaZoe.model.Domicilio;
import com.proyecto.BussolaZoe.model.Odontologo;
import com.proyecto.BussolaZoe.model.Usuario;
import com.proyecto.BussolaZoe.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    private final OdontologoService odontologoService;
    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @GetMapping("")
    public List<Odontologo> findAllOdontologos(){
        logger.debug("Lectura general de la entidad Odontologos");
        return odontologoService.findAllOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo findOdontologoById(@PathVariable Long id){
        logger.debug("Búsqueda en la entidad Odontologos por el ID: " + id);
        return odontologoService.findOdontologoById(id).get();
    }


    @PostMapping("/save")
    public Odontologo saveOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.saveOdontologo(odontologo);
    }

    @PostMapping("/test")
    public Object testOdontologo(){
        Usuario us = new Usuario("Juan", "Perez", "usu","pass", UsuarioRoles.ADMIN );
        Domicilio dm = new Domicilio("Calle","666", "lugar", "prov");
        return odontologoService.saveOdontologo(new Odontologo(123456789,  us, dm,true));
    }


    @PutMapping("/")
    public ResponseEntity updateOdontologo(@RequestBody Odontologo odontologo){

        ResponseEntity response;

        if(odontologoService.findOdontologoById(odontologo.getId()).isPresent()){
            response = new ResponseEntity(odontologoService.updateOdontologo(odontologo), HttpStatus.OK);
            logger.debug("Actualizado Correctamente");
        }else{
            response = new ResponseEntity("Odontologo ID: " + odontologo.getId() + "no encontrado",
                    HttpStatus.NO_CONTENT);
            logger.debug("Actualizacion fallida, Odontologo no encontrado");
        }

        return response;
    }



    @DeleteMapping("/{id}")
    public String deleteOdontologo(@PathVariable Long id){
        return odontologoService.deleteOdontologo(id);
    }




}
