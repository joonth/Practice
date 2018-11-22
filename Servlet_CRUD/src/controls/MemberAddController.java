package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleMemberDao;
import vo.Member;

@Component("/Add.do")
public class MemberAddController implements Controller, DataBinding {
	OracleMemberDao dao;
	
	public MemberAddController setMemberDao (OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"member",	vo.Member.class
		};
	}
	
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		Member member = (Member)model.get("member");
		if(member.getEmail() == null) {
			return "form/AddForm.jsp";
		}else {
			dao.addMember(member);
			return "redirect:List.do";
		}
	}
}
