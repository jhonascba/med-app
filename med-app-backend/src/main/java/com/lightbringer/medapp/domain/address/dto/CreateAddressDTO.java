package com.lightbringer.medapp.domain.address.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateAddressDTO(
        @NotBlank String addressType,
        @NotBlank String name,
        @NotBlank String number,
        String complement,
        @NotBlank String zipCode,
        @NotBlank String state,
        @NotBlank String city
) {
}
