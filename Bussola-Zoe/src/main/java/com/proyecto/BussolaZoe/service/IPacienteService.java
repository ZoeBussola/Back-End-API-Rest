package com.proyecto.BussolaZoe.service;


import com.proyecto.BussolaZoe.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService<T> {

    List<T> findAll();
    Optional<T> findPacienteById(Long id);
    T save(T t);
    String delete(Long id);
    Paciente update(T t);

}
