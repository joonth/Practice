package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleMemberDao;
import vo.Member;

@Component("/Update.do")
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
		System.out.println(mno);
		Member member = (Member)model.get("member");
		System.out.println(member.getMno() + " " +member.getMname() + " " +member.getEmail() + " " + member.getCre_date());
		if(mno != null && member.getEmail() == null) {
			model.put("mem",dao.getMemberInfo(String.valueOf(mno)));
			System.out.println("11");
			return "form/UpdateForm.jsp";
		}else if(member != null) {
			dao.updateMember(member);
			System.out.println("22");
			return "redirect:List.do";
		}
		return "redirect:List.do";
	}
	
}
