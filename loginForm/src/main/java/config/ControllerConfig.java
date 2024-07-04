package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.SearchController;
import controller.UpdateController;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
@ComponentScan(basePackages= {"controller"})
public class ControllerConfig {
	
	private MemberDao memberDao;
	private MemberRegisterService memReg;
	
	@Autowired
	public ControllerConfig(MemberDao memberDao, MemberRegisterService memReg){
        this.memberDao = memberDao;
        this.memReg = memReg;
	}
	
	
	@Bean 
	public SearchController searchController() {
		return new SearchController(memberDao);
	}
	
	@Bean
	public UpdateController updateController() {
		return new UpdateController(memberDao);
	}
}
