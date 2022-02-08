package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.FlightQuery;
import model.Flights;
import model.Reservation;
import model.ReservationQuery;
import model.SpecialOfferQuery;
import model.SpecialOffers;
import model.User;
import view.DialogueBox;
import view.User_Panel;

public class UserController implements ActionListener{
	private User_Panel frame;
	private User user;
	private Flights current;
	public UserController(User_Panel frame,User user) {
		this.frame=frame;
		this.user=user;
		SpecialOfferQuery obj=new SpecialOfferQuery();
		List<SpecialOffers> lis=obj.observer();
		String[][] ob=new String[lis.size()][3];
		for(int i=0;i<lis.size();i++) {
			ob[i][0]=lis.get(i).getOffer();
			ob[i][1]=""+lis.get(i).getPrice();
			ob[i][2]=lis.get(i).getCode();
		}
		frame.setOffers(ob);
		frame.setMyReservation(ReservationQuery.getMyReserv(user));
		frame.setFlights(FlightQuery.getAllFlights());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getApply()))
			apply();
		else
			check();
	}
	private void check() {
		String flight=frame.getFlight();
		ArrayList<Flights> lis=FlightQuery.getAllFlights();
		for(Flights f:lis) {
			if(f.getRoute().equals(flight)) {
				current=f;
				frame.setDate(f.getDate());
				frame.setAvailable_seats(""+f.getAvaSeats());
				frame.setPrice(""+f.getPrice());
				frame.setFlightClass(f.getFlightClass());
				break;
			}
		}
		double price=0;
		if(frame.getReserveSets().equals("")) {
			frame.setTotalPrice(""+0);
			return;
		}else {
			int seats=Integer.parseInt(frame.getReserveSets());
			price=current.getPrice()*seats;
		}
		if(!frame.getCodeText().equals("")) {
			SpecialOffers of=SpecialOfferQuery.getOffer(frame.getCodeText());
			if(of!=null)price-=of.getPrice();
		}
		frame.setTotalPrice(""+price);
	}
	private void apply() {
		ReservationQuery.addReservation(new Reservation(0, current, user, Integer.parseInt(frame.getReserveSets()), false));
		FlightQuery.update(current,Integer.parseInt(frame.getReserveSets()));
		frame.reset();
		DialogueBox.setText("Reservation Applied");
		frame.setMyReservation(ReservationQuery.getMyReserv(user));
	}

}
