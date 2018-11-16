package controls;

import java.util.Map;

import dao.OracleMemberDao;
import vo.Member;

public class MemberUpdateController implements Controller {
	OracleMemberDao dao;
	
	public MemberUpdateController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public String execute (Map<String,Object> model)throws Exception{
		if(model.get("member") == null) {
			model.put("mem",dao.getMemberInfo(String.valueOf(model.get("mno"))));
			return "form/UpdateForm.jsp";
		}else {
			dao.updateMember((Member)model.get("member"));
			return "redirect:List.do";
		}
	}
	
}
