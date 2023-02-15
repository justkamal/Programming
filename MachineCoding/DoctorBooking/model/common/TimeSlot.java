package DoctorBooking.model.common;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class TimeSlot {
    public static final DateFormat sdf = new SimpleDateFormat("hh:mm aa");
    private final Date minClockIn = sdf.parse("09:00 am");
    private final Date maxClockOut = sdf.parse("09:00 pm");
    private Date clockIn;
    private Date clockOut;
    private boolean isActive;

    public TimeSlot(Date clockIn, Date clockOut) throws ParseException {
        this.clockIn = clockIn;
        this.clockOut = clockOut;
    }
}
