package controls;

import java.util.Map;

import dao.MemberDao;

public class MemberDeleteController implements Controller {
	public String execute(Map<String,Object> model)throws Exception {
		MemberDao dao = (MemberDao)model.get("dao");
		dao.deleteMember(String.valueOf(model.get("mno")));
		return "redirect:List.do";
	}
}
