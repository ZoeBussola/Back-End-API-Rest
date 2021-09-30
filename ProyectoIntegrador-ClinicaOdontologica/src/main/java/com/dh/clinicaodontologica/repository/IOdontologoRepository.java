package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo o INNER JOIN Usuario u ON o.usuario.id = u.id WHERE u.usuario = ?1")
    Odontologo findOdontologoByUsername(String userName);

    @Query("SELECT o FROM Odontologo o WHERE o.numeroMatricula = ?1")
    Odontologo findOdontologoByNumeroMatricula(Integer numeroMatricula);




}
