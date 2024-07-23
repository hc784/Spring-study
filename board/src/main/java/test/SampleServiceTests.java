package test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import board.BoardVO;
import board.Criteria;
import board.service.BoardService;
import config.MemberConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import sample.SampleService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {MemberConfig.class})
@Log4j2
public class SampleServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private SampleService service;
	
	@Test
	@Disabled
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}
	
	@Test
	@Disabled
	public void testAdd() throws Exception{
		log.info(service.doAdd("123", "456"));
	}

}
