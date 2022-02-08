package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AdminController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Admin_Panel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField reserveText;
	private JTextField routeText;
	private JTextField dayTextField;
	private JTextField priceTextField;
	private JTextField seatsText;
	private JTextField offerText;
	private JTextField offerPriceText;
	private JTextField codeText;
	private JTable reservationTable;
	private JTable userTable;
	private JButton add;
	private JButton remove;
	private JButton send;
	private JButton removeOffer;
	private JButton acceptReservation;
	private JButton cancelReservation;
	private JButton ascending;
	private JButton descending;
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboBox;
	private AdminController con;
	

	public Admin_Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 1050);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("AirLine Reservation System");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainLabel = new JLabel("AirLine Reservation System",SwingConstants.CENTER);
		mainLabel.setFont(new Font("Krungthep", Font.PLAIN, 24));
		mainLabel.setForeground(Color.LIGHT_GRAY);
		mainLabel.setBounds(0, 0, 606, 46);
		contentPane.add(mainLabel);
		
		JPanel systemPanel = new JPanel();
		systemPanel.setBounds(10, 40, 299, 207);
		contentPane.add(systemPanel);
		systemPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage System",SwingConstants.CENTER);
		lblNewLabel.setBounds(2, 4, 297, 16);
		systemPanel.add(lblNewLabel);
		
		JLabel route = new JLabel("Route");
		route.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		route.setBounds(10, 58, 60, 20);
		systemPanel.add(route);
		
		routeText = new JTextField();
		routeText.setBounds(95, 54, 185, 26);
		systemPanel.add(routeText);
		routeText.setColumns(10);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		date.setBounds(10, 83, 60, 20);
		systemPanel.add(date);
		
		dayTextField = new JTextField();
		dayTextField.setColumns(10);
		dayTextField.setBounds(95, 79, 185, 26);
		systemPanel.add(dayTextField);
		
		JLabel time = new JLabel("Price");
		time.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		time.setBounds(10, 108, 60, 20);
		systemPanel.add(time);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(94, 104, 185, 26);
		systemPanel.add(priceTextField);
		
		remove = new JButton("Remove");
		remove.setBounds(159, 172, 117, 29);
		systemPanel.add(remove);
		
		add = new JButton("Add");
		add.setBounds(12, 172, 117, 29);
		systemPanel.add(add);
		
		JLabel Seats = new JLabel("Seats");
		Seats.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		Seats.setBounds(10, 135, 60, 20);
		systemPanel.add(Seats);
		
		seatsText = new JTextField();
		seatsText.setColumns(10);
		seatsText.setBounds(93, 131, 185, 26);
		systemPanel.add(seatsText);
		
		lblNewLabel_1 = new JLabel("class");
		lblNewLabel_1.setBounds(10, 30, 61, 16);
		systemPanel.add(lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.addItem("EliteClass");
		comboBox.addItem("PublicClass");
		comboBox.setBounds(97, 24, 180, 27);
		systemPanel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(321, 40, 299, 207);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel offerPanel = new JLabel("Special Offer", SwingConstants.CENTER);
		offerPanel.setBounds(1, 5, 297, 16);
		panel_1.add(offerPanel);
		
		JLabel Offer = new JLabel("offer");
		Offer.setBounds(11, 41, 61, 16);
		panel_1.add(Offer);
		
		offerText = new JTextField();
		offerText.setBounds(87, 35, 178, 26);
		panel_1.add(offerText);
		offerText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setBounds(11, 88, 61, 16);
		panel_1.add(lblNewLabel_1_1);
		
		offerPriceText = new JTextField();
		offerPriceText.setBounds(87, 82, 178, 26);
		panel_1.add(offerPriceText);
		offerPriceText.setColumns(10);
		
		JLabel offerCode = new JLabel("Code");
		offerCode.setBounds(11, 132, 61, 16);
		panel_1.add(offerCode);
		
		codeText = new JTextField();
		codeText.setBounds(87, 127, 174, 26);
		panel_1.add(codeText);
		codeText.setColumns(10);
		
		send = new JButton("Send Offer");
		send.setBounds(15, 172, 117, 29);
		panel_1.add(send);
		
		removeOffer = new JButton("Remove Offer");
		removeOffer.setBounds(167, 172, 117, 29);
		panel_1.add(removeOffer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(11, 256, 610, 330);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel reservationPanel = new JLabel("Reservation", SwingConstants.CENTER);
		reservationPanel.setBounds(0, 6, 610, 16);
		panel_2.add(reservationPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 34, 594, 246);
		panel_2.add(scrollPane);
		
		String[] obk= {"Reservation ID","Filght Route","User Name","No of seats","reserved"};
		reservationTable = new JTable(new DefaultTableModel(new String[][] {},obk));
		scrollPane.setViewportView(reservationTable);
		
		reserveText = new JTextField();
		reserveText.setBounds(13, 292, 228, 26);
		panel_2.add(reserveText);
		reserveText.setColumns(10);
		
		acceptReservation = new JButton("Accept Reservation");
		acceptReservation.setBackground(Color.LIGHT_GRAY);
		acceptReservation.setBounds(265, 292, 164, 29);
		panel_2.add(acceptReservation);
		
		cancelReservation = new JButton("Cancel Reservation");
		cancelReservation.setBackground(Color.LIGHT_GRAY);
		cancelReservation.setBounds(440, 292, 164, 29);
		panel_2.add(cancelReservation);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 594, 610, 330);
		contentPane.add(panel_2_1);
		
		JLabel reservationPanel_1 = new JLabel("User", SwingConstants.CENTER);
		reservationPanel_1.setBounds(0, 6, 610, 16);
		panel_2_1.add(reservationPanel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(7, 34, 594, 246);
		panel_2_1.add(scrollPane_1);
		
		String[] ob= {"User ID","Name","Password"};
		userTable = new JTable(new DefaultTableModel(new String[][] {},ob));
		scrollPane_1.setViewportView(userTable);
		
		ascending = new JButton("Descending");
		ascending.setBackground(Color.LIGHT_GRAY);
		ascending.setBounds(121, 292, 164, 29);
		panel_2_1.add(ascending);
		
		descending = new JButton("Ascending");
		descending.setBackground(Color.LIGHT_GRAY);
		descending.setBounds(348, 292, 164, 29);
		panel_2_1.add(descending);
		
		con=new AdminController(this);
		add.addActionListener(con);
		remove.addActionListener(con);
		removeOffer.addActionListener(con);
		send.addActionListener(con);
		acceptReservation.addActionListener(con);
		cancelReservation.addActionListener(con);
		ascending.addActionListener(con);
		descending.addActionListener(con);
	}

	/**
	 * @return the textField
	 */
	public String getReserveTest() {
		return reserveText.getText();
	}

	/**
	 * @return the routeText
	 */
	public String getRouteText() {
		return routeText.getText();
	}

	/**
	 * @return the dayTextField
	 */
	public String getDay() {
		return dayTextField.getText();
	}

	/**
	 * @return the timeTextField
	 */
	public Double getPrice() {
		return Double.parseDouble(priceTextField.getText());
	}

	/**
	 * @return the textField_1
	 */
	public int getSeats() {
		return Integer.parseInt(seatsText.getText());
	}

	/**
	 * @return the offerText
	 */
	public String getOfferText() {
		return offerText.getText();
	}

	/**
	 * @return the offerPriceText
	 */
	public String getOfferPriceText() {
		return offerPriceText.getText();
	}

	/**
	 * @return the codeText
	 */
	public String getCodeText() {
		return codeText.getText();
	}


	/**
	 * @return the userTable
	 */
	public void setUserTable(String[][] obj) {
		DefaultTableModel df=(DefaultTableModel)userTable.getModel();
		df.setRowCount(0);
		for(String[] st:obj) {
			df.addRow(st);
		}
	}
	
	public void setReservationTable(String[][] obj) {
		DefaultTableModel df=(DefaultTableModel)reservationTable.getModel();
		df.setRowCount(0);
		for(String[] st:obj) {
			df.addRow(st);
		}
	}

	/**
	 * @return the add
	 */
	public JButton getAdd() {
		return add;
	}

	/**
	 * @return the remove
	 */
	public JButton getRemove() {
		return remove;
	}

	/**
	 * @return the send
	 */
	public JButton getSend() {
		return send;
	}

	/**
	 * @return the removeOffer
	 */
	public JButton getRemoveOffer() {
		return removeOffer;
	}

	/**
	 * @return the acceptReservation
	 */
	public JButton getAcceptReservation() {
		return acceptReservation;
	}

	/**
	 * @return the cancelReservation
	 */
	public JButton getCancelReservation() {
		return cancelReservation;
	}

	/**
	 * @return the ascending
	 */
	public JButton getAscending() {
		return ascending;
	}

	/**
	 * @return the descending
	 */
	public JButton getDescending() {
		return descending;
	}
	
	public String getSelectedItem(){
		return (String) comboBox.getSelectedItem();
	}
}
