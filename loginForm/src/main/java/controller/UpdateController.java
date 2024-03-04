package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring.Member;
import spring.MemberDao;
import spring.MemberForm;

@Controller
public class UpdateController {
	
	MemberDao dao;
	
	@Autowired
	public UpdateController(MemberDao dao) {
		this.dao= dao;
	}
	
	@GetMapping("/UpdateMember")
	public String updateMember(Model model)
	{	
		boolean emailSucess = false;
 		model.addAttribute("emailSucess", emailSucess);
		return "UpdateMember";
	}
	
	
	@PostMapping("/searchEmailForUpdate")
	public String serachEmail(HttpServletRequest req,Model model) {
		spring.Member mem = dao.selectByEmail(req.getParameter("email"));
		if(mem!=null)
		{
			model.addAttribute("emailSucess", true);
			model.addAttribute("email", req.getParameter("email"));
		}
			
		return "UpdateMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMemberPost(MemberForm memberForm)
	{
		Member mem = new Member(memberForm.getEmail(), memberForm.getName(),memberForm.getPassword());
		System.out.println(memberForm.getEmail() + memberForm.getName() + memberForm.getPassword());
		dao.update(mem);
		return "UpdateMemberSucess";
	}
	
}
