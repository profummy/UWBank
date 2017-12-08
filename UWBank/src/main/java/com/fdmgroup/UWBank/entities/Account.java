package com.fdmgroup.UWBank.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fdmgroup.UWBank.utilities.AccountType;


@Entity 
@Table(name = "UWB_ACCOUNTS")
public class Account {

	@Id
	private String accountNumber;
	@Type(type="yes_no")
	private Boolean isActive;
	private BigDecimal balance;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "account")
	private Set<Transaction> transactionList;

	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_USERNAME")
	private Customer customer;


	public Account() {
		super();
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}




	public Set<Transaction> getTransactionList() {
		return transactionList;
	}


	public void setTransactionList(Set<Transaction> transactionList) {
		this.transactionList = transactionList;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	public Account(String accountNumber, Boolean isActive, BigDecimal balance, AccountType accountType,
			Set<Transaction> transactionList, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.isActive = isActive;
		this.balance = balance;
		this.accountType = accountType;
		this.transactionList = transactionList;
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", isActive=" + isActive + ", balance=" + balance
				+ ", accountType=" + accountType + ", transactionList=" + transactionList + ", customer=" + customer
				+ "]";
	}
	
	
	
	
	
	
}
