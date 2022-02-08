package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightQuery {
	private static final Connection con = DBConnection.getConnection();				// getting connection
	private static PreparedStatement preStatement;									// prepared Statement
	private static ResultSet resultSet;												// ressult sets

	// Add flight in Flight table
	public static void addFlight(Flights flight) {
		try {
			preStatement = con
					.prepareStatement("INSERT INTO Flight(route,date,price,seats,Available,class) VALUES (?,?,?,?,?,?);");
			preStatement.setString(1, flight.getRoute());
			preStatement.setString(2, flight.getDate());
			preStatement.setDouble(3, flight.getPrice());
			preStatement.setInt(4, flight.getSeats());
			preStatement.setInt(5, flight.getAvaSeats());
			preStatement.setString(6, flight.getFlightClass());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remove Flight from flight table
	public static void removeFlight(Flights flight) {
		try {
			preStatement = con.prepareStatement("DELETE FROM Flight WHERE flightNo=?;");
			preStatement.setInt(1, flight.getFlightID());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getting all flights
	public static ArrayList<Flights> getAllFlights() {
		ArrayList<Flights> lis = new ArrayList<Flights>();
		try {
			preStatement = con.prepareStatement("SELECT * FROM Flight;");
			resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				if(resultSet.getString(7).equals("EliteClass"))
					lis.add(new EliteClass(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getDouble(4), resultSet.getInt(6), resultSet.getInt(5)));
				else
					lis.add(new PublicClass(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getDouble(4), resultSet.getInt(6), resultSet.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}

	// Updating Flight
	public static void update(Flights current, int parseInt) {
		try {
			preStatement = con.prepareStatement("UPDATE Flight SET Available=? WHERE flightNo=?;");
			preStatement.setInt(1, current.getAvaSeats()-parseInt);
			preStatement.setInt(2, current.getFlightID());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
