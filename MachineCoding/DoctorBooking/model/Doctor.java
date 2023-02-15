package DoctorBooking.model;

import lombok.Getter;
import lombok.Setter;
import DoctorBooking.model.common.TimeSlot;
import DoctorBooking.model.common.Specialization;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class Doctor implements Comparator<Doctor> {
    private String name;
    private Specialization specialization;
    private List<TimeSlot> availability;
    private int rating;

    public Doctor(String name, Specialization specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public int compare(Doctor d1, Doctor d2) {
        return d1.rating - d2.rating;
    }
}
