package com.fdmgroup.UWBank1.daos;

import java.util.List;

import com.fdmgroup.UWBank1.entities.Transaction;

public interface TransactionDAO {

	
	public void addTransaction(Transaction t);

	public void removeTransaction(int id);
	
	public void updateTransaction(Transaction t);
	
	public List<Transaction> getAllTransactions();
	
	public Transaction getTransaction(int id);
	
	
	
}
