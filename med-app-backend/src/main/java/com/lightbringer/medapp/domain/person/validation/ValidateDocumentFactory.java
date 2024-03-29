package com.lightbringer.medapp.domain.person.validation;

import com.lightbringer.medapp.domain.person.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateDocumentFactory {

    private final ValidateCPF validateCPF;
    private final ValidateRG validateRG;

    public ValidateDocument getValidator(DocumentType documentType) {
        return switch (documentType) {
            case RG -> validateRG;
            case CPF -> validateCPF;
        };
    }

}
