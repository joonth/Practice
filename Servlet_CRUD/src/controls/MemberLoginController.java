package controls;

import java.util.Map;

import dao.OracleMemberDao;
import vo.Member;

public class MemberLoginController implements Controller {
	OracleMemberDao dao;
	
	public MemberLoginController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public String execute(Map<String,Object> model) throws Exception{
		if(model.get("memberChk")!=null) {
			model.put("smember", dao.login((Member)model.get("memberChk")));
			return "redirect:List.do";			
		}else {
			return "redirect:form/LoginForm.jsp";
		}
	}
	
}
