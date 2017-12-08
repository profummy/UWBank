package com.fdmgroup.UWBank.businessLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fdmgroup.UWBank.entities.User;

public class Validator {
	
	
	
	
	public Validator(){
	}
	
	public static String validateLoginAttempts (HttpSession session, Model model,User user) {
			
		if (user.getNoOfIncorrectAttempts() >= 3) {
			session.invalidate();
			model.addAttribute("message",
					"You have entered incorrect details on 3 occasions. Your account has been locked. Please contact UWB.");		
		return "";
		
	}
		return "redirect:/";
	}
		
	public static String validateUserLogin (HttpServletRequest request, User user, HttpSession session, Model model) {
		
		
		validateLoginAttempts(session, model, user);
		
		
		if (request.isUserInRole("Customer")) {
			return "redirect:customer/home";
		} else if (request.isUserInRole("Manager")) {
			return "redirect:manager/home";
		
		
		
	}
		return "redirect:/";
	
	
	
	
	

}
}
