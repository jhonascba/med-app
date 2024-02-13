package com.lightbringer.medapp.domain.person.patient.dto;

import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.address.dto.AddressDTO;

import java.time.LocalDate;

public record PatientDTO(

        Long id,
        String name,
        String lastname,
        LocalDate birthdate,
        String rg,
        String cpf,
        String phoneNumber1,
        String phoneNumber2,
        boolean active,
        AddressDTO addressDTO
) {
    public PatientDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getLastname(), patient.getBirthdate(), patient.getRg(),
                patient.getCpf(), patient.getPhoneNumber1(), patient.getPhoneNumber2(),
                patient.isActive(), new AddressDTO(patient.getAddress()));
    }

}
