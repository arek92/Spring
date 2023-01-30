package pl.galus.pacjenci.controller;


import jakarta.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.galus.pacjenci.model.PatchPatient;
import pl.galus.pacjenci.model.Patient;
import pl.galus.pacjenci.repository.PatientRepository;

import java.util.List;


@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/getAllPatients")
    public List<Patient> patientList() {
        return patientRepository.findAll();
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);

        return patient;
    }

    @GetMapping("/findPatientById/{id}")
    public Patient findPatientById(@PathVariable Long id) {
        Patient patient = patientRepository.findById(id).get();

        return patient;
    }

    @GetMapping("/deleteAllPatients")
    public List<Patient> deleteAllPatients() {
        patientRepository.deleteAll();
        return patientList();
    }

    @PostMapping("/updatePatientsData/{id}")
    public Patient updatePatientsData(@RequestBody Patient patientUpdated, @PathVariable Long id) {
        Patient patient = patientRepository.findById(id).get();
        if (patient != null) {
            patient.setName(patientUpdated.getName());
            patient.setPesel(patient.getPesel());
            patientRepository.save(patient);
        } else {
            new RuntimeException("Obiektu o id :" + id + " " + " nie ma w bazie danych ");

        }


        return patient;

    }
}
