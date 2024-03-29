package com.lightbringer.medapp.domain.person.patient.service;

import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePatient {

    private final PatientRepository patientRepository;

    public void deleteById(Long id) {
        Patient patient = patientRepository.findById(id);
        patient.delete();
        patientRepository.save(patient);
    }

}
