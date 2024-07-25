package com.lightbringer.medapp.domain.person.patient.dto;

import com.lightbringer.medapp.domain.address.dto.CreateAddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CreatePatientDTO(
        @NotBlank String name,
        @NotBlank String lastname,
        @NotNull LocalDate birthdate,
        String rg,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
        @NotBlank String motherName,
        String fatherName,
        @NotBlank String phoneNumber1,
        String phoneNumber2,
        @Email String email,
        @NotNull Boolean active,
        @Valid CreateAddressDTO address
){
}
