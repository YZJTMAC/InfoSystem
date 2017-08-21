package project.edupm.teachermanage.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduTeacherImportHistory;
import project.edupm.teachermanage.pojo.EduTeacherImportPOJO;
import project.edupm.teachermanage.pojo.TeacherProScorePOJO;
import project.organization.pojo.OrgProTeacherActivity;

/**
 * Title: ITeacherManageReadDAOIF
 * Description: 教师管理ReadDAO接口
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-04-01
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public interface IEduTeacherReadDAOIF {

	// 管理员: 查询教师成绩列表记录总数
	public int selectTeacherProScoreListCount(Map<String, Object> paramMap) throws Exception;

	// 管理员: 查询教师成绩列表(buyongle)
	public List<TeacherProScorePOJO> selectTeacherProScoreList(Map<String, Object> paramMap) throws Exception;

	// 管理员: 查询教师成绩详情总数
	public int selectTeacherProScoreInfoCount(Map<String, Object> paramMap) throws Exception ;

	// 管理员: 查询教师成绩详情
	public List<OrgProTeacherActivity> selectTeacherProScoreInfo(Map<String, Object> paramMap) throws Exception;

	// 管理员: 查询教师成绩列表
	public List<EduProject> selectTeacherScoreList(Map<String, Object> paramMap) throws Exception;

	// 统计某一项目下的教师参培人数
	public int selectTeacherCount(Map<String, Object> paramMap) throws Exception;

	// 管理员: 查询教师成绩详情列表前判断教师是否已有成绩
	public int selectCountTeacherScore(String projectId) throws Exception;
	
	/**
	 * 根据用户查询教师导入记录
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherImportHistory> selectTeacherImportRecordNoPage(Map<String, Object> params) throws Exception;
	
	/**
	 * 查询教师导入记录
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherImportPOJO> selectTeacherImportReacords(Map<String,Object> params) throws Exception;
	
	int countTIR(Map<String,Object> params) throws Exception;
	
	EduTeacherImportHistory selectTIRByDate(Map<String,Object> param) throws Exception;
	
	List<String> selectDateByYear(String year) throws Exception;

	/**
	 * 查看导入成绩
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<TeacherProScorePOJO> selectInportSoreInfo(int projectId) throws Exception;

	public TeacherProScorePOJO selectCountApplyAndStudyNum(Map<String, Object> paramMap) throws Exception;

	public TeacherProScorePOJO selectTeacherScores(Map<String, Object> paramMap) throws Exception;

	public List<Map<String, Object>> selectTeacherInfoByProjectId(int projectId) throws Exception;
	
}
