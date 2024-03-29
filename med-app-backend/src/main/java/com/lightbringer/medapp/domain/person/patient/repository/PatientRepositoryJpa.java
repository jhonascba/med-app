package com.lightbringer.medapp.domain.person.patient.repository;

import com.lightbringer.medapp.domain.person.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepositoryJpa extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByDeletedAtIsNull(Pageable pageable);

    @Query("SELECT patient FROM Patient patient " +
            "WHERE patient.cpf = :cpf")
    Patient findByCpf(String cpf);

    @Query("SELECT patient FROM Patient patient " +
            "WHERE patient.rg = :rg")
    Patient findByRG(String rg);

}
