package com.proyecto.BussolaZoe.repository;


import com.proyecto.BussolaZoe.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
/*
    @Query("SELECT o FROM odontologos o INNER JOIN Usuarios u ON o.usuarios.id = u.id WHERE u.usuarios = ?1")
    Odontologo findOdontologoByUsername(String userName);

    @Query("SELECT o FROM odontologos o WHERE o.numeroMatricula = ?1")
    Odontologo findOdontologoByNumeroMatricula(Integer numeroMatricula);
*/



}
