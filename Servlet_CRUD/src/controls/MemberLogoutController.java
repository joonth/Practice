package controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class MemberLogoutController implements Controller {
	public String execute (Map<String,Object> model) {
		HttpSession session =(HttpSession)model.get("session");
		session.invalidate();
		return "redirect:Login.do";
	}
}
