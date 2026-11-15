public class StandardRoom extends Room {

    public StandardRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber, 650.00);
    }

    @Override
    public String getRoomType() {
        return "Standard";
    }
}