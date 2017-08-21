package project.furtheredu.edumanage.dao.impl;

import java.util.List;
import java.util.Map;

import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.dao.IEduManageReadDao;
import project.furtheredu.edumanage.pojo.EduSignet;
import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.furtheredu.edumanage.pojo.TeacherCertificateExportActivity;
import project.furtheredu.edumanage.pojo.TeacherInfoActivity;
import project.furtheredu.edumanage.pojo.TeacherProActivity;
import framelib.dao.BaseDAOImpl;

/**
 * 
 * @Create_by:dengguo
 * @Create_date:2014-3-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
@SuppressWarnings("unchecked")
public class EduManageReadDaoImpl extends BaseDAOImpl implements IEduManageReadDao { 
	
	@Override  
	public Integer selectEvaluationCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectProcjectEvaluationListCount", param);
	}
	
	@Override
	public List<Object> selectEvaluationListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectProcjectEvaluationList", param);
	}
	
	@Override
	public List<Object> selectEvaluationInfo(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectProcjectEvaluationInfo", param);
	}
	
	@Override  
	public List selectteacherCommentActivityByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("teacherCommentActivityList", param);
	}
	
	@Override  
	public Integer selectManageCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCommentListCount", param);
	}
	
	@Override
	public List<Object> selectManageListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectCommentList", param);
	}
	
	@Override  
	public Integer selectManageCountGroupByYearCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCommentListCountGroupByYear", param);
	}
	
	@Override
	public List<Object> selectManageListGroupByYearCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectCommentListGroupByYear", param);
	}

	 /**
	 * 继教考核查询
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessList(
			Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectTeacherAssessList", paramMap);
	}

	 /**
	 * 年度考核信息
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessTargetList(
			Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectTargetAssessList", paramMap);
	}
	
	 /**
	 * 继教考核详细
	 * @author cl
	 * @create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> selectTeacherAssessInfo(
			Map<String, Object> paramMap) throws Exception {
//		return  this.getSqlMapClientTemplate().queryForList("selectTeacherAssessInfo", paramMap);
		return  this.getSqlMapClientTemplate().queryForList("new_selectTeacherAssessInfo", paramMap);
		
	}
	
	public List<EduTearcherAssess> selectTeacherAssessNoTrainInfo(
			Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("new_selectTeacherAssessInfoNoTrain", paramMap);
		
	}
	
	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> selectTeacherProByStatusTrain(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherProByStatusTrain", paramMap);
	}
	
	
	
	

	
	/**
	 * 教师项目证书打印--查询已审核的项目--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> selectTeacherProByStatusNoTrain(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherProByStatusNoTrain", paramMap);
	}

	/**
	 * 查询电子印章列表
	 * @param param
	 * @return
	 */
	public List<EduSignet> selectSignetList(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("select_signet", param);
	}
	
	
	/**
	 * 查询电子印章列表
	 * @param param
	 * @return
	 */
	public List<EduSignet> selectSignetListByDictAndRole(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("select_signet_new", param);
	}

	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> selectSSProByStatusTrain(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectSSProByStatusTrain", paramMap);
	}
	
	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目 的数量
	 * @author 曉
	 * @param paramMap
	 * @return Integer
	 * @throws Exception
	 */
	@Override
	public Integer selectSSProByStatusTrainCount(Map<String, Object> paramMap) throws Exception{
		Object obj = this.getSqlMapClientTemplate().queryForObject("selectSSProByStatusTrainCount", paramMap);
		if(obj == null){
			return 0;
		} else {
			return Integer.parseInt(obj.toString());
		}
	}
	
	
	/**
	 * 实施/管理项目证书打印--查询已审核的项目--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> selectSSProByStatusNoTrain(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectSSProByStatusNoTrain", paramMap);
	}


	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师总数--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public int selectTeacherByProIdCount_Train(Map<String, Object> paramMap) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("selectTeacherByProIdCount_Train", paramMap);
		if(obj == null){
			return 0;
		} else {
			return Integer.parseInt(obj.toString());
		}
	}

	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public int selectTeacherCount_Train(Map<String, Object> paramMap) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("selectTeacherCount_Train", paramMap);
		if(obj == null){
			return 0;
		} else {
			return Integer.parseInt(obj.toString());
		}
	}
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下的教师--(培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherInfoActivity> selectTeacherByProId_Train(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherByProId_Train", paramMap);
	}
	@Override
	public List<TeacherInfoActivity> selectTeacher_Train(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacher_Train", paramMap);
	}

	
	/**
	 * 实施/管理项目证书打印--查询已审核的项目下的教师总数--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public int selectTeacherByProIdCount_NoTrain(Map<String, Object> paramMap) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("selectTeacherByProIdCount_NoTrain", paramMap);
		if(obj == null){
			return 0;
		} else {
			return Integer.parseInt(obj.toString());
		}
	}
	
	
	/**
	 * 实施/管理项目证书打印--查询已审核的项目下的教师--(非培训类)
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherInfoActivity> selectTeacherByProId_NOTrain(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherByProId_NOTrain", paramMap);
	}

	public EduDiploma queryDeplomaByProjectInfo(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		return (EduDiploma) this.getSqlMapClientTemplate().queryForObject("select_certificate_projectInfo", param);
	}

	/**
	 * 教师证书导出
	 * @param param
	 * @return
	 */
	@Override
	public List<TeacherCertificateExportActivity> selectTeacherCertificateActivetyListByConditionNoPage(
			Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherCertificateActivetyListNoPage", param);
	}

	@Override
	public List<EduDiploma> selectYearDiploma(Map<String, Object> condition) {
		return this.getSqlMapClientTemplate().queryForList("select_year_diploma", condition);
	}
	 
}