package com.fdmgroup.UWBank.daos;


import java.util.List;

import com.fdmgroup.UWBank.entities.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer c);

	public void removeCustomer(String username);

	public void updateCustomer(Customer c);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(String username);
	
}
