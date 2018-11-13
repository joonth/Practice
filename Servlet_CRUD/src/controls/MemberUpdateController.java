package controls;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberUpdateController implements Controller {
	
	public String execute (Map<String,Object> model)throws Exception{
		MemberDao dao =(MemberDao)model.get("dao");
		if(model.get("member") == null) {
			model.put("mem",dao.getMemberInfo(String.valueOf(model.get("mno"))));
			return "form/UpdateForm.jsp";
		}else {
			dao.updateMember((Member)model.get("member"));
			return "redirect:List.do";
		}
	}
	
}
