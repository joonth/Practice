package controls;

import java.util.Map;
import annotation.Component;
import dao.OracleProjectDao;


@Component("/pList.do")
public class ProjectListController implements Controller {
	OracleProjectDao dao;
	
	public ProjectListController setProjectDao(OracleProjectDao dao) {
		this.dao = dao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("projects",dao.selectList());
		return "project/ProjectList.jsp";
	}

}
