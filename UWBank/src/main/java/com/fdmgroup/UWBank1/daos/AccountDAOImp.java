package com.fdmgroup.UWBank1.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.UWBank1.entities.Account;

public class AccountDAOImp implements AccountDAO {

	@Autowired
	private EntityManagerFactory factory;

	public AccountDAOImp() {
		super();
	}

	public AccountDAOImp(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void addAccount(Account a) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public void removeAccount(String accountNumber) {
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		Account account = manager.find(Account.class, accountNumber);
		manager.remove(account);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public void updateAccount(Account a) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(a);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public List<Account> getAllAccounts() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Account> query = manager.createQuery("select a from Account a", Account.class);
		List<Account> accountList = query.getResultList();
		manager.close();
		return accountList;
	}

	@Override
	public Account getAccount(String accountNumber) {
		EntityManager manager = factory.createEntityManager();
		Account account = manager.find(Account.class, accountNumber);
		manager.close();

		return account;

	}

}
