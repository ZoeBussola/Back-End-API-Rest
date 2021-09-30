package com.dh.clinicaodontologica.service;



import com.dh.clinicaodontologica.model.Odontologo;
import com.dh.clinicaodontologica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService<Odontologo>{


    private IOdontologoRepository odontologoRepository;

    public IOdontologoRepository getOdontologoRepository() {
        return odontologoRepository;
    }

    public void setOdontologoRepository(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public List<Odontologo> findAllOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findOdontologoById(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo saveOdontologo(Odontologo odontologo) {
            return odontologoRepository.save(odontologo);

    }

    @Override
    public String deleteOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
            return "Odontologo ID: "+ id +" Eliminado";
        } else {
            return "Odontologo no encontrado!";
        }
    }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologoNew) {
        Odontologo odon = odontologoRepository.findById(odontologoNew.getId()).get();
        odon.setNumeroMatricula(odontologoNew.getNumeroMatricula());
        odon.setUsuario(odontologoNew.getUsuario());
        odon.setDomicilio(odontologoNew.getDomicilio());
        odontologoRepository.save(odon);
        return odon;
    }


    public Odontologo findOdontologoByUsername(String username){
        return odontologoRepository.findOdontologoByUsername(username);
    }



    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
}
