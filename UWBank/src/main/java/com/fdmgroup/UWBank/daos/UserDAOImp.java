package com.fdmgroup.UWBank.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.UWBank.entities.Customer;
import com.fdmgroup.UWBank.entities.User;


public class UserDAOImp implements UserDAO {

     @Autowired
     private EntityManagerFactory factory;

     public UserDAOImp() {
     }

     public UserDAOImp(EntityManagerFactory factory) {
           this.factory = factory;
     }

     public void addUser(User user) {
           EntityManager manager = factory.createEntityManager();
           manager.getTransaction().begin();
           manager.persist(user);
           manager.getTransaction().commit();
     }

     @Override
     public void removeUser(String username) {
           EntityManager manager = factory.createEntityManager();
           User user = manager.find(User.class, username);
           manager.getTransaction().begin();
           manager.remove(user);
           manager.getTransaction().commit();
     }

     @Override
     public void updateUser(User user) {
           EntityManager manager = factory.createEntityManager();
           manager.getTransaction().begin();
           manager.merge(user);
           manager.getTransaction().commit();
     }

     @Override
     public User getUser(String username) {
           EntityManager manager = factory.createEntityManager();
           User user = manager.find(User.class, username);
           manager.close();
           return user;
     }

     @Override
     public List<User> getAllUsers() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("FROM User p", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllCustomers() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select c FROM Customer c", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllManagers() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select m FROM Manager m", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }
     
     
     @Override
     public List<User> getAllBlockedUsers(){
    	 EntityManager manager = factory.createEntityManager();
         TypedQuery<User> query = manager.createQuery("select u FROM User u WHERE u.noOfIncorrectAttempts > ?", User.class);
         query.setParameter(1, 2);
    	 List<User> userList = query.getResultList();
    	 manager.close();
    	 return userList;
     }
     
     @Override
     public List<User> getUserByName(String name){
    	 EntityManager manager = factory.createEntityManager();
         TypedQuery<User> query = manager.createQuery("select u FROM User u WHERE u.firstName like ? OR u.lastName like ? OR u.username like ?", User.class);
         query.setParameter(1, "%" + name + "%"); // contains key word firstname/lastname/username
         query.setParameter(2, "%" + name + "%");
         query.setParameter(3, "%" + name + "%");
    	 List<User> userList = query.getResultList();
    	 manager.close();
    	 return userList;
     }

}

