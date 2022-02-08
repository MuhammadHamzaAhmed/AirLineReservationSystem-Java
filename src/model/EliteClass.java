package model;

public class EliteClass extends Flights {
	
	public EliteClass() {					// constructor 1
		super.setFlightClass("EliteClass"); // Flight class Elite
	}

	public EliteClass(int flightID, String route, String date, double price, int avaSeats, int seats) { // Constructor 2
		super(flightID, route, date, price, avaSeats, seats);			// super constructor
		super.setFlightClass("EliteClass");	// Flight class Elite								
	}

}
