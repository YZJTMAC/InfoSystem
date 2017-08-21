package project.furtheredu.eduTarget.dao;

import project.furtheredu.eduTarget.pojo.EduTargetByYear;

public interface IEduTagetWriteDao {

	Integer insertTagetInfo(EduTargetByYear target) throws Exception;

	Integer deleteTargetById(Integer id) throws Exception;

	Integer updateTarget(EduTargetByYear target) throws Exception;
	
	 
}
