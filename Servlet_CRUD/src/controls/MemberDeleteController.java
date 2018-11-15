package controls;

import java.util.Map;

import dao.MemberDao;

public class MemberDeleteController implements Controller {
	MemberDao dao;
	
	public MemberDeleteController setMemberDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public String execute(Map<String,Object> model)throws Exception {
		dao.deleteMember(String.valueOf(model.get("mno")));
		return "redirect:List.do";
	}
}
