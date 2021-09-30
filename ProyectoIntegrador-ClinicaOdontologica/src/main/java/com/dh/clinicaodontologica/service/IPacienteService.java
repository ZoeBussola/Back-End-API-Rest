package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService<T> {

    /* ================ Métodos ================= */

    List<T> findAll();
    Optional<T> findPacienteById(Long id);
    T save (T t);
    String delete(Long id);
    Paciente update(T t);

}
