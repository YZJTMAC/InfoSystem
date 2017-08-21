package project.edupm.teachermanage.service;

import java.util.List;
import java.util.Map;

import project.edupm.teachermanage.dto.EduTeacherImportDTO;
import project.edupm.teachermanage.pojo.TeacherProScorePOJO;
import framelib.utils.page.PageObject;

/**
 * Title: ITeacherManageServiceIF
 * Description: 教师管理service接口
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-04-01
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public interface IEduTeacherServiceIF {

	// 管理员: 查询教师成绩列表
	public PageObject selectTeacherProScoreList(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;

	// 管理员: 查询教师成绩详情
	public PageObject selectTeacherProScoreInfo(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception;
	
	PageObject queryImportTeacherRecord(int startIndex,int pageSize,Map<String,Object> param) throws Exception;
	/**
	 * 查询登录人所有导入记录，并通过ID获取本次导入信息
	 * @param id historyId
	 * @param account 登录人account
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> queryHistoryAndRecordInfo(int id,String historyType, String account,int startIndex,int pageSize) throws Exception;
	
	public PageObject queryTIR(Map<String,Object> params,int startIndex,int pageSize) throws Exception;
	/**
	 * 根据日期和导入人查询导入记录
	 * @param startIndex
	 * @param pageSize
	 * @param date
	 * @param account
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> queryTIR(int startIndex, String historyType, int pageSize,String date,String account) throws Exception;
	
	List<EduTeacherImportDTO> queryDateByYear(String year) throws Exception;
	// 查询此项目下参训教师是否已有成绩
	public int queryCountTeacherScore(String projectId) throws Exception;

	/**
	 * 查看导入成绩
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<TeacherProScorePOJO> queryImportScoreInfo(int projectId) throws Exception;
	/**
	 * 根据项目projectId查询教师信息 
	 * 培训成绩导入的模板自动生成项目学员信息（从报名教师名单中转入），只填写培训成绩与学分再导入系统
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryTeacherByProId(int projectId) throws Exception;

}
