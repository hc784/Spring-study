package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateEmailException;
import spring.MemberDao;
import spring.MemberForm;
import spring.MemberRegisterService;

@Controller
public class RegisterController {
	
	MemberRegisterService memReg;
	MemberDao dao;
	
	@Autowired
	public RegisterController(MemberRegisterService memReg, MemberDao dao) {
		this.memReg = memReg;
		this.dao=dao;
	}
	
	
	@GetMapping("/Register")
	public String register(Model model) {
		model.addAttribute("memberForm", new MemberForm());		
		return "Register";
	}
	
	@PostMapping("/register")
	public String registerPost(Model model,@Valid MemberForm memberForm, Errors errors) {
		
		if(errors.hasErrors())
			return "Register";
		try {
			memReg.register(memberForm);
			return "RegisterSucess";
		}
		catch (DuplicateEmailException e) {
			errors.rejectValue("email", "duplicate");
			return "Register";
		}

	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberFormValidator());
	}
	

}
