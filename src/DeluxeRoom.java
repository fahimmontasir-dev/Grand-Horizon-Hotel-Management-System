
public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber, 900.00);
    }

    @Override
    public String getRoomType() {
        return "Deluxe";
    }
}
