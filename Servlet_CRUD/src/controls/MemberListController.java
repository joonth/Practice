package controls;

import java.util.Map;

import dao.OracleMemberDao;

public class MemberListController implements Controller {
	OracleMemberDao dao;
	
	public MemberListController setMemberDao(OracleMemberDao dao) {
		this.dao =dao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		model.put("members",dao.getList() );
		return "form/ListForm.jsp";
	}
}
