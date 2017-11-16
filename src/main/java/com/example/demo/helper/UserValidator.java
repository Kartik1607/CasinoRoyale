package com.example.demo.helper;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
    private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (user.getName().length() < 6 || user.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm");
        }
		
		BigInteger contactNumber = new BigInteger(user.getContactNumber());
		if ( user.getContactNumber().length() != 10 || contactNumber.signum() == -1) {
			errors.rejectValue("contactNumber", "Size.userForm");
		} else if( userService.findByContactNumber(user.getContactNumber()).isSuccess()) {
			errors.rejectValue("contactNumber", "Duplicate.userForm");
		}
		
		if ( userService.findByEmailAddress(user.getEmailAddress()).isSuccess() ) {
			errors.rejectValue("emailAddress", "Duplicate.userForm");
		}
		
		LocalDate birthdate = user.getDateOfBirth().toLocalDate();
		LocalDate now = LocalDate.now();
		int age = Period.between(birthdate, now).getYears();
		if ( age < 18 ) {
			errors.rejectValue("dateOfBirth", "Size.userForm");
		}
	}

}
