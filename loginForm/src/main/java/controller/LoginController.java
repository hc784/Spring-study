package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	@GetMapping("/LoginPage")
	public String login() {
		return "LoginPage";
	}
	
	@GetMapping("/Register")
	public String register() {
		return "Register";
	}
	
	
}
