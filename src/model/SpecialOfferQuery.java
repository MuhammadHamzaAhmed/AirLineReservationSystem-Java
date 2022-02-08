package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Interface.Observer;

public class SpecialOfferQuery implements Observer{
	private static final Connection con = DBConnection.getConnection();
	private static PreparedStatement preStatement;
	private static ResultSet resultSet;

	/*
	 * remove offer
	 */
	public static void removeOffer(String flight) {
		try {
			preStatement = con.prepareStatement("DELETE FROM specialOffers WHERE code=?;");
			preStatement.setString(1, flight);
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Admin will act as observable and will add an offers
	 */
	@Override
	public void observable(SpecialOffers flight) {
		try {
			preStatement = con.prepareStatement("INSERT INTO specialOffers(offer,price,code) VALUES (?,?,?);");
			preStatement.setString(1, flight.getOffer());
			preStatement.setDouble(2, flight.getPrice());
			preStatement.setString(3, flight.getCode());
			preStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * user will be observers
	 */
	@Override
	public List<SpecialOffers> observer() {
		ArrayList<SpecialOffers> lis = new ArrayList<>();
		try {
			preStatement = con.prepareStatement("SELECT * FROM specialOffers;");
			resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				lis.add(new SpecialOffers(resultSet.getString(1), resultSet.getDouble(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	// getting offer if available
	public static SpecialOffers getOffer(String codeText) {
		SpecialOfferQuery obj=new SpecialOfferQuery();
		ArrayList<SpecialOffers> lis =(ArrayList<SpecialOffers>) obj.observer();
		for(SpecialOffers qr:lis)
			if(qr.getCode().equals(codeText))
				return qr;
		return null;
	}
	
	
}
