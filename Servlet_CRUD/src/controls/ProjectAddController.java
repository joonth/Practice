package controls;


import java.util.Map;

import annotation.Component;
import dao.OracleProjectDao;
import vo.Project;

@Component("/pAdd.do")
public class ProjectAddController implements Controller {

	OracleProjectDao dao;
	
	public ProjectAddController setProjectDao(OracleProjectDao dao) {
		this.dao = dao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"project",vo.Project.class
		};
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Project project  = (Project) model.get("project");
		if(project==null) {
			return "project/ProjectForm.jsp";
		}else {
			dao.insert(project);			
			return "pList.do";
		}
	}
}
