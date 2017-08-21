package project.master.dao;

import java.util.List;
import java.util.Map;

import project.master.pojo.EduComparisonComment;
import project.master.pojo.EduComparisonMaster;
import project.person.pojo.EduUser;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import framelib.utils.page.PageObject;

public interface IEduMasterReadDAO {

	/**
	 * 查询评比活动
	 * @param condition
	 * @return
	 */
	PageObject queryComparison(Map<String, Object> condition);
	/**
	 * 查询类型(省，市，县区)评比活动
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonByType(Map<String, Object> condition);

	/**
	 * 评比活动教师报名时的教师查询
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonTeacher(Map<String, Object> condition);

	/**
	 * 查询已经报名的教师
	 * @param condition
	 * @return
	 */
	List<EduComparisonComment> querySignUpComparisonTeacher(Map<String, Object> condition);

	/**
	 * 查询报名活动评比教师数量
	 * @param condition
	 * @return
	 */
	int querySignUpComparisonTeacherCount(Map<String, Object> condition);

	/**
	 * 查找活动专家
	 * @param request
	 * @return
	 */
	PageObject queryComparisonMaster(Map<String, Object> condition);

	/**
	 * 查询评比活动(专家分配评比活动)
	 * @param request
	 * @return
	 */
	PageObject queryComparisonCheck(Map<String, Object> condition);

	/**
	 * 获取地区
	 * @return
	 */
	List<SysArea> getArea(Map<String, Object> condition);

	/**
	 * 获得学校
	 * @param condition
	 * @return
	 */
	List<EduSchool> getSchool(Map<String, Object> condition);

	/**
	 * 查询审核意见
	 * @param condition
	 * @return
	 */
	List<EduComparisonComment> queryMemo(Map<String, Object> condition);

	/**
	 * 查询专家管辖下的项目
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonByMaster(Map<String, Object> condition);

	/**
	 * 专家审核-查询教师列表
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonTeacherScore(Map<String, Object> condition);

	/**
	 * 行政查看项目名教师
	 * @param condition
	 * @return
	 */
	PageObject querTeacherComment(Map<String, Object> condition);

	/**
	 * 查询教师详细的得分情况
	 * @param condition
	 * @return
	 */
	List<EduComparisonComment> queryMasterScore(Map<String, Object> condition);

	/**
	 * 查询用户
	 * @param condition
	 * @return
	 */
	List<EduUser> queryMaster(Map<String, Object> condition);
	


	
	/**
	 * 根据ID查询老师
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonTeacherById(Map<String, Object> condition);
	/**
	 * 查询报名教师列表
	 * @param condition
	 * @return
	 */
	PageObject querTeacherList(Map<String, Object> condition);
	/**
	 * 审核查询活动
	 */
	PageObject queryComparisonReview(Map<String, Object> condition);
	
	/**
	 * 查看某一专家对某一活动的评审列表
	 */
	PageObject quertJudgeDetail(Map<String, Object> condition);

	/**
	 * 为项目设置可用专家
	 * @param condition
	 * @return
	 */
	List<EduComparisonMaster> queryMasterAvailable(Map<String, Object> condition);

}
