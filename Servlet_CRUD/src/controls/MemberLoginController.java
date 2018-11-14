package controls;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberLoginController implements Controller {
	
	public String execute(Map<String,Object> model) throws Exception{
		if(model.get("memberChk")!=null) {
			MemberDao dao = (MemberDao) model.get("dao");
			model.put("smember", dao.login((Member)model.get("memberChk")));
			return "redirect:List.do";			
		}else {
			return "redirect:form/LoginForm.jsp";
		}
	}
	
}
