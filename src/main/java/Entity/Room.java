package Entity;

public class Room {
	private int roomNumber;
	private String availability; // 0 for no, 1 for yes
    private String roomClass; // Class A,B or C
    private double pricePerNight;
	public Room(int roomNumber, String roomClass, double pricePerNight,String availability) {
		super();
		this.roomNumber = roomNumber;
		this.roomClass = roomClass;
		this.pricePerNight = pricePerNight;
		this.availability = availability;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getRoomClass() {
		return roomClass;
	}
	public void setRoomClass(String roomClass) {
		this.roomClass = roomClass;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

    
}
