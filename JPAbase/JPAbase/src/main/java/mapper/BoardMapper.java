package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import borad.BoardVO;





public interface BoardMapper {
	@Select("select * from board where bno<10")
	public List<BoardVO> getList();
	

}
