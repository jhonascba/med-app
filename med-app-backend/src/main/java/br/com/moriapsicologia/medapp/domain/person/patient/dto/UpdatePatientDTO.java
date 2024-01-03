package br.com.moriapsicologia.medapp.domain.person.patient.dto;

import br.com.moriapsicologia.medapp.domain.address.dto.UpdateAddressDTO;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record UpdatePatientDTO(
        Long patientId,
        String name,
        String lastname,
        LocalDate birthdate,
        String rg,
        String motherName,
        String fatherName,
        String phoneNumber1,
        String phoneNumber2,
        @Email String email,
        boolean active,
        UpdateAddressDTO address
){
}
