package spring;

public class MemberRegisterService {
	
	MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public long register(MemberForm memberForm) {
		Member mem = memberDao.selectByEmail(memberForm.getEmail());
		if(mem!=null)	
			throw new DuplicateEmailException("duplicate Email" + memberForm.getEmail());
		Member newMember = new Member(memberForm.getEmail(), memberForm.getName(), memberForm.getPassword());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
