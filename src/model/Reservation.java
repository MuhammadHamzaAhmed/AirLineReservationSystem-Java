package model;

public class Reservation {
	private int reservationId;
	private Flights flight;
	private User user;
	private int seats;
	private boolean reserved;

	public Reservation() {
	}

	/**
	 * @param reservationId
	 * @param flight
	 * @param user
	 * @param seats
	 * @param reserved
	 */
	public Reservation(int reservationId, Flights flight, User user, int seats, boolean reserved) {
		super();
		this.reservationId = reservationId;
		this.flight = flight;
		this.user = user;
		this.seats = seats;
		this.reserved = reserved;
	}

	/**
	 * @return the reservationId
	 */
	public int getReservationId() {
		return reservationId;
	}

	/**
	 * @return the flight
	 */
	public Flights getFlight() {
		return flight;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * @return the reserved
	 */
	public boolean isReserved() {
		return reserved;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * @param reserved the reserved to set
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

}
