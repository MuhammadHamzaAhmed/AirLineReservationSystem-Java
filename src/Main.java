import java.awt.EventQueue;

import view.Login;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();		// JFrame of login	
					frame.setVisible(true);			// Setting frame visible
				} catch (Exception e) {
					e.printStackTrace();			// printing exception if o
				}
			}
		});
	}
}
