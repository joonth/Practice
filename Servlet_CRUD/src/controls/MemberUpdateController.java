package controls;

import java.util.Map;

import bind.DataBinding;
import dao.OracleMemberDao;
import vo.Member;

public class MemberUpdateController implements Controller, DataBinding {
	OracleMemberDao dao;
	
	public MemberUpdateController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"mno",Integer.class,
			"member",vo.Member.class	
		};
	}
	
	public String execute (Map<String,Object> model)throws Exception{
		Integer mno = (Integer) model.get("mno");
		Member member = (Member)model.get("member");
		if(mno != null) {
			model.put("mem",dao.getMemberInfo(String.valueOf(mno)));
			return "form/UpdateForm.jsp";
		}else if(member != null) {
			dao.updateMember(member);
			return "redirect:List.do";
		}
		return "redirect:List.do";
	}
	
}
