package project.teacher.teacherProject.dao;

import java.util.Map;

public interface ITeacherProjectWriteDaoIF {

	/**
	 * 教师加入项目报名--不需要审核
	 * @param area
	 * @return
	 * @throws Exception
	 */
	boolean insertCommentTeacherInfo2(String projectId,Integer teacherId,int jobVersion,String loginAccount,int status,String type) throws Exception;
	
	/**
	 * 教师加入项目报名
	 * @param area
	 * @return
	 * @throws Exception
	 */
	boolean insertCommentTeacherInfo(Integer organizationId, String projectId,Integer teacherId,int jobVersion,String loginAccount,int status,String type) throws Exception;
	
	/**
	 * 教师对已结束的项目评价
	 * @param area
	 * @return
	 * @throws Exception
	 */
	boolean insertTeacherComment(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师去学习插入机构id
	 * @param area
	 * @return
	 * @throws Exception
	 */
	boolean insertTeacherOrganizationId(Map<String,Object> paramMap) throws Exception;

	int countTeacherSignInfo(String projectId, Integer teacherId,
			int jobVersion, String loginAccount, int status, String type)
			throws Exception;

	int updateTeacherSignInfo(String projectId, Integer teacherId,
			int jobVersion, String loginAccount, int status, String type);

	/***
	 * 添加借贷学分记录
	 * @param conditions
	 * @return
	 */
	public boolean insertLendCredit(Map<String, Object> conditions);

	/***
	 * 修改借贷学分记录
	 * @param conditions
	 * @return
	 */
	boolean updateLendCredit(Map<String, Object> conditions);

	/***
	 * 偿还学分
	 * @param conditions
	 * @return
	 */
	boolean repayLendCredit(Map<String, Object> conditions);
}
