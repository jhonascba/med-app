package com.lightbringer.medapp.domain.person.validation;

import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ValidateRG implements ValidateDocument {

    private String ERRO_AO_SALVAR = "ERRO AO SALVAR! O RG: %s JÁ EXISTE NO PACIENTE DE CÓDIGO: %s.";

    private final PatientRepository patientRepository;

    @Override
    public void validateDocument(String document) {
        Patient patientWithDocument = patientRepository.findByRG(document);
        if (nonNull(patientWithDocument)) {
            String exceptionMessage = buildExceptionMessage(patientWithDocument, document);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private String buildExceptionMessage(Patient patientWithDocument, String document) {
        return String.format(ERRO_AO_SALVAR, document, patientWithDocument.getId());
    }

}
