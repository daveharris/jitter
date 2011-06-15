package com.fronde.harrisd.jitter.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fronde.harrisd.jitter.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class givenClass) {
		return givenClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {
		User givenData = (User) obj;

		if ("".equals(givenData.getScreenName())) {
			errors.rejectValue("screenName", "empty");
		}
		if ("".equals(givenData.getEmail())) {
			errors.rejectValue("email", "empty");
		}
		if ("".equals(givenData.getFirstName())) {
			errors.rejectValue("firstName", "empty");
		}
		if ("".equals(givenData.getLastName())) {
			errors.rejectValue("lastName", "empty");
		}
	}
}
