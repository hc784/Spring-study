package test;

import java.util.List;
import java.util.stream.IntStream;

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
import board.ReplyVO;
import config.MemberConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import mapper.BoardMapper;
import mapper.ReplyMapper;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MemberConfig.class})
//@SpringJUnitWebConfig(MemberConfig.class)
@Log4j2
public class ReplyMapperTests {

	private Long[] bnoArr = { 20000L,19999L,19998L,19997L,19996L};
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	@Disabled
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	@Disabled
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
//			vo.setBno(bnoArr[i%5]);
			vo.setBno(bnoArr[0]);
			vo.setReply("댓글 테스트 " + i+10);
			vo.setReplyer("replyer"+(i+10));
			mapper.insert(vo);
		});
	}
	
	@Test
	@Disabled
	public void testRead() {
		
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		log.info("댓글 읽기 " + vo);
	}
	
	@Test
	@Disabled
	public void testDelete() {
		Long targetRno = 1L;
		
		mapper.delete(targetRno);
	}
	
	@Test
	@Disabled
	public void testUpdate() {
		Long targetRno = 3L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("update reply ");
		int count = mapper.update(vo);
		log.info("update count : " + count);
	}
	
	@Test
	@Disabled
	public void testList() {
		
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
	@Test
	@Disabled
	public void testList2() {
		
		Criteria cri = new Criteria(1,10);
//		cri.setPageNum();
//		cri.setAmount(10);
//		cri.setNumXamount(cri.getAmount() * cri.getPageNum());
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
}


	
