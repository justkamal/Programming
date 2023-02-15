package DoctorBooking.model;

import DoctorBooking.service.DoctorService;
import DoctorBooking.service.DoctorServiceImpl;
import DoctorBooking.service.PatientService;
import DoctorBooking.service.PatientServiceImpl;
import lombok.Getter;
import lombok.Setter;
import DoctorBooking.model.common.TimeSlot;
import DoctorBooking.model.common.Specialization;

import java.util.*;

@Getter
@Setter
public class Hospital {
    private HashMap<Specialization, List<Doctor>> docCategoryMap;
    private Map<Patient, Doctor> appointment;
    private DoctorService doctorService;
    private PatientService patientService;

    public Hospital() {
        docCategoryMap = new HashMap<>();
        for (Specialization speciality : Specialization.values()) {
            docCategoryMap.put(speciality, new ArrayList<>());
        }
        appointment = new HashMap<>();

        doctorService = new DoctorServiceImpl();
        patientService = new PatientServiceImpl();
    }

    public void registerDoctor() {
        Doctor doc = doctorService.register();
        docCategoryMap.get(doc.getSpecialization()).add(doc);
    }

    /*public boolean makeBookingIfAvailable(Doctor doc, Slot slot) {
        if (checkSlotValidity(slot)) {

            return true;
        }
        return false;
    }

    public boolean makeAppointmentIfAvailable(Doctor doc, Slot slot) {
        if (checkSlotValidity(booking.stream().toList()., slot)) {

            return true;
        }
        return false;
    }*/

    private boolean checkSlotValidity(Long[] slot, TimeSlot targetSlot) {
        if (targetSlot.getClockIn().getTime() < targetSlot.getMinClockIn().getTime()
                || targetSlot.getClockOut().getTime() > targetSlot.getMaxClockOut().getTime()) {
            return false;
        }

        int low = 0;
        int high = slot.length;
        long target = targetSlot.getClockIn().getTime();
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            if (slot[mid] == target) {
                return false;
            } else if (slot[mid] < slot[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return true;
    }
}
