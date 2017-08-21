package project.furtheredu.edumanage.dao;

import java.util.List;
import java.util.Map;

import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.pojo.EduSignet;
import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.furtheredu.edumanage.pojo.TeacherCertificateExportActivity;
import project.furtheredu.edumanage.pojo.TeacherInfoActivity;
import project.furtheredu.edumanage.pojo.TeacherProActivity;

public interface IEduManageReadDao {
	
	public List<EduTearcherAssess> selectTeacherAssessNoTrainInfo(
			Map<String, Object> paramMap) throws Exception;

	Integer selectManageCountByCondition(Map<String, Object> param);

	/**
	 * 年度考核设置
	 * @param param
	 * @return
	 */
	List<Object> selectManageListByCondition(Map<String, Object> param);

	/**
	 * 分组查询教师年度考核
	 * @param param 
	 *  年度、地区：省 市 区
	 * @return
	 */
	List<Object> selectManageListGroupByYearCondition(Map<String, Object> param);

	/**
	 * 分组查询教师年度考核
	 * @param param 
	 *  年度、地区：省 市 区
	 * @return
	 */
	Integer selectManageCountGroupByYearCondition(Map<String, Object> param);

	/**
	 * 查询项目评价
	 * @param param
	 * @return
	 */
	Integer selectEvaluationCountByCondition(Map<String, Object> param);

	List<Object> selectEvaluationListByCondition(Map<String, Object> param);

	/**
	 * 查看项目总体评分 详情
	 * @param param
	 * @return
	 */
	List<Object> selectEvaluationInfo(Map<String, Object> param);

	/**
	 * 查询教师培训记录
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List selectteacherCommentActivityByCondition(Map<String, Object> param);

	 
	 /**
	 * 继教考核查询
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessList(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 年度考核信息
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessTargetList(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 继教考核详细
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessInfo(Map<String, Object> paramMap) throws Exception;

	
	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherProActivity> selectTeacherProByStatusTrain(Map<String, Object> paramMap) throws Exception;

	
	
	/**
	 * 教师项目证书打印--查询已审核的项目--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherProActivity> selectTeacherProByStatusNoTrain(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 查询电子印章列表
	 * @param param
	 * @return
	 */
	List<EduSignet> selectSignetList(Map<String, Object> param);
	
	/**
	 * 根据用户角色和层级查询电子印章列表
	 * @param param
	 * @return
	 */
	List<EduSignet> selectSignetListByDictAndRole(Map<String, Object> param);

	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherProActivity> selectSSProByStatusTrain(Map<String, Object> paramMap) throws Exception;

	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目--(培训类)的数量
	 * @author 曉
	 * @param paramMap
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectSSProByStatusTrainCount(Map<String, Object> paramMap) throws Exception;
	/**
	 * 实施/管理项目证书打印--查询已审核的项目--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherProActivity> selectSSProByStatusNoTrain(Map<String, Object> paramMap) throws Exception;

	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师总数--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int selectTeacherByProIdCount_Train(Map<String, Object> paramMap) throws Exception;

	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师总数--(培训类)
	 * 根据教师所在学校和教师姓名，身份证查询
	 * */
	public int selectTeacherCount_Train(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherInfoActivity> selectTeacherByProId_Train(Map<String, Object> paramMap) throws Exception;
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师--(培训类)
	 * 根据学校和老师姓名、身份证号查询
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherInfoActivity> selectTeacher_Train(Map<String, Object> paramMap) throws Exception;

	
	/**
	 * 实施/管理项目证书打印--查询已审核的项目下的教师总数--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int selectTeacherByProIdCount_NoTrain(Map<String, Object> paramMap) throws Exception;

	
	/**
	 * 实施/管理项目证书打印--查询已审核的项目下的教师--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherInfoActivity> selectTeacherByProId_NOTrain(Map<String, Object> paramMap) throws Exception;

	public EduDiploma queryDeplomaByProjectInfo(Map<String, Object> param) throws Exception;

	/**
	 * 教师证书导出
	 * @param param
	 * @return
	 */
	List<TeacherCertificateExportActivity> selectTeacherCertificateActivetyListByConditionNoPage(Map<String, Object> param)  throws Exception;

	/**
	 * 查询年度证书
	 * @param condition
	 * @return
	 */
	public List<EduDiploma> selectYearDiploma(Map<String, Object> condition);

}
