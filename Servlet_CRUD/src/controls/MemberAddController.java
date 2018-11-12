package controls;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberAddController implements Controller {
	@Override
	public String execute(Map<String,Object> model)throws Exception{
		if(model.get("member") == null) {
			return "form/AddForm.jsp";
		}else {
			MemberDao dao = (MemberDao)model.get("dao");
			dao.addMember((Member)model.get("member"));
			return "redirect:List.do";
		}
	}
}
