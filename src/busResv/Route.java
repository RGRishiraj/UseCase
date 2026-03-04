package busResv;

public class Route {
    private String pickupPoint;
    private String destination;

    public Route(String pickupPoint, String destination) {
        this.pickupPoint = pickupPoint;
        this.destination = destination;
    }

    public void displayRoute() {
        System.out.println("Pickup Point: " + pickupPoint);
        System.out.println("Destination: " + destination);
    }
}
