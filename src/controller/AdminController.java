package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.FlightFactory;
import model.FlightQuery;
import model.Flights;
import model.Reservation;
import model.ReservationQuery;
import model.SpecialOfferQuery;
import model.SpecialOffers;
import model.UserDetails;
import model.Interface.Strategy;
import view.Admin_Panel;
import view.DialogueBox;

public class AdminController implements ActionListener {
	private Admin_Panel frame;													// Admin panel view
	private Strategy pattern;													// Strategy pattern
	private SpecialOfferQuery obs;												// special offer to make admin observable

	public AdminController(Admin_Panel frame) {									// constructor
		this.frame = frame;														// initializing frame
		pattern = new UserDetails();											// initializing pattern
		obs=new SpecialOfferQuery();											// initializing obs
		ascending();															// adding user list in user table
		frame.setReservationTable(ReservationQuery.getAllReservatioArray());	// adding all reservation in reservation table
	}

	@Override
	public void actionPerformed(ActionEvent e) {								// Action performed on following button
		if (e.getSource().equals(frame.getAdd()))								// Add button
			add();
		else if (e.getSource().equals(frame.getRemove()))						// remove button
			remove();
		else if (e.getSource().equals(frame.getSend()))							// send buttton
			send();
		else if (e.getSource().equals(frame.getRemoveOffer()))					// remove offer button
			removeOffer();
		else if (e.getSource().equals(frame.getAcceptReservation()))			// accept reservation button
			acceptReservation();
		else if (e.getSource().equals(frame.getCancelReservation()))			// cancel reservation button
			cancelReservation();
		else if (e.getSource().equals(frame.getAscending()))					// ascending button
			ascending();
		else if (e.getSource().equals(frame.getDescending()))					// descending button
			descending();
	}

	private void descending() {				
		frame.setUserTable(pattern.getAscending());								// ascending order
	}

	private void ascending() {
		frame.setUserTable(pattern.getDescending());							// descending order
	}

	private void cancelReservation() {
		ArrayList<Reservation> lis = ReservationQuery.getAllReservation();		// list of reservsation
		int id = -1;															// initializing id
		try {
			id = Integer.parseInt(frame.getReserveTest());						// getting user enterd id
		} catch (Exception e) {
			DialogueBox.setText("Enter Reservation id");						// id not avaiable
			return;																// returning from method
		}
		for (Reservation u : lis) {												// iterating all reservations
			if (u.getReservationId() == id) {									// checking if reservation is present
				ReservationQuery.removeReservation(u);							// removing reservation
				DialogueBox.setText("Reservation Canceled");					// display message
				frame.setReservationTable(ReservationQuery.getAllReservatioArray());	// refershing table
			}
		}
	}

	private void acceptReservation() {
		ArrayList<Reservation> lis = ReservationQuery.getAllReservation();		// list of reservation
		int id = -1;															// initializing id
		try {
			id = Integer.parseInt(frame.getReserveTest());						// getting id from user
		} catch (Exception e) {
			DialogueBox.setText("Enter Reservation id");
			return;
		}
		for (Reservation u : lis) {												// iterating list
			if (u.getReservationId() == id) {									// getting reservation
				ReservationQuery.reservation(u);								// accepting reservation
				frame.setReservationTable(ReservationQuery.getAllReservatioArray());	// refreshing table
				DialogueBox.setText("Reservation accepted");					//displaying message
				return;
			}
		}

	}

	private void removeOffer() {
		String code=frame.getCodeText();										// getting offer code
		SpecialOfferQuery.removeOffer(code);									// removing offers
		DialogueBox.setText("Offer removed");									// showing message
	}

	private void send() {
		String offer=frame.getOfferText();										// getting offer
		String code=frame.getCodeText();										// getting code
		double price;															// price
		try {
			price=Double.parseDouble(frame.getOfferPriceText());				// getting price
		}catch(Exception e) {
			DialogueBox.setText("Price can only be number");					// exception
			return;
		}
		obs.observable(new SpecialOffers(offer,price,code));					// adding offer
		DialogueBox.setText("Offer send");										// showing message
	}

	private void remove() {
		ArrayList<Flights> lis=FlightQuery.getAllFlights();						// removing flight
		String route=frame.getRouteText();										// getting route
		int seats=frame.getSeats();												// getting seats
		for(Flights f:lis) {												
			if(f.getRoute().equals(route) && f.getSeats()==seats) {				
				FlightQuery.removeFlight(f);									// removing flight
				DialogueBox.setText("Flight Removed");							// dialogue message
				return;
			}
		}
	}

	private void add() {
		FlightFactory fac=new FlightFactory();								// factory pattern
		String route=frame.getRouteText();									// getting route
		String flightClass=frame.getSelectedItem();							// getting class
		double price=frame.getPrice();										// getting price
		int seats=frame.getSeats();											// getting seats
		FlightQuery.addFlight(fac.getFlight(flightClass, seats, route, flightClass, price, seats, seats)); // adding flights
		DialogueBox.setText("Flight added");								// message
	}

}
