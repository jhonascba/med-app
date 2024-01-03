package br.com.moriapsicologia.medapp.domain.address.dto;

public record UpdateAddressDTO(
        String addressType,
        String name,
        String number,
        String complement,
        String zipCode,
        String state,
        String city
) {
}
