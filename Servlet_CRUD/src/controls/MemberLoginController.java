package controls;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberLoginController implements Controller {
	MemberDao dao;
	
	public MemberLoginController setMemberDao(MemberDao dao) {
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
