package br.com.moriapsicologia.medapp.domain.person.patient;

import br.com.moriapsicologia.medapp.infra.exception.ValueNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientRepository {

    public static final String PACIENTE_NAO_ENCONTRADO = "PACIENTE NÃO ENCONTRADO!";

    private final PatientRepositoryJpa patientRepositoryJpa;

    @Override
    public void save(Patient patient) {
        patientRepositoryJpa.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepositoryJpa.findById(id).orElseThrow(() -> new ValueNotFoundException(PACIENTE_NAO_ENCONTRADO));
    }

    @Override
    public List<Patient> findByCpf(String cpf) {
        return patientRepositoryJpa.findByCpf(cpf);
    }

    @Override
    public List<Patient> findByRG(String rg) {
        return patientRepositoryJpa.findByRG(rg);
    }

    @Override
    public Page<Patient> findAllByPageable(Pageable pageable) {
        return patientRepositoryJpa.findAllByDeletedAtIsNull(pageable);
    }

}
