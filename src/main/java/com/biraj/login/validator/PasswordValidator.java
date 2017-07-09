package com.biraj.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.biraj.login.model.User;

@Component
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password is empty","doesnot matches");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "password is empty","is empty");
		User user = (User) target;
		if(!(user.getPassword().equals(user.getPasswordConfirm()))){
			errors.rejectValue("password", "password dont matches","doesnot matches");
		}


		
	}

}
