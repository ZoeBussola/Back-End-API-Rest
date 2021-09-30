package com.dh.clinicaodontologica;

import com.dh.clinicaodontologica.model.*;
import com.dh.clinicaodontologica.service.IOdontologoService;
import com.dh.clinicaodontologica.service.IPacienteService;
import com.dh.clinicaodontologica.service.ITurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProyectoIntegradorClinicaOdontologicaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    IPacienteService pacienteService;
    IOdontologoService odontologoService;
    ITurnoService turnoService;

    @Test
    public void testSavePaciente()
    {
        Usuario us = new Usuario("Juan", "Peres", "usu", "134");
        Domicilio dm = new Domicilio("Calle","666", "estelugar", "estaprovincia");
        pacienteService.save(new Paciente(123456789, 1354, dm, us));

    }
    @Test
    public void testSaveOdontologo()
    {
        Usuario us = new Usuario("Juan", "Perez", "usu", "1234");
        Domicilio dm = new Domicilio("Calle","666", "lugar", "prov");odontologoService.saveOdontologo(new Odontologo(123456789,  us, dm,true));

    }
    @Test
    public void testSaveTurno()
    {
        Usuario us = new Usuario("Tomas","apellido","usu","134");
        Domicilio dm =new Domicilio("Calle","134","Este Lugar","Provincia");
        Odontologo od = new Odontologo(1234,us,dm,true);
        Paciente pc = new Paciente(54236695, 135,dm,us);
        odontologoService.saveOdontologo(od);
        pacienteService.save(pc);
        turnoService.save(new Turno(od,pc, 12346));

    }
}
