package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.Patient;
import br.com.techlead.agendacontato.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Classe de negócio da entidade Patient.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional(readOnly = true)
    public Patient findById(int id) {
        return patientRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Collection<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<Patient> findByName(String name) {
        return patientRepository.findByFirstNameContainsOrLastNameContains(name, name);
    }


    @Transactional
    public Patient save(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Transactional
    public Patient update(Patient patient) {
        Collection<Patient> patients = findAll();
        for (Patient c : patients) {
            if (c.getId().equals(patient.getId())) {
                patientRepository.save(patient);
                return patient;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<Patient> patients = findAll();
        for (Patient c : patients) {
            if (c.getId().equals(id)) {
                patientRepository.delete(id);
                return id;
            }
        }
        return null;
    }

}
