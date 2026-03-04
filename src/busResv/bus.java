package busResv;

// Class 2: Bus
public class bus {
    private int busNo;
    private String driverName;
    private boolean ac;
    private int capacity;

    bus(int no, String driver, boolean ac, int cap) {
        this.busNo = no;
        this.driverName = driver;
        this.ac = ac;
        this.capacity = cap;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean isAC() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " | Driver: " + driverName +
                " | AC: " + ac + " | Capacity: " + capacity);
    }
}
