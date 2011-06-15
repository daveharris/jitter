package com.fronde.harrisd.jitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fronde.harrisd.jitter.controller.validator.PostValidator;
import com.fronde.harrisd.jitter.model.Post;
import com.fronde.harrisd.jitter.model.WebModel;
import com.fronde.harrisd.jitter.persistence.DAO;

@Controller
public class HomePageController {

	DAO dao;
	
	private HomePageController() {
	// Needed for Hibernate
	}

	// Create the controller with the DAO via Dependendy Injection
	public HomePageController(DAO dao) {
		this.dao = dao;
	}

	protected ModelAndView showAllTweets(HttpServletRequest request) {
		WebModel model = WebModel.getInstance();
		model.setPosts(dao.findAll(Post.class));

		return new ModelAndView("home", model.getName(), model);
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView setupForm(HttpServletRequest request) {
		WebModel model = WebModel.getInstance();

		model.setPosts(dao.findAll(Post.class));

		ModelAndView mv = new ModelAndView("home", model.getName(), model);
		mv.addObject("post", new Post());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute Post post, BindingResult result) {
		WebModel model = WebModel.getInstance();

		new PostValidator().validate(post, result);

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("home", model.getName(), model);
			mv.addAllObjects(result.getModel());
			return mv;
		}
		// Save the user object
		post.setAuthor(dao.findUserByID(1));
		dao.save(post);
		System.out.println("Just saved post object");

		model.setMessage("Post Added");

		return new ModelAndView("redirect:home", model.getName(), model);
	}
}