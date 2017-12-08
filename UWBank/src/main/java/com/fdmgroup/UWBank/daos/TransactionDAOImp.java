package com.fdmgroup.UWBank.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.UWBank.entities.Transaction;

public class TransactionDAOImp implements TransactionDAO {

	@Autowired
	private EntityManagerFactory factory;

	public TransactionDAOImp() {
		super();
	}

	public TransactionDAOImp(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	@Override
	public void addTransaction(Transaction t) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void removeTransaction(int id) {
		EntityManager manager = factory.createEntityManager();
		Transaction transaction = manager.find(Transaction.class, id);
		manager.getTransaction().begin();
		manager.remove(transaction);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void updateTransaction(Transaction t) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public List<Transaction> getAllTransactions() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Transaction> query = manager.createQuery("select t from transaction t", Transaction.class);
		List<Transaction> transactionList = query.getResultList();
		manager.close();
		return transactionList;		
	}

	@Override
	public Transaction getTransaction(int id) {
		EntityManager manager = factory.createEntityManager();
		Transaction transaction = manager.find(Transaction.class, id);
		return transaction;
	}

}
