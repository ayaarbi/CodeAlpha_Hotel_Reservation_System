package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import Entity.User;

public class UserDAO {
	private static Connection connection= DBConnector.getInstance();
	
	public static User selectionUser(String usernameString) {

		ResultSet rs=null;
		User user=null;
		String sql="SELECT * FROM user WHERE username= ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, usernameString);
			rs= statement.executeQuery();
			if (rs.next()) {
				String username=rs.getString(1);
				String password=rs.getString(2);
				String fullName=rs.getString(3);
				String eMail=rs.getString(4);
				String phone=rs.getString(5);
				Date birthday=rs.getDate(6);
				String address=rs.getString(7);
				
				user=new User(username,password,fullName,eMail,phone,birthday,address);
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
		return user ;
	}
	public static void insertion(User user) {
		/**
		 * This method allows to insert a new user into the DB
		 * Return void
		 */
		String sql="INSERT INTO user (username,password,full_name,phone_number,email,birthday,address) VALUES (?,?,?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getEmail());
			statement.setDate(6, user.getBirthday());
			statement.setString(7, user.getAddress());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());;
		}
	}
	public static boolean isExistUsername(String username) throws SQLException  {
		/**
		 * This method allows to verify if the username already exist
		 * Return boolean
		 */
	
		
		String verifyUsername = "SELECT count(1) FROM user WHERE username = '" + username +"'";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(verifyUsername);
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while(queryResult.next()) {
				if(queryResult.getInt(1) == 1) {
					return false;				
				}
				else {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		return true;
		
	}
	
	public static boolean validateLogin(String username, String password) throws SQLException {
		/**
		 * This method allows to verify if the user have an account 
		 * Return boolean
		 */
       
        String verifyLogin = "SELECT count(1) FROM user WHERE username  = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(verifyLogin);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet queryResult = preparedStatement.executeQuery();
            while (queryResult.next()) {
                return queryResult.getInt(1) == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
        return false;
    }
}
