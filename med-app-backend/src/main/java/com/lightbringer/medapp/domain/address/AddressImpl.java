package com.lightbringer.medapp.domain.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressImpl implements AddressRepository {

    private final AddressRepositoryJpa addressRepositoryJpa;

    @Override
    public void save(Address address) {
        addressRepositoryJpa.save(address);
    }

}
