package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.SearchController;
import controller.UpdateController;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	private MemberDao memberDao;
	private MemberRegisterService memReg;
	
	@Autowired
	public ControllerConfig(MemberDao memberDao, MemberRegisterService memReg){
        this.memberDao = memberDao;
        this.memReg = memReg;
	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController(memReg,memberDao);
	}
	
	@Bean 
	public SearchController serachController() {
		return new SearchController(memberDao);
	}
	
	@Bean
	public UpdateController updateController() {
		return new UpdateController(memberDao);
	}
}
