package DoctorBooking.service;

import DoctorBooking.model.Doctor;
import DoctorBooking.model.common.TimeSlot;
import DoctorBooking.repository.DoctorRepository;
import DoctorBooking.repository.PatientRepository;

public class PatientServiceImpl implements PatientService{

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public PatientServiceImpl(){
        //doctorRepository = new
    }

    @Override
    public void rateDoctor(Doctor doctor, Integer rating) {
        doctor.setRating((doctor.getRating() + rating)/2);
    }

    @Override
    public void showAppointments(String name) {

    }

    @Override
    public void cancelAppointment(Doctor doctor, TimeSlot timeSlot) {

    }
}
