package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

    @Query("SELECT p FROM Paciente p WHERE p.DNI = ?1")
    Paciente findPacienteByDNI(Integer DNI);

}
