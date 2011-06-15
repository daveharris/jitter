package com.fronde.harrisd.jitter.controller.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fronde.harrisd.jitter.model.Post;

public class PostValidator implements Validator {

	public boolean supports(Class givenClass) {
		return givenClass.equals(Post.class);
	}

	public void validate(Object obj, Errors errors) {
		Post givenData = (Post) obj;

		if ("".equals(givenData.getBody())) {
			errors.rejectValue("body", "empty");
		}
	}
}
