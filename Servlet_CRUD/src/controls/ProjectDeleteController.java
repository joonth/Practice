package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleProjectDao;

@Component("/pDelete.do")
public class ProjectDeleteController implements Controller, DataBinding {

	OracleProjectDao dao;
	
	public ProjectDeleteController setProjectDao(OracleProjectDao dao) {
		this.dao = dao; 
		return this;
	}
	
	
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"pno",Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		dao.delete((int)model.get("pno"));
		return "redirect:pList.do";
	}

}
