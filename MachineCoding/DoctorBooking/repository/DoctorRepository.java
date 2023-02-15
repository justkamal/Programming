package DoctorBooking.repository;

import DoctorBooking.exceptions.DoctorNotFoundException;
import DoctorBooking.model.Doctor;

import java.util.HashMap;

public class DoctorRepository {

    private static HashMap<String, Doctor> doctorDB;

    public DoctorRepository() {
        doctorDB = new HashMap<>();
    }

    public void add(Doctor doctor) {
        doctorDB.put(doctor.getName(), doctor);
    }

    public void remove(String name) {
        if (doctorDB.containsKey(name))
            doctorDB.remove(name);
        else
            throw new DoctorNotFoundException("No doctor with name: " + name + " was found !");
    }

}
