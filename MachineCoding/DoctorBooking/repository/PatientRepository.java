package DoctorBooking.repository;

import DoctorBooking.exceptions.PatientNotFoundException;
import DoctorBooking.model.Patient;


import java.util.HashMap;

public class PatientRepository {
    private static HashMap<String, Patient> patientDB;

    public PatientRepository() {
        patientDB = new HashMap<>();
    }

    public void add(Patient patient) {
        patientDB.put(patient.getName(), patient);
    }

    public void remove(String name) {
        if (patientDB.containsKey(name))
            patientDB.remove(name);
        else
            throw new PatientNotFoundException("No patient with name: " + name + " was found !");
    }
}
