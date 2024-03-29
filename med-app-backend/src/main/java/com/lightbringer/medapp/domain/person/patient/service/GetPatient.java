package com.lightbringer.medapp.domain.person.patient.service;

import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.dto.PatientDTO;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPatient {

    private final PatientRepository patientRepository;

    public PatientDTO findById(Long id) {
        Patient patient = patientRepository.findById(id);
        return new PatientDTO(patient);
    }

    public Page<PatientDTO> findByPageble(Pageable pageable) {
        Page<Patient> patientsByPage = patientRepository.findAllByPageable(pageable);
        return patientsByPage.map(PatientDTO::new);
    }

}
