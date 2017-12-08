package com.fdmgroup.UWBank.daos;

import java.util.List;

import com.fdmgroup.UWBank.entities.User;



public interface UserDAO {
	
     public void addUser(User profile);

     public void removeUser(String username);

     public void updateUser(User profile);

     public User getUser(String username);

     public List<User> getAllUsers();

     public List<User> getAllCustomers();

     public List<User> getAllManagers();
     
     public List<User> getAllBlockedUsers();

     public List<User> getUserByName(String name);

}
