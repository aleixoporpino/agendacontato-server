package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Collection<Patient> findByFirstNameContainsOrLastNameContains(String name, String lastName);
}
