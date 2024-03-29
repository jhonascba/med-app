package com.lightbringer.medapp.domain.person.patient.service;

import com.lightbringer.medapp.domain.person.DocumentType;
import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.dto.UpdatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import com.lightbringer.medapp.domain.person.validation.ValidateDocumentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePatient {

    private final PatientRepository patientRepository;
    private final ValidateDocumentFactory validateDocumentFactory;

    public void update(UpdatePatientDTO updatePatientDTO) {
        Long patientId = updatePatientDTO.patientId();
        //it checks if there is another patient with the same RG document, because this document can be changed.
        validateDocumentFactory.getValidator(DocumentType.RG).validateDocument(updatePatientDTO.rg());
        Patient patient = patientRepository.findById(patientId);
        patient.update(updatePatientDTO);
        patientRepository.save(patient);
    }

}
