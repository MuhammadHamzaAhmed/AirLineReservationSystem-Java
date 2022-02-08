package model.Interface;

import model.Flights;

public interface FactoryBuilder {
	Flights getFlight(String name,int flightID,String route, String date, double price, int avaSeats, int seats);
}
