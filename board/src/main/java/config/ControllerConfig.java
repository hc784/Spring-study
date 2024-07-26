package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import login.MemberDao;
import login.MemberRegisterService;
import login.controller.RegisterController;
import login.controller.SearchController;
import login.controller.UpdateController;

@Configuration
@ComponentScan(basePackages= {"controller","board.controller","rest"})
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
