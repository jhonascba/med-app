package com.lightbringer.medapp.domain.address;

import com.lightbringer.medapp.domain.address.dto.CreateAddressDTO;
import com.lightbringer.medapp.domain.address.dto.UpdateAddressDTO;
import com.lightbringer.medapp.domain.person.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
@Table(schema = "med_api", name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressType;
    private String name;
    private String number;
    private String complement;
    private String zipCode;
    private String state;
    private String city;

    @OneToOne(mappedBy = "address")
    private Patient patient;

    @CreationTimestamp
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    protected LocalDateTime deletedAt;

    public Address(CreateAddressDTO createAddressDTO) {
        this.addressType = createAddressDTO.addressType();
        this.name = createAddressDTO.name();
        this.number = createAddressDTO.number();
        this.complement = createAddressDTO.complement();
        this.zipCode = createAddressDTO.zipCode();
        this.state = createAddressDTO.state();
        this.city = createAddressDTO.city();
    }

    public void update(UpdateAddressDTO address) {
        this.addressType = address.addressType();
        this.name = address.name();
        this.number = address.number();
        this.complement = address.complement();
        this.zipCode = address.zipCode();
        this.state = address.state();
        this.city = address.city();
    }

}
