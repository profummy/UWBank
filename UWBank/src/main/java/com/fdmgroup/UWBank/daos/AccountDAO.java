package com.fdmgroup.UWBank.daos;

import java.util.List;

import com.fdmgroup.UWBank.entities.Account;

public interface AccountDAO {

	public void addAccount(Account a);

	public void removeAccount(String accountNumber);
	
	public void updateAccount(Account a);
	
	public List<Account> getAllAccounts();
	
	public Account getAccount(String accountNumber);
	
	
	
}
