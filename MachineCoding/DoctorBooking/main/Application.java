package DoctorBooking.main;


import DoctorBooking.model.Doctor;
import DoctorBooking.model.Hospital;
import DoctorBooking.model.Patient;
import DoctorBooking.model.common.Specialization;

public class Application {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Doctor sukhdeepDoc = new Doctor("Sukhdeep", Specialization.CARDIOLOGIST);
        Doctor kamalDoc = new Doctor("Kamal", Specialization.CARDIOLOGIST);
        Doctor vinayDoc =  new Doctor("Vinay", Specialization.DERMATOLOGIST);

        Patient patientVijay =  new Patient("Vijay");
        Patient patientKaran =  new Patient("Karan");
    }
}
