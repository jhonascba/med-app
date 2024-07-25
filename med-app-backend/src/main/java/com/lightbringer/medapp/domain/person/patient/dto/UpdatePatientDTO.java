package com.lightbringer.medapp.domain.person.patient.dto;

import com.lightbringer.medapp.domain.address.dto.UpdateAddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdatePatientDTO(
        @NotNull Long patientId,
        @NotBlank String name,
        @NotBlank String lastname,
        @NotNull LocalDate birthdate,
        String rg,
        @NotBlank String motherName,
        String fatherName,
        @NotBlank String phoneNumber1,
        String phoneNumber2,
        @Email String email,
        @NotNull Boolean active,
        @Valid UpdateAddressDTO address
){
}
