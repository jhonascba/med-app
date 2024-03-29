package com.lightbringer.medapp.controller;

import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.PatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.UpdatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.service.CreatePatient;
import com.lightbringer.medapp.domain.person.patient.service.DeletePatient;
import com.lightbringer.medapp.domain.person.patient.service.GetPatient;
import com.lightbringer.medapp.domain.person.patient.service.UpdatePatient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final GetPatient getPatient;
    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;
    private final DeletePatient deletePatient;

    @GetMapping
    public ResponseEntity<Page<PatientDTO>> list(@PageableDefault(page = 0, size = 20, sort = {"name"}) Pageable pageable) {
        Page<PatientDTO> patientsPage = getPatient.findByPageble(pageable);
        return ResponseEntity.ok(patientsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> find(@PathVariable Long id) {
        PatientDTO patient = getPatient.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@Valid @RequestBody CreatePatientDTO createPatientDTO, UriComponentsBuilder uriComponentsBuilder) {
        PatientDTO patient = createPatient.create(createPatientDTO);
        URI uri = uriComponentsBuilder.path("patients/{id}").buildAndExpand(patient.id()).toUri();
        return ResponseEntity.created(uri).body(patient);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody UpdatePatientDTO updatePatientDTO) {
        updatePatient.update(updatePatientDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePatient.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
