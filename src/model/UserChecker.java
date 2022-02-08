package model;

import java.util.ArrayList;

public class UserChecker {
	private ArrayList<User> lis;

	public boolean isUser(String name, String pass) {
		lis = UserQuery.getAllUser();
		if (lis.isEmpty())
			return false;
		for (User u : lis) {
			if (u.getName().equals(name) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String name, String pass) {
		lis = UserQuery.getAllUser();
		if (lis.isEmpty())
			return null;
		for (User u : lis) {
			if (u.getName().equals(name) && u.getPassword().equals(pass)) {
				return u;
			}
		}
		return null;
	}

	public boolean isAdmin(String name, String pass) {
		if (name.equalsIgnoreCase("Admin") && pass.equalsIgnoreCase("Admin"))
			return true;
		return false;
	}
}
