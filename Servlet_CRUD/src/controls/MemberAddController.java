package controls;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberAddController implements Controller {
	MemberDao dao;
	
	public MemberAddController setMemberDao (MemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		if(model.get("member") == null) {
			return "form/AddForm.jsp";
		}else {
			dao.addMember((Member)model.get("member"));
			return "redirect:List.do";
		}
	}
}
