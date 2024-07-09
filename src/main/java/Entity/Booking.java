package Entity;

import java.sql.Date;

public class Booking {
	private User user;
    private Room room;
    private int roomNumber;
    private Date startDate;
    private Date endDate;
    private double price;
    private int cardNumber;
	public Booking(User user, Room room, Date startDate, Date endDate, double price, int cardNumber) {
		super();
		this.user = user;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.cardNumber = cardNumber;
	}
	public Booking(int roomNumber, Date startDate, Date endDate, double price, int cardNumber) {
		this.roomNumber = roomNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.cardNumber = cardNumber;
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

    
}
