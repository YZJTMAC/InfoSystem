package project.teacher.teachermanage.dao;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.system.pojo.EduTeacherScoreInfo;
import project.teacher.teachermanage.pojo.EduAudit;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.teacher.teachermanage.pojo.TeacherActivity;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.teacher.teachermanage.pojo.TeacherInfoChangeRecord;

public interface ITeacherReadDao {
	
	/**
	 * 教师信息综合查询
	 * @param param
	 * @return
	 */
	public List<Object> selectTeacherActivetyListByCondition(Map<String,Object> param);
	
	public Integer selectTeacherActivetyCountByCondition(Map<String,Object> param);

	
	/**
	 * 根据教师ID 查询所有信息最高版本号
	 * @param param
	 * @return
	 */
	public EduTeacherVersionPOJO selectTeacherAllVersion(Integer teacherId);
	
	/**
	 * 信息变更列表
	 * @author cl
	 * @create date 2014-4-9
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduAudit> selectTeacherChangeList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 业务管理员查看信息变更列表
	 * @author zhangBo
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherInfoChangeRecord> selectChangeRecord(Map<String,Object> params) throws Exception;
	
	int selectCountChangeRecord(Map<String,Object> params) throws Exception;
	
	project.teacher.teacherProject.pojo.EduAudit selectEduAuditById(int id) throws Exception;
	
	List<EduTeacherEducation> selectAllInfoByVersionAndTeacherId(Map<String,Object> params) throws Exception;
	
	/**调动管理 记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectMobilizeCount(Map<String, Object> paramMap) throws Exception;

	/**
	 * 查询教师离退记录
	 * @param param
	 * @return
	 */
	List<Object> selectTeacherRetiressActivetyListByCondition(
			Map<String, Object> param);

	Integer selectTeacherRetiressActivetyCountByCondition(
			Map<String, Object> param);

	 /**
	 * 调动管理   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectMobilizeList(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 调动管理   记录详情
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize selectMobilizeInfo(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 调动管理   新建调动 记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectCreateMobilizeList(
			Map<String, Object> paramMap) throws Exception;
	
	/**查询教师信息变动总数
	 * @author cl
	 * @create date 2014-4-17
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectAuditChangeType(Map<String, Object> paramMap) throws Exception;

	/**
	 * 
	 * @param param
	 * @return
	 */
	List<TeacherExportActivity> selectTeacherActivetyListByConditionNoPage(
			Map<String, Object> param);
	
	 /**
	 * 调动管理   审核相关信息
	 * @author cl
	 * @create date 2014-4-20
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize selectMobilizeAudit(Integer id) throws Exception;
	
	/**编制调整管理 记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectAdjustCount(Map<String, Object> paramMap)
			throws Exception;
	
	 /**
	 * 编制调整管理   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherAdjust> selectAdjustList(
			Map<String, Object> paramMap) throws Exception;
	
	/**我的调动记录  记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectTeacherMobilizeCount(Map<String, Object> paramMap)
			throws Exception;
	
	
	/**
	 * 我的调动记录   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectTeacherMobilizeList(
			Map<String, Object> paramMap) throws Exception;

	/**
	 * 查询教师自主研修
	 */
	public PageObject queryTeacherIndeptStudyList(Map<String, Object> condition);
	/**
	 * 查询教师自主研修学分
	 */
	public Float queryTeacherIndeptStudyCredit(Map<String, Object> params);
	/**
	 * 查询教师自主研修剩余学分
	 */
	public List<EduTeacherScoreInfo> getTeacherIsTrainRemainCredit(
			Map<String, Object> params, int i, int j);
	/**
	 * 查询教师特殊研修
	 */
	public PageObject queryTeacherSpecialCaseList(Map<String, Object> conditions);

}
