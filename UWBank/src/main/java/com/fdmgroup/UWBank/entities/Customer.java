package com.fdmgroup.UWBank.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Customer")
@Table(name = "UWB_Customers")
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String address;
	private String phoneNumber;
	@Transient
	private String confirmPassword;
	private LocalDate registrationDate;
	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dOB;
	@Transient
	private String dobString;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy="customer")
	private Set<Account> accountList;
	
	 public LocalDate getdOB() {
		return dOB; 
	}

	public void setdOB(LocalDate dOB) {
		this.dOB = dOB;
		
	}

	
	
	public String getConfirmpassword() {
		return confirmPassword;
	}

	public void setConfirmpassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	public Set<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}

	

	public Customer() {
		super();
	}

	public Customer(String confirmPassword) {
		this.registrationDate = LocalDate.now();
		this.confirmPassword = confirmPassword;
	}

	
	
	public Customer(String title, String address, String phoneNumber, LocalDate registrationDate, LocalDate dOB,
			String dobString, Set<Account> accountList) {
		super();
		this.title = title;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
		this.dOB = dOB;
		this.dobString = dobString;
		this.accountList = accountList;
	}

	public Customer(String username, String password) {
		super(username, password);
		this.registrationDate = LocalDate.now();

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}



	public String getDobString() {
		return dobString;
	}

	public void setDobString(String dobString) {
		System.out.println("%%%%%%%%%%%" + dobString);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		
		dOB = LocalDate.parse(dobString, formatter);
				
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Customer [title=" + title + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", confirmPassword=" + confirmPassword + ", registrationDate=" + registrationDate + ", dOB=" + dOB
				+ ", dobString=" + dobString + ", accountList=" + accountList + "]";
	}

	
	
	
	
}
