package login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.AuthInfo;
import login.AuthService;
import login.DuplicateEmailException;
import login.MemberDao;
import login.MemberForm;
import login.MemberRegisterService;
import login.WrongIdPasswordException;

@Controller
@RequestMapping("/LoginPage")
public class LoginController {
	private AuthService authService;
	
	@Autowired
	public void setAuthService(AuthService authService)
	{
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER",required=false) Cookie rCookie) {
		if(rCookie!=null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		return "/login/login/LoginPage";
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session,HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "/login/login/LoginPage";
		} 
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);
			}
			else {
				rememberCookie.setMaxAge(0);
				
			}
			response.addCookie(rememberCookie);
			
			return "/login/login/LoginSucess";
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "/login/login/LoginPage";
		}
	}	
}
