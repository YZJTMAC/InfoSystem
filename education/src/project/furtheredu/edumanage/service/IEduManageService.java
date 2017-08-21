package project.furtheredu.edumanage.service;

import java.util.List;
import java.util.Map;

import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.pojo.EduSignet;
import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.furtheredu.edumanage.pojo.TeacherCertificateExportActivity;
import project.furtheredu.edumanage.pojo.TeacherProActivity;
import framelib.utils.page.PageObject;


/**
 * 物流订单处理service
 * @author dengguo
 *
 */
public interface IEduManageService {
	
	public List<EduTearcherAssess> queryTeacherAssessNoTrainInfo(
			Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 教师信息综合查询
	 * @param paramMap 
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject queryManageListPage(Map<String,Object> paramMap, int startPage, int pageSize) throws Exception;

//	public Integer saveTagetInfo(EduTargetByYear target) throws Exception;

	/**
	 * 查询年度目标设置
	 * @param id
	 * @return
	 * @throws Exception
	 */
//	EduTargetByYear queryTargetInfoById(Integer id) throws Exception;
//
//	Integer updateTaget(EduTargetByYear target) throws Exception;
//
	Integer deleteManageById(String data) throws Exception;

	/**
	 * 审核继教信息
	 * @param data id字符串 多个已逗号分隔
	 * @param account 操作人
	 * @param isPass 是否通过
	 * @param memo
	 * @return
	 */
	public Integer modifyAuditEduManageBatch(String data, String account,
			boolean isPass, String memo);
	
	/**
	 * 逻辑删除继教信息
	 * @param data  id字符串 多个已逗号分隔
	 * @param account 操作人
	 * @param memo 
	 * @return
	 */
	public Integer modifyAuditEduManageBatch(String data, String account, String memo);

	/**
	 * 查询教师年度考核
	 * @param paramMap
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryManageGroupListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception;

	/**
	 * 项目评价
	 * @param paramMap
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryEvaluationListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception;

	/**
	 * 查询项目评分 报表
	 * @param projectId
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	List queryEvaluationInfo(Integer projectId, Integer orgId)
			throws Exception;

	@SuppressWarnings("unchecked")
	List queryTeacherCommentActivityByCondition(Integer teacherId)
			throws Exception;
	/**
	 * 继教考核查询
	 * @author cl
	 * create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public  List<EduTearcherAssess>  queryTeacherAssess(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 年度考核信息
	 * @author cl
	 * create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public  List<EduTearcherAssess>  queryTeacherAssessTarget(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 继教考核详细
	 * @author cl
	 * create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public  List<EduTearcherAssess>  queryTeacherAssessInfo(Map<String, Object> paramMap) throws Exception;

	/**
	 * 查询证书模版
	 * @author zxq
	 * create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduDiploma queryDeploma(Map<String, Object> paramMap) throws Exception;

	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<TeacherProActivity> queryTeacherProByStatus(Map<String, Object> paramMap) throws Exception;
	
	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<TeacherProActivity> queryProByStatus(Map<String, Object> paramMap) throws Exception;

	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	PageObject queryProByStatusPage(Map<String, Object> paramMap,int startIndex,int pageSize) throws Exception;
	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下教师
	 * @author 曉
	 * @param pageIndex
	 * @param type
	 * @param request
	 * @return
	 */
	public PageObject queryTeacherByProId( Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目下教师
	 * 根据学校和教师姓名、身份证查询
	 * @author 曉
	 * @param pageIndex
	 * @param type
	 * @param request
	 * @return
	 */
	public PageObject queryTeacherCertificate( Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 导出教师证书列表 无分页
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherCertificateExportActivity> queryTeacherCertificateActivityListNoPage(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addSignet(EduSignet pojo) throws Exception;
	
	
	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addSignetNew(EduSignet pojo) throws Exception;
	
	/**
	 * 修改电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer modifySignet(EduSignet pojo) throws Exception;
	
	/**
	 * 查询电子印章列表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduSignet> querySignetList(Map<String, Object> paramMap) throws Exception;
	
	
	/**
	 * 根据用户角色和层级查询电子印章列表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduSignet> querySignetListByDictAndRole(Map<String, Object> paramMap) throws Exception;

	List queryEvaluationInfo(Integer projectId) throws Exception;
	
	/**
	 * 根据项目id和teacherId查询证书信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public EduDiploma queryTeacherCertificateInfo(Map<String, Object> param) throws Exception;

	/**
	 * 新增年度证书
	 */
	public Integer insertYearCertificate(Map<String, Object> param) throws Exception;

	/**
	 * 查询年度证书
	 * @return
	 */
	public List<EduDiploma> selectYearDiploma(Map<String, Object> condition);

	/**
	 * 删除年度证书
	 * @param condition
	 * @return
	 */
	public boolean deleteCertificateById(Map<String, Object> condition);

	/**
	 * 修改年度证书
	 * @param condition
	 * @return
	 */
	public int updateYearCertificate(Map<String, Object> condition);

 }
