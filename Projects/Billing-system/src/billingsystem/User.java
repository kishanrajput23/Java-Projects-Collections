/*
 * 
 */
package billingsystem;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author Jason Li
 * @version 1.0
 * @since 19.12.2016
 * 
 * 
 * 
 * The Class User.
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The admin rights. */
	private boolean adminRights;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param adminRights the admin rights
	 */
	public User(String userName, String password, boolean adminRights) {
		this.userName = userName;
		this.password = password;
		this.adminRights = adminRights;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Gets the user password.
	 *
	 * @return the user password
	 */
	public String getUserPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the user rights.
	 *
	 * @return the user rights
	 */
	public boolean getUserRights() {
		return adminRights;
	}
}
