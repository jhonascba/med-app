package com.lightbringer.medapp.controller;

import com.lightbringer.medapp.domain.person.patient.service.PatientService;
import com.lightbringer.medapp.domain.person.patient.dto.CreatePatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.PatientDTO;
import com.lightbringer.medapp.domain.person.patient.dto.UpdatePatientDTO;
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

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<Page<PatientDTO>> list(@PageableDefault(page = 0, size = 20, sort = {"name"}) Pageable pageable) {
        Page<PatientDTO> patientsPage = patientService.findByPageble(pageable);
        return ResponseEntity.ok(patientsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> find(@PathVariable Long id) {
        PatientDTO patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@Valid @RequestBody CreatePatientDTO createPatientDTO, UriComponentsBuilder uriComponentsBuilder) {
        PatientDTO patient = patientService.create(createPatientDTO);
        URI uri = uriComponentsBuilder.path("patients/{id}").buildAndExpand(patient.id()).toUri();
        return ResponseEntity.created(uri).body(patient);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody UpdatePatientDTO updatePatientDTO) {
        patientService.update(updatePatientDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
