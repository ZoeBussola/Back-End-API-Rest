package com.dh.clinicaodontologica.service;
import java.util.List;
import java.util.Optional;

public interface ITurnoService<T> {
    List<T> findAll();
    Optional<T> findTurnoById(Long id);
    T save (T t);
    String delete(Long id);
    T updateTurno(T t);
}
