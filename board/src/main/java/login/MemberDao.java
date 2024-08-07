package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
			List<Member> results = jdbcTemplate.query(
					"select * from MEMBER where EMAIL = ?", 
					new RowMapper<Member>() {
						@Override
						public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
							Member member = new Member(
											rs.getString("EMAIL"),
											rs.getString("NAME"),
											rs.getString("PASSWORD"));
							member.setId(rs.getLong("ID"));
											
									
							return member;
						}
		
			}, email);
		
			return results.isEmpty()?null:results.get(0);
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER", 
				(rs,rowNum) -> {
					Member mem = new Member(
							rs.getString("EMAIL"),
							rs.getString("NAME"),
							rs.getString("PASSWORD"));
						mem.setId(rs.getLong("ID"));
						return mem;
				});
//				
//				new RowMapper<Member>() {
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member member = new Member(
//										rs.getString("EMAIL"),
//										rs.getString("PASSWORD"),
//										rs.getString("NAME"));
//						member.setId(rs.getLong("ID"));
//										
//								
//						return member;
//					}
//	
//		});
	
		return results;
}
	
	public String queryTest() {
		return jdbcTemplate.queryForObject("select EMAIL from MEMBER where NAME = \"aa\"", String.class);
	}
	
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL,PASSWORD,NAME) values (?,?,?)"
						,new String[] {"ID"});
				pstmt.setString(1,member.getEmail());
				pstmt.setString(2,member.getPassword());
				pstmt.setString(3,member.getName());
				
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	
	public void update(Member member) {
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", member.getName(),member.getPassword(),member.getEmail());
	}
	
	public void delete(String email) {
		jdbcTemplate.update("delete from MEMBER WHERE EMAIL=?",email);
	}
	
}
