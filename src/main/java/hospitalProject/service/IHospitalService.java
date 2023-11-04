package hospitalProject.service;

import hospitalProject.entities.Consultation;
import hospitalProject.entities.Medecin;
import hospitalProject.entities.Patient;
import hospitalProject.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
