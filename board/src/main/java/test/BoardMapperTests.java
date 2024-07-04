package test;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import board.BoardVO;
import board.Criteria;
import config.MemberConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import mapper.BoardMapper;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MemberConfig.class})
//@SpringJUnitWebConfig(MemberConfig.class)
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	@Disabled
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	@Disabled
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("test title");
		board.setContent("test content");
		board.setWriter("test writer");

		mapper.insert(board);

		log.info(board);
	}

	@Test
	@Disabled
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("test title");
		board.setContent("test content");
		board.setWriter("test writer");

		mapper.insertSelectKey(board);

		log.info("bno 값 : " + board.getBno());
	}
	
	
	@Test
	@Disabled
	public void testRead() {
		BoardVO board = mapper.read(34L);
		log.info("testRead : " + board);
	}
	
	@Test
	@Disabled
	public void testDelete() {
		log.info("delete count : "+ mapper.delete(34L));
	}
	
	@Test
	@Disabled
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(1L);
		board.setTitle("수정title");
		board.setContent("setContent");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("update count:" + count);
	}
	
	@Test
	@Disabled
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		cri.setNumXamount(cri.getAmount() * cri.getPageNum());
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("수정");
		cri.setType("C");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
		
	}


}


	
