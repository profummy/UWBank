package com.fdmgroup.UWBank1.daos;


import com.fdmgroup.UWBank1.entities.Manager;


public interface ManagerDAO {	
	
	public void addManager(Manager m);

	public void removeManager(String username);
	
	public void updateManager(Manager m);
	
	public Manager getManager(String username);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
