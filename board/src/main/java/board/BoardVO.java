package board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private String title, content, writer;
	private Date regdate, updateDate;
	private int replyCnt;
	
}
