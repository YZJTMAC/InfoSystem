package project.master.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import project.master.pojo.EduComparisonComment;
import project.master.pojo.EduComparisonMaster;
import project.person.pojo.EduUser;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import framelib.utils.page.PageObject;

/**
 * 评选流程
 * 
 * @author zhudi TMACJ
 * 
 */
public interface IEduMasterService {

	/**
	 * 新增评比活动
	 * 
	 * @param condition
	 * @return
	 */
	Integer addComparison(Map<String, Object> condition);

	/**
	 * 查询评比活动
	 * 
	 * @param condition
	 * @return
	 */
	PageObject queryComparison(Map<String, Object> condition);

	/**
	 * 修改评比活动
	 * 
	 * @param condition
	 * @return
	 */
	int updateComparison(Map<String, Object> condition);

	/**
	 * 删除评比活动
	 * 
	 * @param condition
	 * @return
	 */
	boolean deleteComparison(Map<String, Object> condition);

	/**
	 * 评比活动教师
	 * 
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonTeacher(Map<String, Object> condition);

	/**
	 * 教师报名评比活动（单个）
	 * 
	 * @param condition
	 * @return
	 */
	int signUpComparisonTeacher(Map<String, Object> condition);

	/**
	 * 教师取消报名评比活动（单个）
	 * 
	 * @param condition
	 * @return
	 */
	boolean canelSignUpComparisonTeacher(Map<String, Object> condition);

	/**
	 * 更改教师报名状态
	 * 
	 * @param condition
	 * @return
	 */
	boolean updateComparisonCommentStatus(Map<String, Object> condition);

	/**
	 * 查询已经报名的教师
	 * 
	 * @param condition
	 * @return
	 */
	List<EduComparisonComment> querySignUpComparisonTeacher(Map<String, Object> condition);

	/**
	 * 教师报名评比活动（批量）
	 * 
	 * @param condition
	 * @return
	 */
	boolean signUpComparisonTeacherBatch(Map<String, Object> condition);

	/**
	 * 取消教师报名评比活动（批量）
	 * 
	 * @param condition
	 * @return
	 */
	boolean canelSignUpComparisonTeacherBatch(Map<String, Object> condition);

	/**
	 * 查询报名活动评比教师数量
	 * 
	 * @param condition
	 * @return
	 */
	int querySignUpComparisonTeacherCount(Map<String, Object> condition);

	/**
	 * 按照一定数目为评比活动创建专家
	 * 
	 * @param condition
	 * @return
	 */
	boolean createMaster(Map<String, Object> condition);

	/**
	 * 查找活动专家
	 * 
	 * @param request
	 * @return
	 */
	PageObject queryComparisonMaster(Map<String, Object> condition);

	/**
	 * 将专家账号设为禁用
	 * 
	 * @param condition
	 */
	boolean updateComparisonMasterDisable(Map<String, Object> condition);

	/**
	 * 为专家添加活动
	 * 
	 * @param request
	 * @return
	 */
	boolean saveComparisonToMaster(Map<String, Object> condition);

	/**
	 * 查询评比活动(专家分配评比活动)
	 * 
	 * @param request
	 * @return
	 */
	PageObject queryComparisonCheck(Map<String, Object> condition);

	/**
	 * 删除评比活动(专家分配评比活动)
	 * @param request
	 * @return
	 */
	boolean deleteComparisonToMaster(Map<String, Object> condition);

	/**
	 * 创建专家（逐条）
	 * @param condition
	 * @return
	 */
	boolean createMasterOne(Map<String, Object> condition);

	/**
	 * 设置专家状态
	 * @param condition
	 * @return
	 */
	boolean setMasterStatus(Map<String, Object> condition);

	/**
	 * 刪除活動的文件
	 * @param request
	 * @return
	 */
	boolean delComprisonFile(Map<String, Object> condition);

	/**
	 * 设置活動状态
	 * @return
	 */
	boolean setComparisonStatus(Map<String, Object> condition);

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
	 * 修改上报教师信息
	 * @param condition
	 * @return
	 */
	int updateSignUpComparisonTeacher(Map<String, Object> condition);

	/**
	 * 查询审核意见
	 * @return
	 */
	List<EduComparisonComment> queryMemo(Map<String, Object> condition);

	/**
	 * 查询该专家管辖下的项目
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonByMaster(Map<String, Object> condition);

	/**
	 * 专家给教师打分
	 * @param condition
	 * @return
	 */
	boolean judgeScore(Map<String, Object> condition);

	/**
	 * 专家审核-查询教师列表
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonTeacherScore(Map<String, Object> condition);

	/**
	 * 行政查看醒目报名教师
	 * @param condition
	 * @return
	 */
	PageObject queryTeacherComment(Map<String, Object> condition);

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
	 * 修改专家信息
	 * @param condition
	 * @return
	 */
	boolean updateMasterOne(Map<String, Object> condition);


	/**
	 * 批量导入专家时，校验数据
	 * @param is
	 * @param fileType
	 * @return
	 * @throws IOException 
	 */
	Map<String, Object> searchMasterExcel(InputStream is, String fileType) throws IOException;

	/**
	 * 专家导入 提交数据
	 * @param toDBpath 数据正确的excel路径
	 * @param account 登录人，用于creat_by update_by
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws Exception
	 */
	Map<String, Object> intoDB(String path, String account) throws IOException;

	/**
	 * 查看某一专家对某一活动的评审列表
	 */
	PageObject quertJudgeDetail(Map<String, Object> condition);

	/**
	 * 查询可用专家
	 * @param condition
	 */
	List<EduComparisonMaster> queryMasterAvailable(Map<String, Object> condition);
	/**
	 * 根据类型（省，市，县区）查找活动
	 * @author TMACJ
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonByType(Map<String, Object> condition);
	/**
	 * 根据活动ID查找老师列表
	 * @author TMACJ
	 * @param condition
	 * @return PageObject
	 */
	PageObject querySignUpComparisonTeacherById(Map<String, Object> condition);
	/**
	 * 根据ID更新报名教师状态
	 * @author TMACJ
	 * @param condition
	 * @return boolean
	 */
	boolean updateTeacherStatus(Map<String, Object> condition);
	/**
	 * 查询教师列表
	 * @author TMACJ
	 * @param condition
	 */
	public PageObject queryTeacherList(Map<String, Object> condition);
	/**
	 * 查询审核评比活动
	 * 
	 * @param condition
	 * @return
	 */
	PageObject queryComparisonReview(Map<String, Object> condition);
}
