package DoctorBooking.service;

import DoctorBooking.model.Doctor;
import DoctorBooking.model.common.TimeSlot;

public interface PatientService {

    void rateDoctor(Doctor doctor, Integer rating);

    void showAppointments(String name);

    void cancelAppointment(Doctor doctor, TimeSlot timeSlot);
}
