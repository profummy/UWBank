package com.fdmgroup.UWBank.daos;


import com.fdmgroup.UWBank.entities.Manager;


public interface ManagerDAO {	
	
	public void addManager(Manager m);

	public void removeManager(String username);
	
	public void updateManager(Manager m);
	
	public Manager getManager(String username);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
