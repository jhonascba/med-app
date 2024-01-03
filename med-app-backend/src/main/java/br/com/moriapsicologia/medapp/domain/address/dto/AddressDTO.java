package br.com.moriapsicologia.medapp.domain.address.dto;

import br.com.moriapsicologia.medapp.domain.address.Address;

public record AddressDTO(
        String addressType,
        String name,
        String number,
        String complement,
        String zipCode,
        String state,
        String city
) {
    public AddressDTO(Address address) {
        this(address.getAddressType(), address.getName(), address.getNumber(), address.getComplement(),
                address.getZipCode(), address.getState(), address.getCity());
    }

}
