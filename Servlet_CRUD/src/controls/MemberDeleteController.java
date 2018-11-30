package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleMemberDao;


@Component("/Delete.do")
public class MemberDeleteController implements Controller,DataBinding {
	OracleMemberDao dao;
	
	public MemberDeleteController setMemberDao(OracleMemberDao dao) {
		this.dao = dao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"mno",Integer.class	
		};
	}
	
	public String execute(Map<String,Object> model)throws Exception {
		Integer mno = (Integer) model.get("mno");
		if(mno != null) {
			dao.deleteMember(String.valueOf(mno));
		}
		return "redirect:List.do";
	}

}
