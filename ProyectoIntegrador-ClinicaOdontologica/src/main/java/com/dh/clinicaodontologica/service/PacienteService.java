package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService<Paciente> {


    private final IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public String delete(Long id) {

        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Paciente ID: " + id + " Eliminado";
        }else{
            return "Paciente ID: " + id + " No Encontrado";
        }

    }

    @Override
    public Paciente update(Paciente paciente) {
        Paciente pacienteTmp = pacienteRepository.findById(paciente.getId()).get();
        pacienteTmp.setFechaIngreso(paciente.getFechaIngreso());
        pacienteTmp.setDNI(paciente.getDNI());
        pacienteTmp.setDomicilio(paciente.getDomicilio());
        pacienteTmp.setUsuario(paciente.getUsuario());
        pacienteRepository.save(pacienteTmp);
        return pacienteTmp;

    }


    public Paciente findPacienteByDNI(Integer DNI){
        return pacienteRepository.findPacienteByDNI(DNI);
    }




}
