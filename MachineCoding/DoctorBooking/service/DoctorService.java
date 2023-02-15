package DoctorBooking.service;

import DoctorBooking.model.Doctor;
import DoctorBooking.model.common.TimeSlot;


public interface DoctorService {
    Doctor register();

    boolean addTimeSlot(Doctor doctor, TimeSlot timeSlot);
}
