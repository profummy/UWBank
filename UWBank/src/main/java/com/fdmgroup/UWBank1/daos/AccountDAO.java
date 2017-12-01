package com.fdmgroup.UWBank1.daos;

import java.util.List;

import com.fdmgroup.UWBank1.entities.Account;

public interface AccountDAO {

	public void addAccount(Account a);

	public void removeAccount(String accountNumber);
	
	public void updateAccount(Account a);
	
	public List<Account> getAllAccounts();
	
	public Account getAccount(String accountNumber);
	
	
	
}
