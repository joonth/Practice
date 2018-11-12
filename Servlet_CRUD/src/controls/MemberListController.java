package controls;

import java.util.Map;

import dao.MemberDao;

public class MemberListController implements Controller {
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		MemberDao dao = (MemberDao) model.get("dao");
		model.put("members",dao.getList() );
		return "form/ListForm.jsp";
	}
}
