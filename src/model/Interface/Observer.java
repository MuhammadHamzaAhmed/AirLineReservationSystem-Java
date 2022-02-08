package model.Interface;

import java.util.List;

import model.SpecialOffers;

public interface Observer {
	void observable(SpecialOffers flight);
	List<SpecialOffers> observer();
}
