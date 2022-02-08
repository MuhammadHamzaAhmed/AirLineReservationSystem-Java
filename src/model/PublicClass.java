package model;

public class PublicClass extends Flights{
	/**
	 * Constructor
	 */
	public PublicClass() {
		super.setFlightClass("PublicClass");
	}

	/**
	 * Constructor
	 * @param flightID
	 * @param route
	 * @param date
	 * @param price
	 * @param avaSeats
	 * @param seats
	 */
	public PublicClass(int flightID, String route, String date, double price, int avaSeats, int seats) {
		super(flightID, route, date, price, avaSeats, seats);
		super.setFlightClass("PublicClass");
	}
}
