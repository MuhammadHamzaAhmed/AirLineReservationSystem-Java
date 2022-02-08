package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.User;
import model.UserQuery;
import view.DialogueBox;
import view.Login;
import view.Signup;

public class Signup_Controller implements ActionListener {
	private Signup frame;

	public Signup_Controller(Signup frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but = (JButton) e.getSource();
		if (but.equals(frame.getLogin()))
			login();
		else if (but.equals(frame.getSignin()))
			signin();
	}
	
	/*
	 * adding new user
	 */
	private void signin() {
		String name = frame.getUsername();
		String pass = frame.getPassword();
		String rePass = frame.getRePassword();
		if (!name.equals("") && !pass.equals("") && pass.equals(rePass)) {
			User u = new User();
			u.setName(name);
			u.setPassword(rePass);
			UserQuery.addUser(u);
			DialogueBox.setText("Useradded");
			frame.setTe();
		}
		else {
			DialogueBox.setText("Invalid Details");
		}
	}

	/**
	 * opening login panel
	 */
	private void login() {
		frame.dispose();
		Login log = new Login();
		log.setVisible(true);
	}

}
