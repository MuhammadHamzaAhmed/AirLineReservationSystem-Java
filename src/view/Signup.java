package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Signup_Controller;

import java.awt.Color;

public class Signup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton Login;
	private JButton signin;
	private Signup_Controller con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		con=new Signup_Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 303);
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
		username.setBounds(0, 76, 178, 31);
		contentPane.add(username);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Krungthep", Font.PLAIN, 18));
		usernameField.setBounds(175, 76, 255, 33);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password", SwingConstants.CENTER);
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Krungthep", Font.PLAIN, 16));
		password.setBounds(0, 122, 178, 31);
		contentPane.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Krungthep", Font.PLAIN, 18));
		passwordField.setBounds(175, 122, 255, 31);
		contentPane.add(passwordField);
		
		Login = new JButton("Login");
		Login.setBounds(67, 226, 135, 29);
		contentPane.add(Login);
		
		JLabel lblRetypePassword = new JLabel("Retype Password", SwingConstants.CENTER);
		lblRetypePassword.setForeground(Color.LIGHT_GRAY);
		lblRetypePassword.setFont(new Font("Krungthep", Font.PLAIN, 16));
		lblRetypePassword.setBounds(0, 169, 178, 31);
		contentPane.add(lblRetypePassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Krungthep", Font.PLAIN, 18));
		passwordField_1.setBounds(175, 169, 255, 31);
		contentPane.add(passwordField_1);
		
		signin = new JButton("sign In");
		signin.setBounds(252, 226, 135, 29);
		contentPane.add(signin);
		
		signin.addActionListener(con);
		Login.addActionListener(con);
	}

	public String getUsername() {
		return usernameField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passwordField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getRePassword() {
		return passwordField_1.getText();
	}

	public JButton getLogin() {
		return Login;
	}

	public JButton getSignin() {
		return signin;
	}
	
	public void setTe() {
		usernameField.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}

}
