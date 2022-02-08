package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UserController;
import model.Flights;
import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class User_Panel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable offers;
	private JTable myReservation;
	private JTextField date;
	private JTextField price;
	private JTextField available_seats;
	private JTextField reserveSets;
	private JTextField totalPrice;
	private JTextField flightClass;
	private JTextField codeText;
	private JButton apply;
	private JComboBox<String> flight;
	private UserController con;
	/**
	 * Create the frame.
	 */
	public User_Panel(User user ) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 606, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("AirLine Reservation System");
		contentPane.setLayout(null);

		JLabel mainLabel = new JLabel("AirLine Reservation System", SwingConstants.CENTER);
		mainLabel.setFont(new Font("Krungthep", Font.PLAIN, 24));
		mainLabel.setForeground(Color.LIGHT_GRAY);
		mainLabel.setBounds(0, 0, 606, 46);
		contentPane.add(mainLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 578, 354);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Reserve Flight", null, panel, null);
		panel.setLayout(null);

		flight = new JComboBox<>();
		flight.setBounds(111, 83, 159, 27);
		panel.add(flight);

		JLabel lblNewLabel = new JLabel("Flight");
		lblNewLabel.setBounds(6, 86, 61, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setBounds(6, 118, 61, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setBounds(6, 154, 61, 16);
		panel.add(lblNewLabel_1_1);

		date = new JTextField();
		date.setEditable(false);
		date.setBounds(111, 115, 159, 26);
		panel.add(date);
		date.setColumns(10);

		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(111, 151, 159, 26);
		panel.add(price);

		JLabel lblNewLabel_2 = new JLabel("Available Seats");
		lblNewLabel_2.setBounds(6, 194, 99, 16);
		panel.add(lblNewLabel_2);

		available_seats = new JTextField();
		available_seats.setEditable(false);
		available_seats.setBounds(111, 190, 159, 26);
		panel.add(available_seats);
		available_seats.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Reserve seats");
		lblNewLabel_2_1.setBounds(286, 156, 99, 16);
		panel.add(lblNewLabel_2_1);

		reserveSets = new JTextField();
		reserveSets.setColumns(10);
		reserveSets.setBounds(398, 151, 148, 26);
		panel.add(reserveSets);

		JLabel lblNewLabel_2_2 = new JLabel("Total");
		lblNewLabel_2_2.setBounds(286, 193, 99, 16);
		panel.add(lblNewLabel_2_2);

		totalPrice = new JTextField();
		totalPrice.setEditable(false);
		totalPrice.setColumns(10);
		totalPrice.setBounds(398, 188, 148, 26);
		panel.add(totalPrice);

		apply = new JButton("Apply for Reservartion");
		apply.setBounds(208, 266, 184, 29);
		panel.add(apply);

		JLabel lblReservation = new JLabel("Reservation", SwingConstants.CENTER);
		lblReservation.setForeground(Color.BLACK);
		lblReservation.setFont(new Font("Krungthep", Font.PLAIN, 24));
		lblReservation.setBounds(-22, 2, 606, 46);
		panel.add(lblReservation);

		JLabel classFlight = new JLabel("Class");
		classFlight.setBounds(287, 87, 61, 16);
		panel.add(classFlight);

		flightClass = new JTextField();
		flightClass.setEditable(false);
		flightClass.setBounds(398, 82, 148, 26);
		panel.add(flightClass);
		flightClass.setColumns(10);

		JLabel code = new JLabel("Code");
		code.setBounds(285, 123, 61, 16);
		panel.add(code);

		codeText = new JTextField();
		codeText.setColumns(10);
		codeText.setBounds(398, 118, 148, 26);
		panel.add(codeText);

		JButton check = new JButton("check");
		check.setBounds(201, 225, 184, 29);
		panel.add(check);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("My Reservations", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 6, 545, 296);
		panel_1.add(scrollPane_1);

		String[] obl= {"Reservation ID","Filght Route","User Name","No of seats","reserved"};
		myReservation = new JTable(new DefaultTableModel(new String[][] {},obl));
		scrollPane_1.setViewportView(myReservation);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Special Offers", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 545, 296);
		panel_2.add(scrollPane);

		String[] obk= {"offer","Price","Code"};
		offers = new JTable(new DefaultTableModel(new String[][] {},obk));
		scrollPane.setViewportView(offers);
		
		con=new UserController(this, user);
		check.addActionListener(con);
		apply.addActionListener(con);
	}

	/**
	 * @return the offers
	 */
	public void setOffers(String[][] obj) {
		DefaultTableModel df = (DefaultTableModel) offers.getModel();
		df.setRowCount(0);
		for (String[] st : obj) {
			df.addRow(st);
		}
	}
	
	public void setMyReservation(String[][] obj) {
		DefaultTableModel df = (DefaultTableModel) myReservation.getModel();
		df.setRowCount(0);
		for (String[] st : obj) {
			df.addRow(st);
		}
	}

	/**
	 * @return the myReservation
	 */
	public JTable getMyReservation() {
		return myReservation;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date.getText();
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price.getText();
	}

	/**
	 * @return the available_seats
	 */
	public String getAvailable_seats() {
		return available_seats.getText();
	}

	/**
	 * @return the reserveSets
	 */
	public String getReserveSets() {
		return reserveSets.getText();
	}

	/**
	 * @return the totalPrice
	 */
	public String getTotalPrice() {
		return totalPrice.getText();
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass.getText();
	}

	/**
	 * @return the codeText
	 */
	public String getCodeText() {
		return codeText.getText();
	}

	/**
	 * @return the apply
	 */
	public JButton getApply() {
		return apply;
	}

	/**
	 * @param offers the offers to set
	 */
	public void setOffers(JTable offers) {
		this.offers = offers;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date.setText(date);
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price.setText(price);
		;
	}

	/**
	 * @param available_seats the available_seats to set
	 */
	public void setAvailable_seats(String available_seats) {
		this.available_seats.setText(available_seats);
	}

	/**
	 * @param reserveSets the reserveSets to set
	 */
	public void setReserveSets(String reserveSets) {
		this.reserveSets.setText(reserveSets);
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice.setText(totalPrice);
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass.setText(flightClass);
	}

	/**
	 * @param codeText the codeText to set
	 */
	public void setCodeText(String codeText) {
		this.codeText.setText(codeText);
	}

	/**
	 * @param apply the apply to set
	 */
	public void setApply(JButton apply) {
		this.apply = apply;
	}

	public String getFlight() {
		return (String) flight.getSelectedItem();
	}
	
	public void setFlights(ArrayList<Flights> lis) {
		flight.removeAllItems();
		for(Flights f:lis) {
			flight.addItem(f.getRoute());
		}
	}

	public void reset() {
		setAvailable_seats("");
		setDate("");
		setPrice("");
		setFlightClass("");
		setCodeText("");
		setTotalPrice("");
		setReserveSets("");
		
	}
}
