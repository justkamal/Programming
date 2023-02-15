package DoctorBooking.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConsoleRead implements ReadData {
    private BufferedReader bf;
    private StringTokenizer strz;

    public ConsoleRead() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readData() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
