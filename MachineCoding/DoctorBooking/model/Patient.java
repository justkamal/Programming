package DoctorBooking.model;

import lombok.Getter;
import lombok.Setter;
import DoctorBooking.model.common.TimeSlot;

import java.util.Map;

@Getter
@Setter
public class Patient {
    private String name;
    private Map<Doctor, TimeSlot> appointment;

    public Patient(String name){
        this.name = name;
    }
}
