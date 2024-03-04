package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Member;

import spring.DuplicateEmailException;
import spring.MemberDao;
import spring.MemberForm;
import spring.MemberRegisterService;

@Controller
public class LoginController {
	
	MemberRegisterService memReg;
	MemberDao dao;
	
	public LoginController(MemberRegisterService memReg, MemberDao dao) {
		this.memReg = memReg;
		this.dao=dao;
	}
	
	@GetMapping("/LoginPage")
	public String login() {
		return "LoginPage";
	}
	
	@GetMapping("/Register")
	public String register(Model model) {
		model.addAttribute("memberForm", new MemberForm());		
		return "Register";
	}
	
	@PostMapping("/register")
	public String registerPost(Model model,MemberForm memberForm) {
		try {
			memReg.register(memberForm);
			return "RegisterSucess";
		}
		catch (DuplicateEmailException e) {
			model.addAttribute("e", e);
			return "Register";
		}

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
