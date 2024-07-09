package DAO;

public class RoomData {
	private static RoomData instance;
    private int roomNumber;
  

    private RoomData() {}

    public static RoomData getInstance() {
        if (instance == null) {
            instance = new RoomData();
        }
        return instance;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    
}
