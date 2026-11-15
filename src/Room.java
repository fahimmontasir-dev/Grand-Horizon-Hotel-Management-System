
public abstract class Room {

    private int roomNumber;
    private int floorNumber;
    private double pricePerNight;
    private boolean available;

    // Constructor
    public Room(int roomNumber, int floorNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Each room category defines its own type
    public abstract String getRoomType();

    // Display room information
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Floor: " + floorNumber);
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Price per Night: €" + pricePerNight);
        System.out.println("Status: " + (available ? "Available" : "Occupied"));
    }
}
