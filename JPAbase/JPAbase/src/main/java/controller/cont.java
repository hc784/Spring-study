package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class cont {
	
	@GetMapping("/test")
	String test() {
		
		return "/NewFile";
	}
	
	@PostMapping("/test")
	String ptest(Model m, @RequestParam("t1") String s) {
		m.addAttribute("hi",s);
		
		return "/NewFile";
	}
}
