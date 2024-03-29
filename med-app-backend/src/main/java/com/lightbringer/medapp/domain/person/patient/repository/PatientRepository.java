package com.lightbringer.medapp.domain.person.patient.repository;

import com.lightbringer.medapp.domain.person.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepository {

    void save(Patient patient);

    Patient findById(Long id);

    Patient findByCPF(String cpf);

    Patient findByRG(String rg);

    Page<Patient> findAllByPageable(Pageable pageable);

}
