package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDAO {
	private static Connection connection= DBConnector.getInstance();

	public static Room selectionRoom(int roomNumber) {

		ResultSet rs=null;
		Room room=null;
		String sql="SELECT * FROM room WHERE number= ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, roomNumber);
			rs= statement.executeQuery();
			if (rs.next()) {
				String classRoom=rs.getString(2);
				Double priceNignt=rs.getDouble(3);
				String availability=rs.getString(4);

				room=new Room(roomNumber,classRoom,priceNignt,availability);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return room ;
	}
	public static ObservableList<Room> getAllRooms() throws SQLException {
        ObservableList<Room> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM room";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return list;
    }
	public static boolean updateRoomAvailability(Room room) throws SQLException {
		/**
		 * This method allows to update the room availability 
		 * Return boolean
		 */
		boolean success = false;
		
		try {
        	String query = "UPDATE room SET availability = 0 WHERE number = ?";
        	room.setAvailability("0");
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return success;
	}
	
}
