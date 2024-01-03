package br.com.moriapsicologia.medapp.domain.person.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientRepository {

    void save(Patient patient);

    Patient findById(Long id);

    List<Patient> findByCpf(String cpf);

    List<Patient> findByRG(String rg);

    Page<Patient> findAllByPageable(Pageable pageable);

}
