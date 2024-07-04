package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.MemberConfig;
import spring.Member;
import spring.MemberDao;

public class MemberDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);
		MemberDao dao = ac.getBean("memberDao",MemberDao.class);

		dao.delete("aa");

		System.out.println("delete 성공");
		ac.close();

		
	}
}
