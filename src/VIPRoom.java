
public class VIPRoom extends Room {

    public VIPRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber, 1500.00);
    }

    @Override
    public String getRoomType() {
        return "VIP";
    }
}
