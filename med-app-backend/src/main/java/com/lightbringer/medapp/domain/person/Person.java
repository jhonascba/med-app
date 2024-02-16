package com.lightbringer.medapp.domain.person;

import com.lightbringer.medapp.domain.address.Address;
import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String name;
    protected String lastname;
    protected LocalDate birthdate;
    protected String rg;
    protected String cpf;
    protected String phoneNumber1;
    protected String phoneNumber2;
    protected String email;
    protected boolean active;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    protected Address address;

    protected String motherName;
    protected String fatherName;

    @CreationTimestamp
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    protected LocalDateTime deletedAt;

    protected Person(CreatePatientDTO createPatientDTO) {
        this.name = createPatientDTO.name();
        this.lastname = createPatientDTO.lastname();
        this.birthdate = createPatientDTO.birthdate();
        this.rg = createPatientDTO.rg();
        this.cpf = createPatientDTO.cpf();
        this.phoneNumber1 = createPatientDTO.phoneNumber1();
        this.phoneNumber2 = createPatientDTO.phoneNumber2();
        this.email = createPatientDTO.email();
        this.active = createPatientDTO.active();
        this.address = new Address(createPatientDTO.address());
        this.motherName = createPatientDTO.motherName();
        this.fatherName = createPatientDTO.fatherName();
    }

    public abstract void delete();

}
