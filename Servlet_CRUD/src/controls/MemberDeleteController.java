package controls;

import java.util.Map;

import dao.OracleMemberDao;

public class MemberDeleteController implements Controller {
	OracleMemberDao dao;
	
	public MemberDeleteController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public String execute(Map<String,Object> model)throws Exception {
		dao.deleteMember(String.valueOf(model.get("mno")));
		return "redirect:List.do";
	}
}
