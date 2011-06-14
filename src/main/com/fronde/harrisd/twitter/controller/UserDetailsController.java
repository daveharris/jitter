package com.fronde.harrisd.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fronde.harrisd.twitter.controller.validator.UserValidator;
import com.fronde.harrisd.twitter.model.User;
import com.fronde.harrisd.twitter.model.WebModel;
import com.fronde.harrisd.twitter.persistence.DAO;

@Controller
public class UserDetailsController {

	DAO dao;
	
	private UserDetailsController() {
		// Needed for Hibernate
	}
	
	public UserDetailsController(DAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView setupForm(@RequestParam("id") int id,
			HttpServletRequest request) {
		WebModel model = WebModel.getInstance();
		User user = dao.findUserByID(id);
		model.setUser(user);

		ModelAndView mv = new ModelAndView("userDetails");
		mv.addObject("user", user);
		try {
			System.out.println();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute User user, BindingResult result) {
		System.out.println("---INSIDE POST");
		WebModel model = WebModel.getInstance();

		new UserValidator().validate(user, result);

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("userDetails", model.getName(), model);
			mv.addAllObjects(result.getModel());
			return mv;
		}
		// Save the user object
		dao.save(user);
		System.out.println("Just saved user object");

		model.setMessage("User details updated");

		return new ModelAndView("redirect:home", model.getName(), model);
	}
}