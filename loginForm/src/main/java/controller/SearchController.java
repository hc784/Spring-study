package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.Member;
import spring.MemberDao;

@Controller
public class SearchController {
	
	MemberDao memberDao;
	
	public SearchController(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	@GetMapping("/EmailSearch")
	public String emailSearchGet() {
		return "EmailSearch";
	}
	
	@PostMapping("/EmailSearch")
	public String emailSearchPost(Model model, @RequestParam String EmailSearch) {
		
		Member member1 = memberDao.selectByEmail(EmailSearch);
		model.addAttribute("memberId", member1);
		return "EmailSearchRet";
	}
}
