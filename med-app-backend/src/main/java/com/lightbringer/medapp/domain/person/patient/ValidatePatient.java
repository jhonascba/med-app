package com.lightbringer.medapp.domain.person.patient;

import com.lightbringer.medapp.domain.person.DocumentType;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ValidatePatient {

    private String ERRO_AO_SALVAR = "ERRO AO SALVAR! ";
    private String RG_EXISTENTE = "O RG: %s JÁ EXISTE NO(S) PACIENTE(S) DE CÓDIGO(S): ";
    private String CPF_EXISTENTE = "O CPF: %s JÁ EXISTE NO(S) PACIENTE(S) DE CÓDIGO(S): ";

    private final PatientRepository patientRepository;

    public void validateDocument(String document, DocumentType documentType) {
        List<Patient> patientsWithDocument = getPatientsByDocument(document, documentType);
        throwIfExists(document, documentType, patientsWithDocument);
    }

    public void verifyIfDocBelongsToAnotherPatient(Long patientId, String document, DocumentType documentType) {
        List<Patient> patientWithDocument = getPatientsByDocument(document, documentType).stream()
                .filter(patient -> !patient.getId().equals(patientId))
                .toList();
        throwIfExists(document, documentType, patientWithDocument);
    }

    private List<Patient> getPatientsByDocument(String document, DocumentType documentType) {
        return switch (documentType) {
            case CPF -> patientRepository.findByCpf(document);
            case RG -> patientRepository.findByRG(document);
        };
    }

    private void throwIfExists(String document, DocumentType documentType, List<Patient> patientWithDocument) {
        if (!CollectionUtils.isEmpty(patientWithDocument)) {
            String exceptionMessage = buildExceptionMessage(patientWithDocument, document, documentType);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private String buildExceptionMessage(List<Patient> patientsWithDocument, String document, DocumentType documentType) {
        String formattedDocumentMessage = getFormattedDocumentMessage(documentType, document);
        return mapToMessage(patientsWithDocument, formattedDocumentMessage);
    }

    private String getFormattedDocumentMessage(DocumentType documentType, String document) {
        return switch (documentType) {
            case CPF -> ERRO_AO_SALVAR.concat(String.format(CPF_EXISTENTE, document));
            case RG -> ERRO_AO_SALVAR.concat(String.format(RG_EXISTENTE, document));
        };
    }

    private String mapToMessage(List<Patient> patientes, String prefix) {
        return patientes.stream()
                .map(patient -> patient.getId().toString())
                .collect(Collectors.joining(", ", prefix, ". "));
    }

}
