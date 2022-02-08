package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationQuery {
	private static final Connection con = DBConnection.getConnection();
	private static PreparedStatement preStatement;
	private static ResultSet resultSet;
	
	/*
	 * Adding reservation in reservation table
	 */
	public static void addReservation(Reservation flight) {
		try {
			preStatement = con
					.prepareStatement("INSERT INTO reservation(FlightNo,user,seats,reserved) VALUES (?,?,?,?);");
			preStatement.setInt(1, flight.getFlight().getFlightID());
			preStatement.setInt(2, flight.getUser().getUserID());
			preStatement.setInt(3, flight.getSeats());
			if (flight.isReserved())
				preStatement.setInt(4, 1);
			else
				preStatement.setInt(4, 0);
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * removing reservation
	 */
	public static void removeReservation(Reservation flight) {
		try {
			preStatement = con.prepareStatement("DELETE FROM reservation WHERE reservationID=?;");
			preStatement.setInt(1, flight.getReservationId());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * updating reservation
	 */
	public static void reservation(Reservation flight) {
		try {
			preStatement = con.prepareStatement("UPDATE reservation SET reserved=1 WHERE reservationID=?;");
			preStatement.setInt(1, flight.getReservationId());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * getting all reservations
	 */
	public static ArrayList<Reservation> getAllReservation() {
		ArrayList<Reservation> lis = new ArrayList<>();
		try {
			preStatement = con.prepareStatement(
					"SELECT r.reservationID,r.FlightNo,f.route,f.date,f.price,f.seats,f.available,r.user,u.name,u.password,r.seats,r.reserved,f.class\n"
							+ "FROM reservation r,Flight f,user u\n"
							+ "WHERE r.FlightNo=f.flightNo AND r.user=u.userID;");
			resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(12) == 1) {
					if (resultSet.getString(13).equals("EliteClass"))
						lis.add(new Reservation(resultSet.getInt(1),
								new EliteClass(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4),
										resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)),
								new User(resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10)),
								resultSet.getInt(11), true));
					else
						lis.add(new Reservation(resultSet.getInt(1),
								new PublicClass(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4),
										resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)),
								new User(resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10)),
								resultSet.getInt(11), true));
				} else {
					if (resultSet.getString(13).equals("EliteClass"))
						lis.add(new Reservation(resultSet.getInt(1),
								new EliteClass(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4),
										resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)),
								new User(resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10)),
								resultSet.getInt(11), false));
					else
						lis.add(new Reservation(resultSet.getInt(1),
								new PublicClass(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4),
										resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)),
								new User(resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10)),
								resultSet.getInt(11), false));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}
	/*
	 * getting array of reservation
	 */
	public static String[][] getAllReservatioArray() {
		ArrayList<Reservation> lis = getAllReservation();
		String[][] ob = new String[lis.size()][5];
		for (int i = 0; i < lis.size(); i++) {
			ob[i][0] = "" + lis.get(i).getReservationId();
			ob[i][1] = "" + lis.get(i).getFlight().getRoute();
			ob[i][2] = "" + lis.get(i).getUser().getName();
			ob[i][3] = "" + lis.get(i).getSeats();
			if (lis.get(i).isReserved())
				ob[i][4] = "reserved";
			else
				ob[i][4] = "Not Reserved";
		}
		return ob;
	}

	/*
	 * getting reservation of specific users
	 */
	public static String[][] getMyReserv(User user) {
		ArrayList<Reservation> lis = getAllReservation();
		String[][] ob = new String[lis.size()][5];
		for (int i = 0; i < lis.size(); i++) {
			if (lis.get(i).getUser().getUserID() == user.getUserID()) {
				ob[i][0] = "" + lis.get(i).getReservationId();
				ob[i][1] = "" + lis.get(i).getFlight().getRoute();
				ob[i][2] = "" + lis.get(i).getUser().getName();
				ob[i][3] = "" + lis.get(i).getSeats();
				if (lis.get(i).isReserved())
					ob[i][4] = "reserved";
				else
					ob[i][4] = "Not Reserved";
			}
		}
		return ob;
	}
}
