package com.proyecto.BussolaZoe.repository;


import com.proyecto.BussolaZoe.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {

   /* @Query("SELECT t FROM Turnos t WHERE p.ID_TURNO = ?1")
    Turno findTurnoById(int id);*/

}
