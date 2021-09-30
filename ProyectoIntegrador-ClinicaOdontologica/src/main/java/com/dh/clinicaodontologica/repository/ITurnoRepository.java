package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Odontologo;
import com.dh.clinicaodontologica.model.Turno;
import com.dh.clinicaodontologica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {

   /* @Query("SELECT t FROM Turnos t WHERE p.ID_TURNO = ?1")
    Turno findTurnoById(int id);*/

}
