package com.proyecto.BussolaZoe.service;

import com.proyecto.BussolaZoe.model.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService<T> {

    /* ================= Métodos ================= */

    List<Odontologo> findAllOdontologos();
    Optional<Odontologo> findOdontologoById(Long id);
    Odontologo saveOdontologo(Odontologo odontologo);
    String deleteOdontologo(Long id);
    T updateOdontologo(Odontologo odontologo);


}