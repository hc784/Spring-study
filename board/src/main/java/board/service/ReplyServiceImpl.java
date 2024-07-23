package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.Criteria;
import board.ReplyPageDTO;
import board.ReplyVO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import mapper.BoardMapper;
import mapper.ReplyMapper;

@Service
@Log4j2
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	@Override
	public int register(ReplyVO vo) {

		log.info("register......" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);

	}

	@Override
	public ReplyVO get(Long rno) {

		log.info("get......" + rno);

		return mapper.read(rno);

	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("modify......" + vo);

		return mapper.update(vo);

	}

	@Override
	public int remove(Long rno) {

		log.info("remove...." + rno);
		
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);

	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {

		log.info("get Reply List of a Board " + bno);

		return mapper.getListWithPaging(cri, bno);

	}

	
	  @Override 
	  public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		  cri.setNumXamount(cri.getAmount() * (cri.getPageNum()-1));
		  return new ReplyPageDTO( mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno)); }
	  
	 
}
