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

import config.ControllerConfig;
import config.MemberConfig;
import config.MvcConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/root-context.xml",
"file:src/main/webapp/WEB-INF/security-context.xml"})
@Log4j2
public class MemberTest {
	
	 @Setter(onMethod_ = @Autowired)
	  private PasswordEncoder pwencoder;
	  
	  @Setter(onMethod_ = @Autowired)
	  private DataSource ds;
	  
	  @Test
	  @Disabled
	  public void testInsertMember() {

	    String sql = "insert into tbl_member(userid, userpw, username) values (?,?,?)";
	    
	    for(int i = 0; i < 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	        
	        pstmt.setString(2, pwencoder.encode("pw" + i));
	        
	        if(i <80) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(3,"일반사용자"+i);
	          
	        }else if (i <90) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(3,"운영자"+i);
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(3,"관리자"+i);
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
	  

	  @Test
	  @Disabled
	  public void testInsertAuth() {
	    
	    
	    String sql = "insert into tbl_member_auth (userid, auth) values (?,?)";
	    
	    for(int i = 0; i < 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	      
	        
	        if(i <80) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(2,"ROLE_USER");
	          
	        }else if (i <90) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(2,"ROLE_MEMBER");
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(2,"ROLE_ADMIN");
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
}

