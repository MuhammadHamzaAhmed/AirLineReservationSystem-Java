package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.UserChecker;
import view.Admin_Panel;
import view.DialogueBox;
import view.Login;
import view.Signup;
import view.User_Panel;

public class LoginController implements ActionListener{
	private Login frame;
	private UserChecker checker;
	public LoginController(Login login) {
		frame=login;
		checker=new UserChecker();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but=(JButton) e.getSource();
		if(but.equals(frame.getLogin()))
			login();
		else
			signUp();
		
	}
	private void signUp() {
		frame.dispose();					// closing login frame
		Signup frame=new Signup();			// going to signup frame
		frame.setVisible(true);
		
	}
	private void login() {
		if(checker.isAdmin(frame.getUsername(), frame.getPassword())) {			// checking password
			frame.dispose();													// closing login frame
			Admin_Panel panel=new Admin_Panel();								// opening Admin panel
			panel.setVisible(true);												// setting visible
		}
		else if(checker.isUser(frame.getUsername(), frame.getPassword())) {		// checking user password
			frame.dispose();													// closing frame
			User_Panel panel=new User_Panel(checker.getUser(frame.getUsername(), frame.getPassword()));	// open user panel
			panel.setVisible(true);												// setting visible
		} else {
			DialogueBox.setText("User not registered");							// not registered
		}
	}
}
