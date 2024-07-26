package login.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import login.MemberForm;

public class MemberFormValidator implements Validator {
	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public MemberFormValidator() {
		pattern = Pattern.compile(emailRegExp);	
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberForm.class.isAssignableFrom(clazz);
		//clazz가 MemberForm의 자식클래스 또는 구현 클래스인가?
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		MemberForm memberForm = (MemberForm)target;
		if(memberForm.getEmail() == null||memberForm.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}else {
			Matcher matcher = pattern.matcher(memberForm.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}	
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "passwordconfirm", "required");
		if(!memberForm.getPassword().isEmpty()) {
			if(!memberForm.equalConfirmPassword()) {
				errors.rejectValue("passwordconfirm", "nomatch");
			}
		}
		
	}
}
