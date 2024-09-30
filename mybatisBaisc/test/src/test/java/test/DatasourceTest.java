package test;


import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.MemberConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes= {MemberConfig.class})
@Log4j2
public class DatasourceTest {

  @Setter(onMethod_ = { @Autowired })
  private DataSource dataSource;

  @Setter(onMethod_ = { @Autowired })
  private SqlSessionFactory sqlSessionFactory;

  @Test
  @Disabled
  public void testMyBatis() {
	  log.info("@@@@@@@@@@@@@@@@@@@@@@@@"+sqlSessionFactory);
    try (SqlSession session = sqlSessionFactory.openSession();
       Connection con = session.getConnection();
      ) {

      log.info(session);
      log.info(con);
      

    } catch (Exception e) {
      fail(e.getMessage());
    }

  }


  @Test
  public void testConnection() {
    
    
    try (Connection con = dataSource.getConnection()){

      log.info(con);      
      
    }catch(Exception e) {
      fail(e.getMessage());
    }
  }
}


