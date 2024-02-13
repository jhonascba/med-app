package com.lightbringer.medapp.domain.person.patient;

import com.lightbringer.medapp.domain.person.Person;
import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.UpdatePatientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Where(clause = "deleted_at IS NULL")
@Table(schema = "med_api", name = "tb_patient")
public class Patient extends Person {

    public Patient(CreatePatientDTO createPatientDTO) {
        super(createPatientDTO);
    }

    public void update(UpdatePatientDTO updatePatientDTO) {
        super.name = updatePatientDTO.name();
        super.lastname = updatePatientDTO.lastname();
        super.birthdate = updatePatientDTO.birthdate();
        super.rg = updatePatientDTO.rg();
        super.motherName = updatePatientDTO.motherName();
        super.fatherName = updatePatientDTO.fatherName();
        super.phoneNumber1 = updatePatientDTO.phoneNumber1();
        super.phoneNumber2 = updatePatientDTO.phoneNumber2();
        super.email = updatePatientDTO.email();
        super.active = updatePatientDTO.active();
        super.address.update(updatePatientDTO.address());
    }

    @Override
    public void delete() {
        super.deletedAt = LocalDateTime.now();
    }

}
