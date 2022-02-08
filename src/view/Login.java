package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton Login;
	private JButton signUp;
	private LoginController con;
	public Login() {
		con=new LoginController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("AirLine Reservation System");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainLabel = new JLabel("AirLine Reservation System", SwingConstants.CENTER);
		mainLabel.setForeground(Color.LIGHT_GRAY);
		mainLabel.setFont(new Font("Krungthep", Font.PLAIN, 24));
		mainLabel.setBounds(0, 6, 450, 46);
		contentPane.add(mainLabel);
		
		JLabel username = new JLabel("User name", SwingConstants.CENTER);
		username.setForeground(Color.LIGHT_GRAY);
		username.setFont(new Font("Krungthep", Font.PLAIN, 16));
		username.setBounds(0, 76, 153, 31);
		contentPane.add(username);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Krungthep", Font.PLAIN, 18));
		usernameField.setBounds(160, 76, 255, 33);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password", SwingConstants.CENTER);
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Krungthep", Font.PLAIN, 16));
		password.setBounds(0, 132, 153, 31);
		contentPane.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Krungthep", Font.PLAIN, 18));
		passwordField.setBounds(160, 132, 255, 31);
		contentPane.add(passwordField);
		
		Login = new JButton("Login");
		Login.setBounds(79, 185, 135, 29);
		contentPane.add(Login);
		
		signUp = new JButton("Sign Up");
		signUp.setBounds(245, 183, 135, 29);
		contentPane.add(signUp);
		
		signUp.addActionListener(con);
		Login.addActionListener(con);
	}
	
	public String getUsername() {
		return usernameField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passwordField.getText();
	}

	public JButton getLogin() {
		return Login;
	}

	public JButton getSignin() {
		return signUp;
	}
	
	public void setTe() {
		usernameField.setText("");
		passwordField.setText("");
	}
}
