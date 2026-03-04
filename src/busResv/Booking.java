package busResv;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	
    private static int bookingCounter = 1121;

    private final int bookingNumber;
    private String passengerName;
    private int busNo;
    private Date date;

    public Booking() {
    	this.bookingNumber = bookingCounter++;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of passenger: ");
       
        this.passengerName = scanner.next();

        System.out.print("Enter bus no: ");
        this.busNo = scanner.nextInt();

        
        System.out.print("Enter date (dd-MM-yyyy): ");
        String dateInput = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {

            this.date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again with dd-MM-yyyy.");
            
            this.date = null;
        }
    }

  
    public boolean isAvailable(List<Booking> bookings, List<bus> buses) {
        if (date == null) {
            return false; // invalid date input earlier
        }

        // Find the bus and get capacity
        Integer capacity = null;
        for (bus b : buses) {
            if (b.getBusNo() == this.busNo) {
                capacity = b.getCapacity();
                break;
            }
        }

        if (capacity == null) {
            System.out.println("Bus number " + busNo + " does not exist.");
            return false;
        }

 
        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == this.busNo && sameDay(b.date, this.date)) {
                booked++;
            }
        }

        return booked < capacity;
    }

    
    public static void cancelBooking(List<Booking> bookings) {
        if (bookings.isEmpty()) {
            System.out.println("No bookings to cancel.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter booking number to cancel: ");
        int bno = scanner.nextInt();

        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking c = it.next();
            if (c.bookingNumber == bno) {
                it.remove();
                System.out.println("Booking " + bno + " is cancelled successfully.");
                return;
            }
        }
        System.out.println("Booking number not found.");
    }

    
    private static boolean sameDay(Date d1, Date d2) {
        if (d1 == null || d2 == null) return false;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

    public int getBookingNumber() { return bookingNumber; }
    public String getPassengerName() { return passengerName; }
    public int getBusNo() { return busNo; }
    public Date getDate() { return date; }
}