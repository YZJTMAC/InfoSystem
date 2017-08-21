package project.edupm.teachermanage.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;

import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduTeacherImportHistory;
import project.edupm.teachermanage.dao.IEduTeacherReadDAOIF;
import project.edupm.teachermanage.pojo.EduTeacherImportPOJO;
import project.edupm.teachermanage.pojo.TeacherProScorePOJO;
import project.organization.pojo.OrgProTeacherActivity;
import framelib.dao.BaseDAOImpl;

/**
 * Title: TeacherManageReadDAO
 * Description: 教师管理ReadDAO接口实现
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-04-01
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public class EduTeacherReadDAO extends BaseDAOImpl implements IEduTeacherReadDAOIF{

	@Override
	public int selectTeacherProScoreListCount(Map<String, Object> paramMap) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherProScoreListCount", paramMap);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherProScorePOJO> selectTeacherProScoreList(Map<String, Object> paramMap) throws Exception {
		List<TeacherProScorePOJO> list = this.getSqlMapClientTemplate().queryForList("selectTeacherProScoreList", paramMap);
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrgProTeacherActivity> selectTeacherProScoreInfo(Map<String, Object> paramMap) throws Exception {
		List<OrgProTeacherActivity> list = this.getSqlMapClientTemplate().queryForList("selectTeacherProScoreInfo", paramMap);
		return list;
	}


	@Override
	public int selectTeacherProScoreInfoCount(Map<String, Object> paramMap) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherProScoreInfoCount", paramMap);
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<EduProject> selectTeacherScoreList(Map<String, Object> paramMap) throws Exception {
		List<EduProject> list = this.getSqlMapClientTemplate().queryForList("selectTeacherScoreList", paramMap);
		return list;
	}


	@Override
	public int selectTeacherCount(Map<String, Object> paramMap) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherCount", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EduTeacherImportHistory> selectTeacherImportRecordNoPage(
			Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_import_record_no_page",params);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EduTeacherImportPOJO> selectTeacherImportReacords(
			Map<String, Object> params) throws Exception {
		if(params.get("date") != null) {
			//params.put("date", params.get("date").toString().substring(0, params.get("date").toString().lastIndexOf(":")));
		}
		return this.getSqlMapClientTemplate().queryForList("select_import_teacher_record",params);
	}


	@Override
	public int countTIR(Map<String, Object> params) throws Exception {
		if(params.get("date") != null) {
			params.put("date", params.get("date").toString().substring(0, params.get("date").toString().lastIndexOf(":")));
		}
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_import_teacher_record",params);
		if(obj != null){
			return (Integer)obj;
		}
		return 0;
	}


	@Override
	public EduTeacherImportHistory selectTIRByDate(Map<String, Object> param)
			throws Exception {
		return (EduTeacherImportHistory) this.getSqlMapClientTemplate().queryForObject("select_itr_by_create_date",param);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectDateByYear(String year) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_opt_date_by_year",year);
	}


	// 管理员: 查询教师成绩详情列表前判断教师是否已有成绩
	@Override
	public int selectCountTeacherScore(String projectId) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCountTeacherScore", projectId);
	}


	/**
	 * 查看导入成绩
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherProScorePOJO> selectInportSoreInfo(int projectId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectInportSoreInfo", projectId);
	}


	@Override
	public TeacherProScorePOJO selectCountApplyAndStudyNum(Map<String, Object> paramMap) throws Exception {
		return (TeacherProScorePOJO) this.getSqlMapClientTemplate().queryForObject("selectCountApplyAndStudyNum", paramMap);
	}


	@Override
	public TeacherProScorePOJO selectTeacherScores(Map<String, Object> paramMap) throws Exception {
		return (TeacherProScorePOJO) this.getSqlMapClientTemplate().queryForObject("selectTeacherScores", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectTeacherInfoByProjectId(int projectId)	throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("selectTeacherInfoByProjectId",projectId);
	}
}
