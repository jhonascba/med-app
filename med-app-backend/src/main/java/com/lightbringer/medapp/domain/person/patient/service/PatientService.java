package com.lightbringer.medapp.domain.person.patient.service;

import com.lightbringer.medapp.domain.person.DocumentType;
import com.lightbringer.medapp.domain.person.patient.Patient;
import com.lightbringer.medapp.domain.person.patient.ValidatePatient;
import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.PatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.UpdatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final ValidatePatient validatePatient;
    private final PatientRepository patientRepository;

    public PatientDTO create(CreatePatientDTO createPatientDTO) {
        validatePatient.validateDocument(createPatientDTO.cpf(), DocumentType.CPF);
        validatePatient.validateDocument(createPatientDTO.rg(), DocumentType.RG);
        Patient patient = new Patient(createPatientDTO);
        patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    public PatientDTO findById(Long id) {
        Patient patient = patientRepository.findById(id);
        return new PatientDTO(patient);
    }

    public void update(UpdatePatientDTO updatePatientDTO) {
        Long patientId = updatePatientDTO.patientId();
        validatePatient.verifyIfDocBelongsToAnotherPatient(patientId, updatePatientDTO.rg(), DocumentType.RG);
        Patient patient = patientRepository.findById(patientId);
        patient.update(updatePatientDTO);
        patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        Patient patient = patientRepository.findById(id);
        patient.delete();
        patientRepository.save(patient);
    }

    public Page<PatientDTO> findByPageble(Pageable pageable) {
        Page<Patient> patientsByPage = patientRepository.findAllByPageable(pageable);
        return patientsByPage.map(PatientDTO::new);
    }

}
