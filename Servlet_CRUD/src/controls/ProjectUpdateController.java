package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.OracleProjectDao;
import dao.ProjectDao;
import vo.Project;

@Component("/pUpdate.do")
public class ProjectUpdateController implements Controller,DataBinding {

	OracleProjectDao dao;
	
	public ProjectUpdateController setProjectDao (OracleProjectDao dao) {
		this.dao = dao;
		return this;
	}
	
	
	public Object[] getDataBinders() {
		return new Object[]{
				"pno",Integer.class,
				"project",vo.Project.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Project project =(Project)model.get("project");
		if(project.getPname() == null) {
			model.put("project", dao.selectOne((int)model.get("pno")));
			return "/project/ProjectUpdateForm.jsp";
		}else {
			dao.update(project);
			return "redirect:pList.do";
		}
	}
}
