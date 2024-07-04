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
public class DeleteController {
	

	MemberDao dao;
	
	@Autowired
	public DeleteController(MemberDao dao) {
		this.dao=dao;
	}
	
	@GetMapping("/DeleteMember")
	public String deleteMember() {
		return "DeleteMember";
	}
	
	@PostMapping("/delete")
	public String deletePost(@RequestParam String email) {
		dao.delete(email);
		return "DeleteSucess";
	}
}
