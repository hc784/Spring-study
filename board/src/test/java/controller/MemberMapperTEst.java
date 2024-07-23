package controller;
	
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import board.MemberVO;
import config.ControllerConfig;
import config.MemberConfig;
import config.MvcConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import mapper.MemberMapper;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/root-context.xml",
"file:src/main/webapp/WEB-INF/security-context.xml"})
@Log4j2
public class MemberMapperTEst {
	

	  @Setter(onMethod_ = @Autowired)
	  private MemberMapper mapper;
	  
	  
	  @Test
	  public void testRead() {
	    
	    MemberVO vo = mapper.read("admin90");
	    
	    log.info(vo);
	    
	    vo.getAuthList().forEach(authVO -> log.info(authVO));
	    
	  }
}

