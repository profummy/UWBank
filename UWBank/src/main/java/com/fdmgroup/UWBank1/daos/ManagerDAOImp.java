package com.fdmgroup.UWBank1.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.UWBank1.entities.Manager;

public class ManagerDAOImp implements ManagerDAO {

	@Autowired
	private EntityManagerFactory factory;

	public ManagerDAOImp() {
	}

	public ManagerDAOImp(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addManager(Manager m) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(m);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void removeManager(String username) {
		EntityManager emanager = factory.createEntityManager();
		Manager manager = emanager.find(Manager.class, username);
		emanager.getTransaction().begin();
		emanager.remove(manager);
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void updateManager(Manager m) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(m);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public Manager getManager(String username) {
		EntityManager emanager = factory.createEntityManager();
		Manager manager = emanager.find(Manager.class, username);
		return manager;

	}

}
