package com.proyecto.BussolaZoe.service;



import com.proyecto.BussolaZoe.model.Turno;
import com.proyecto.BussolaZoe.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService<Turno> {

    private final ITurnoRepository turnoRepository;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> findTurnoById(Long id) {
        return turnoRepository.findById(id);
    }

    public Turno save(Turno t) {
        return turnoRepository.save(t);
    }

    public Turno updateTurno(Turno turnoNew) {
        Turno tur = turnoRepository.findById(turnoNew.getId()).get();
        tur.setFechaHora(turnoNew.getFechaHora());
        tur.setOdontologo(turnoNew.getOdontologo());
        turnoNew.setPaciente(turnoNew.getPaciente());
        turnoRepository.save(tur);
        return tur;
    }

    public String delete(Long id) {
        if (turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
            return "Tuno ID: "+ id +" Eliminado";
        } else {
            return "Turno no encontrado!";
        }
    }
}
