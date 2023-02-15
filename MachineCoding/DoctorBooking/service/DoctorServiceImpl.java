package DoctorBooking.service;

import DoctorBooking.model.Doctor;
import DoctorBooking.model.common.Specialization;
import DoctorBooking.model.common.TimeSlot;
import DoctorBooking.repository.DoctorRepository;
import DoctorBooking.util.ConsolePrint;
import DoctorBooking.util.ConsoleRead;

import java.util.Arrays;


public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private ConsolePrint consolePrint;
    private ConsoleRead consoleRead;

    public DoctorServiceImpl() {
        doctorRepository = new DoctorRepository();
        consolePrint = new ConsolePrint();
        consoleRead = new ConsoleRead();
    }

    @Override
    public Doctor register() {
        consolePrint.printData("Enter doctor name: ");
        String name = consoleRead.readData();
        consolePrint.printData("Enter doctor specialization from " + Arrays.stream(Specialization.values()));
        String specialization = consoleRead.readData();
        Doctor doctor = new Doctor(name, Specialization.valueOf(specialization));
        doctorRepository.add(doctor);
        return doctor;
    }

    @Override
    public boolean addTimeSlot(Doctor doctor, TimeSlot timeSlot) {

        //check timeslot validity

        doctor.getAvailability().add(timeSlot);
        return true;
    }
}
