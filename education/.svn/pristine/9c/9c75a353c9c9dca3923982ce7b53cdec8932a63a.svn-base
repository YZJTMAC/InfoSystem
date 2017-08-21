package project.teacher.teachermanage.dao.impl;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectComment;
import project.system.pojo.EduCreditLend;
import project.system.pojo.EduTeacherScoreInfo;
import project.teacher.teacherProject.pojo.EduIndependentStudy;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.pojo.EduAudit;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.teacher.teachermanage.pojo.TeacherInfoChangeRecord;

import framelib.dao.BaseDAOImpl;
import framelib.utils.page.PageObject;

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
public class TeacherReadDaoImpl extends BaseDAOImpl implements ITeacherReadDao { 
	
	@Override  
	public Integer selectTeacherActivetyCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherActivetyListCount", param);
	}
	
	@Override
	public List<Object> selectTeacherRetiressActivetyListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherRetiressActivetyList", param);
	}
	
	@Override  
	public Integer selectTeacherRetiressActivetyCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherRetiressActivetyListCount", param);
	}
	
	@Override
	public List<TeacherExportActivity> selectTeacherActivetyListByConditionNoPage(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherActivetyListNoPage", param);
	}
	
	@Override
	public List<Object> selectTeacherActivetyListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherActivetyList", param);
	}
	
	@Override
	public EduTeacherVersionPOJO selectTeacherAllVersion(Integer teacherId) {
		return (EduTeacherVersionPOJO)this.getSqlMapClientTemplate().queryForObject("teacher_all_version", teacherId);
	}

	/**
	 * 信息变更列表
	 * @author cl
	 * @create date 2014-4-9
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	
	public List<EduAudit> selectTeacherChangeList(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherChangeList", paramMap);
	}

	@Override
	public List<TeacherInfoChangeRecord> selectChangeRecord(
			Map<String, Object> params) throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_change_record",params);
	}

	@Override
	public int selectCountChangeRecord(Map<String, Object> params)
			throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("select_count_change_record",params);
	}
	
	@Override
	public project.teacher.teacherProject.pojo.EduAudit selectEduAuditById(int id) throws Exception {
		return (project.teacher.teacherProject.pojo.EduAudit) this.getSqlMapClientTemplate().queryForObject("select_audit_by_id",id);
	}

	@Override
	public List<EduTeacherEducation> selectAllInfoByVersionAndTeacherId(
			Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_all_info_ByTeacherIdAndVersion",params);
	}

	/**调动管理 记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectMobilizeCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectMobilizeCount", paramMap);
		return count;
	}

	 /**
	 * 调动管理   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectMobilizeList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectMobilizeList",
				paramMap);
	}

	 /**
	 * 调动管理   记录详情
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize selectMobilizeInfo(Map<String, Object> paramMap)
			throws Exception {
		return (EduTeacherMobilize)this.getSqlMapClientTemplate().queryForObject("selectMobilizeInfo", paramMap);
	}
	
	 /**
	 * 调动管理   新建调动 记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectCreateMobilizeList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectCreateMobilizeList",
				paramMap);
	}

	/**查询教师信息变动总数
	 * @author cl
	 * @create date 2014-4-17
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectAuditChangeType(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"select_count_change_type", paramMap);
		return count;
	}

	 /**
	 * 调动管理   审核相关信息
	 * @author cl
	 * @create date 2014-4-20
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize selectMobilizeAudit(Integer id) throws Exception {
		return (EduTeacherMobilize)this.getSqlMapClientTemplate().queryForObject("select_auditInfo_by_id", id);
	}
	
	/**编制调整管理 记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectAdjustCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectAdjustCount", paramMap);
		return count;
	}

	 /**
	 * 编制调整管理   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherAdjust> selectAdjustList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectAdjustList",
				paramMap);
	}
	
	/**我的调动记录  记录总数
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectTeacherMobilizeCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectTeacherMobilizeCount", paramMap);
		return count;
	}

	 /**
	 * 我的调动记录   记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> selectTeacherMobilizeList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherMobilizeList",
				paramMap);
	}

	@Override
	public PageObject queryTeacherIndeptStudyList(Map<String, Object> condition) {
		PageObject po = new PageObject();
		List<EduIndependentStudy> proList = this.getSqlMapClientTemplate().queryForList("query_teacher_indept_study_list",condition);
		po.setObjects(proList);
		return po;
	}

	@Override
	public Float queryTeacherIndeptStudyCredit(Map<String, Object> params) {
		return (Float) this.getSqlMapClientTemplate().queryForObject("query_teacher_indept_study_credit",params);
	}

	@Override
	public List<EduTeacherScoreInfo> getTeacherIsTrainRemainCredit(
			Map<String, Object> params, int i, int j) {
		// TODO Auto-generated method stub
//		List<EduTeacherScoreInfo> map=
		return this.getSqlMapClientTemplate().queryForList("select_teacher_is_remain_credit",params);
	}

	@Override
	public PageObject queryTeacherSpecialCaseList(Map<String, Object> conditions) {
		PageObject po = new PageObject();
		List<EduProjectComment> proList = this.getSqlMapClientTemplate().queryForList("query_teacher_special_case_list",conditions);
		po.setObjects(proList);
		return po;
	}
}