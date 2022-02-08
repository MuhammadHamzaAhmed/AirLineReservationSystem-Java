package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserQuery {
	private static final Connection con=DBConnection.getConnection();
	private static PreparedStatement preStatement;
	private static ResultSet resultSet;
	/*
	 * getting all user
	 */
	public static ArrayList<User> getAllUser(){
		ArrayList<User> lis=new ArrayList<User>();
		try {
			preStatement=con.prepareStatement("SELECT * FROM user;");
			resultSet=preStatement.executeQuery();
			while(resultSet.next()) {
				lis.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	/*
	 * adding user
	 */
	public static void addUser(User u) {
		try {
			preStatement=con.prepareStatement("INSERT INTO user(name,password) VALUES (?,?);");
			preStatement.setString(1, u.getName());
			preStatement.setString(2, u.getPassword());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
