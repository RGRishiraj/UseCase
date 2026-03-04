package busResv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
    private Date date;
    private String time;

    public Schedule(Date date, String time) {
        this.date = date;
        this.time = time;
    }

    public void displaySchedule() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Travel Date: " + df.format(date));
        System.out.println("Departure Time: " + time);
    }
}
