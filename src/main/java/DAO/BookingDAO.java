package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingDAO {
	private static Connection connection= DBConnector.getInstance();

	public static void insertion(Booking booking) {
		/**
		 * This method allows to insert a new booking into the DB
		 * Return void
		 */
		String sql="INSERT INTO booking (username,room_number,booking_date,booking_end_date,price,card_number) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, booking.getUser().getUsername());
			statement.setInt(2, booking.getRoom().getRoomNumber());
			statement.setDate(3, booking.getStartDate());
			statement.setDate(4, booking.getEndDate());
			statement.setDouble(5, booking.getPrice());
			statement.setInt(6, booking.getCardNumber());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());;
		}
	}
	public static ObservableList<Booking> getAllHistory(String username) throws SQLException {
        ObservableList<Booking> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM booking WHERE username= ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
        	ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Booking(rs.getInt(2), rs.getDate(3),rs.getDate(4), rs.getDouble(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return list;
    }
}
