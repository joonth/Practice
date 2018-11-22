package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleMemberDao;
import vo.Member;

@Component("/Login.do")
public class MemberLoginController implements Controller,DataBinding {
	OracleMemberDao dao;
	
	public MemberLoginController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"member" ,vo.Member.class
		};
	}
	
	public String execute(Map<String,Object> model) throws Exception{
		Member member = (Member) model.get("member");
		if(member.getEmail()!=null) {
			model.put("smember", dao.login(member));
			return "redirect:List.do";			
		}else {
			return "redirect:form/LoginForm.jsp";
		}
	}

	
}
