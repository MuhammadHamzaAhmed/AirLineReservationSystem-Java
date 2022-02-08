package model;

public abstract class Flights {
	private String flightClass; 
	private int flightID;
	private String route;
	private String date;
	private double price;
	private int avaSeats;
	private int seats;

	public Flights() {
	}

	/**
	 * @param flightID
	 * @param route
	 * @param date
	 * @param price
	 * @param avaSeats
	 * @param seats
	 */
	public Flights(int flightID,String route, String date, double price, int avaSeats, int seats) {
		this.setFlightID(flightID);
		this.route = route;
		this.setDate(date);
		this.setPrice(price);
		this.setAvaSeats(avaSeats);
		this.setSeats(seats);
	}

	/**
	 * @return the flightID
	 */
	public int getFlightID() {
		return flightID;
	}

	/**
	 * @param flightID the flightID to set
	 */
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the avaSeats
	 */
	public int getAvaSeats() {
		return avaSeats;
	}

	/**
	 * @param avaSeats the avaSeats to set
	 */
	public void setAvaSeats(int avaSeats) {
		this.avaSeats = avaSeats;
	}

	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	

}
