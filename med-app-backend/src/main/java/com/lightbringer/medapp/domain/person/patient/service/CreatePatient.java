package com.lightbringer.medapp.domain.person.patient.service;

import com.lightbringer.medapp.domain.person.DocumentType;
import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.PatientDTO;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import com.lightbringer.medapp.domain.person.validation.ValidateDocumentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePatient {

    private final PatientRepository patientRepository;
    private final ValidateDocumentFactory validateDocumentFactory;

    public PatientDTO create(CreatePatientDTO createPatientDTO) {
        validatePatientDocuments(createPatientDTO.cpf(), createPatientDTO.rg());
        Patient patient = new Patient(createPatientDTO);
        patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    private void validatePatientDocuments(String cpf, String rg) {
        validateDocumentFactory.getValidator(DocumentType.CPF).validateDocument(cpf);
        validateDocumentFactory.getValidator(DocumentType.RG).validateDocument(rg);
    }

}
