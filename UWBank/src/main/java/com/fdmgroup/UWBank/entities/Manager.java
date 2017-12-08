package com.fdmgroup.UWBank.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Manager")
public class Manager extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Manager() {
	}

	public Manager(String username, String password) {
		super(username, password);
	}

	
	
	
}


