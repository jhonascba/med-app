package br.com.moriapsicologia.medapp.domain.person.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepositoryJpa extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByDeletedAtIsNull(Pageable pageable);

    @Query("SELECT patient FROM Patient patient " +
            "WHERE patient.deletedAt IS NULL " +
            "AND patient.cpf = :cpf")
    List<Patient> findByCpf(@Param("cpf") String cpf);

    @Query("SELECT patient FROM Patient patient " +
            "WHERE patient.deletedAt IS NULL " +
            "AND patient.rg = :rg")
    List<Patient> findByRG(String rg);

}
