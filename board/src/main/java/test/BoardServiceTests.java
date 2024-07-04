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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {MemberConfig.class})
@Log4j2
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	@Disabled
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	@Disabled
	public void testRegister() {
		BoardVO board= new BoardVO();
		board.setTitle("new title");
		board.setContent("new conte");
		board.setWriter("new writer");
		
		service.register(board);
	
		log.info("게시글 bno : " + board.getBno());
	}
	
	@Test
//	@Disabled
	public void testGetList() {
//		service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(2,10)).forEach(board->log.info(board));
	}
	
	@Test
	@Disabled
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	@Disabled
	public void testDelete() {
		log.info("remove result : " + service.remove(2L));
	}
	
	@Test
	@Disabled
	public void testUpdate() {
		BoardVO board = service.get(3L);
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정");
		log.info("modify result : " + service.modify(board));
	}
}
