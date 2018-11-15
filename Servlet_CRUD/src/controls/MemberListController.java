package controls;

import java.util.Map;

import dao.MemberDao;

public class MemberListController implements Controller {
	MemberDao dao;
	
	public MemberListController setMemberDao(MemberDao dao) {
		this.dao =dao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		model.put("members",dao.getList() );
		return "form/ListForm.jsp";
	}
}
