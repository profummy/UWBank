package com.fdmgroup.UWBank1.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fdmgroup.UWBank1.utilities.TransactionType;

@Entity
@Table(name = "UWB_TRANSACTIONS")
public class Transaction {

	@Id
	@SequenceGenerator(name = "gradeid_sequence", sequenceName = "gradeid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gradeid_sequence")
	private int id;
	private LocalDate transactionDate;
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_NUMBER")
	private Account account;

	public Transaction() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transaction(int id, LocalDate transactionDate, BigDecimal amount, TransactionType transactionType,
			Account account) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", account=" + account + "]";
	}
	
	
	
	
	
}
