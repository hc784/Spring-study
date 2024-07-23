package controller;
	
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;

import config.ControllerConfig;
import config.MemberConfig;
import config.MvcConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes= {MemberConfig.class, MvcConfig.class, ControllerConfig.class})
@Log4j2
public class SampleControllerTests {

  @Setter(onMethod_ = { @Autowired })
  private WebApplicationContext ctx;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
	  log.info("테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트" + ctx);

    this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  }

  @Test
  public void testConvert() throws Exception {

    board.Ticket ticket = new board.Ticket();
    ticket.setTno(123);
    ticket.setOwner("Admin");
    ticket.setGrade("AAA");
    
    String jsonStr = new Gson().toJson(ticket);
    
    log.info("테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트" + mockMvc);
    
    
    
    mockMvc.perform(post("/sample/ticket")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content(jsonStr))
        .andExpect(status().is(200));
  }

}


