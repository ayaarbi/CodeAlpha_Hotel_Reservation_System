package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static Connection connexion;

    private  final String DB_URL = "jdbc:mysql://localhost:3306/reservation";
    private  final String USER = "root";
    private  final String PASS = "";
    
    public DBConnector () throws SQLException{
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();	
    	}
    	connexion = DriverManager.getConnection(DB_URL,USER,PASS);
    	
    }
    
    public static Connection getInstance() {
    	if(connexion == null) {
    		try {
    			new DBConnector();
    		}catch(Exception e) {
    			System.out.println("--"+e.getMessage());
    		}
    	}
    	return connexion;
    }
    
    
	}



