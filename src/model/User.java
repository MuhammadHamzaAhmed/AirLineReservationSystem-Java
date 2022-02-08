package model;

@SuppressWarnings("rawtypes")
public class User implements Comparable{
	private int userID;
	private String name;
	private String password;

	public User() {
	}

	
	
	/**
	 * @param userID
	 * @param name
	 * @param password
	 */
	public User(int userID, String name, String password) {
		super();
		this.userID = userID;
		this.name = name;
		this.password = password;
	}



	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int compareTo(Object o) {
		return name.compareTo(((User)o).getName());
	}

}
