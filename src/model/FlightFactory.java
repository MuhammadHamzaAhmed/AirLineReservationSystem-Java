package model;

import model.Interface.FactoryBuilder;
/*
 * Factory Builder pattern it return objects of Flight subclasses
 */
public class FlightFactory implements FactoryBuilder {

	@Override
	public Flights getFlight(String name, int flightID, String route, String date, double price, int avaSeats,
			int seats) {
		if (name.equals("EliteClass"))				// if elite class flight is required
			return new EliteClass(flightID, route, date, price, avaSeats, seats);	// return elite class flight
		else
			return new PublicClass(flightID, route, date, price, avaSeats, seats);	// return public class flight
	}

}
