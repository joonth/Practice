package dao;

import java.util.List;

import vo.Project;

public interface ProjectDao {
	List<Project> selectList() throws Exception;
	int insert(Project project) throws Exception;
	Project selectOne(int pno) throws Exception;
	int update(Project project) throws Exception;
}
