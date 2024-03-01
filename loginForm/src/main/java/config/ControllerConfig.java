package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.SearchController;
import spring.MemberDao;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberDao memberDao;
//	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);
	
//	public ControllerConfig(MemberDao memberDao){
//        this.memberDao = memberDao;
//	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
	
	@Bean 
	public SearchController serachController() {
		return new SearchController(memberDao);
	}

}
