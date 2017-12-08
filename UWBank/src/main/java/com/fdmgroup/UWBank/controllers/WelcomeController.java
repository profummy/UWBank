package com.fdmgroup.UWBank.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.UWBank.businessLogic.Validator;
import com.fdmgroup.UWBank.daos.CustomerDAO;
import com.fdmgroup.UWBank.daos.ManagerDAO;
import com.fdmgroup.UWBank.daos.UserDAO;
import com.fdmgroup.UWBank.entities.Customer;
import com.fdmgroup.UWBank.entities.Manager;
import com.fdmgroup.UWBank.entities.User;

@Controller
public class WelcomeController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	CustomerDAO customerDao;

	@Autowired
	ManagerDAO managerDao;

	@Autowired
	UserDAO userDao;

	@Autowired
	Validator validator;
	
	
	public WelcomeController() {
		super();
	}

	public WelcomeController(CustomerDAO customerDao, ManagerDAO managerDao, UserDAO userDao, Validator validator) {
		super();
		this.customerDao = customerDao;
		this.managerDao = managerDao;
		this.userDao = userDao;
		this.validator = validator;
	}

	@RequestMapping("/")
	public String goToHomepage() {
		return "views/Homepage";
	}

	@RequestMapping("/register")
	public String goToRegister(Model model) {
		logger.trace("Client request to url : /views/Register");
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "views/Register";

	}

	@RequestMapping("/login")
	public String goToLogin(Model model, HttpSession session, Principal principal, HttpServletRequest request) {

		session.setAttribute("username", principal.getName());
		User user = userDao.getUser(principal.getName());
		
		String login = Validator.validateUserLogin(request, user, session, model);
		
		return login;
		
		

	}

	@RequestMapping("/customer/home")
	public String goToCustomerHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Customer customer = customerDao.getCustomer(username);
		customer.setNoOfIncorrectAttempts(0);
		customerDao.updateCustomer(customer);
		return "redirect:CustomerHome";
	}
	
	
	@RequestMapping("/manager/home")
	public String goToManagerHome(HttpSession session) {
		return "redirect:ManagerHome";
	}
	
	

	@RequestMapping("/logout")
	public String doLogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
