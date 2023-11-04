package hospitalProject.web;

import hospitalProject.repositories.PatientRepository;
import hospitalProject.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patient")
    public List<Patient> patientList(){
        return patientRepository.findAll();

    }
}
