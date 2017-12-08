package com.fdmgroup.UWBank.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.UWBank.entities.Customer;

public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private EntityManagerFactory factory;

	public CustomerDAOImp() {
		super();
	}

	public CustomerDAOImp(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void addCustomer(Customer c) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void removeCustomer(String username) {
		EntityManager manager = factory.createEntityManager();
		Customer customer = manager.find(Customer.class, username);
		manager.getTransaction().begin();
		manager.remove(customer);
		manager.getTransaction().commit();
		manager.close();

	}

	

	@Override
	public void updateCustomer(Customer c) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(c);
		manager.getTransaction().commit();
		manager.close();

	}


	@Override
	public List<Customer> getAllCustomers() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Customer> query = manager.createQuery("select c from Customer c", Customer.class);
		List<Customer> customerList = query.getResultList();
		manager.close();
		return customerList;
	}

	@Override
	public Customer getCustomer(String username) {

		EntityManager manager = factory.createEntityManager();
		Customer customer = manager.find(Customer.class, username);
		manager.close();

		return customer;
	}

}
