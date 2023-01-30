package pl.galus.pacjenci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.galus.pacjenci.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
