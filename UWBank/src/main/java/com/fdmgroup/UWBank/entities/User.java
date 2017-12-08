package com.fdmgroup.UWBank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UWB_USERS")
@DiscriminatorColumn(name="ROLE")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int noOfIncorrectAttempts;

	
	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	public int getNoOfIncorrectAttempts() {
		return noOfIncorrectAttempts;
	}

	public void setNoOfIncorrectAttempts(int noOfIncorrectAttempts) {
		this.noOfIncorrectAttempts = noOfIncorrectAttempts;
	}	
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirmPassword=" + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	
	
	
	
}
