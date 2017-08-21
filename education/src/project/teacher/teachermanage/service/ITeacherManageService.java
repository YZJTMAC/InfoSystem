package project.teacher.teachermanage.service;

import java.util.List;
import java.util.Map;

import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.person.pojo.EduUser;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduAudit;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.TeacherActivity;
import project.teacher.teachermanage.pojo.TeacherExportActivity;

import framelib.utils.page.PageObject;


/**
 * 物流订单处理service
 * @author dengguo
 *
 */
public interface ITeacherManageService {
	
	/**
	 * 第一次教师新增时，插入其他 空白信息
	 */
	public void saveOtherInfo(Integer userId, String teacherCreateBy) throws Exception ;
	
	/**
	 * 教师信息综合查询
	 * @param paramMap 
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject queryTeacherActivetyListPage(Map<String,Object> paramMap, int startPage, int pageSize) throws Exception;
	
	/**
	 * 保存教师 user信息
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer saveTeacherUserInfo(EduUser pojo) throws Exception;
	
	/**
	 * 保存教师 base信息
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer saveTeacherBaseInfo(EduTeacherBasicInfo pojo, Integer roleId) throws Exception ;
	
	/**
	 * 保存教师 job信息
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer saveTeacherJobInfo(EduTeacherJob pojo, List<String> sysInfo, Integer roleId, String optionName) throws Exception ;
	
	/**
	 * 保存教师 edu信息
	 * @param integer 
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer saveTeacherEducation(EduTeacherEduDTO dto, String optionName, Integer roleId) throws Exception ;

	/**
	 * 批量删除教师 edu信息
	 * @param data id 字符串 逗号分隔
	 * @return
	 * @throws Exception
	 */
	public Integer deleteTeacherBatch(String data, String optionBy) throws Exception ;
	
	public Integer deleteTeacher(String data) throws Exception ;
	
	public Integer modifyAuditTeacherBatch(String data, String optionBy,String optionRealName, boolean isPass, String memo) throws Exception ;
	
	/**
	 * 信息变更列表
	 * @author cl
	 * create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public  List<EduAudit>  queryTeacherChangeList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 查询教师变更记录
	 * @param paramMap
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryTeacherRetiressActivetyListPage(
			Map<String, Object> paramMap, int startPage, int pageSize)
			throws Exception;

	/**
	 * 教师离退操作
	 * @param teahcerId
	 * @param changeType 离退操作类型
	 * @return
	 * @throws Exception 
	 */
	public Integer modifyTeacherRetirees(String teahcerId, String changeType, String auditName, String auditAccunt, String mobilizeMark) throws Exception;
	
	
	PageObject queryTeacherChangeRecord(Map<String, Object> paramMap,int startIndex,int pageSize) throws Exception;
	
	boolean procAuditChangeRecord(Map<String,Object> params) throws Exception;
	
	boolean procBatchAuditChangeRecord(int status,String auditId,String memo,String auditor) throws Exception;
	/**
	 * 调动管理列表
	 * 
	 * @author cl 
	 * @create date 2014-4-15
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryMobilizeList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception;


	/**
	 * 调动管理 记录详情
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize queryMobilizeInfo(Map<String, Object> paramMap)
			throws Exception;
	
	 /**
	 * 调动管理   新建调动 记录列表
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> queryCreateMobilizeList(
			Map<String, Object> paramMap) throws Exception;

	/**
	 * 新增教育经历
	 * @param edu
	 * @return
	 * @throws Exception
	 */
	public Integer saveTeacherEducation(EduTeacherEducation edu) throws Exception;
	
	/**
	 * 调动管理  新建调动--需要审核
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createMobilizeForAudit(EduTeacherMobilize pojo)throws Exception;
	
	/**
	 * 调动管理  新建调动--不需要审核
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createMobilizeForNoAudit(EduTeacherMobilize pojo)throws Exception;

	/**
	 * 查询教师信息列表 无分页
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<TeacherExportActivity> queryTeacherActivetyListNoPage(Map<String, Object> paramMap)
			throws Exception;
	
	/**
	 * 调动审核审核通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyMobilizeInfo(EduTeacherMobilize pojo)throws Exception;
	
	/**
	 * 调动审核审核不通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyMobilizeInfoNo(EduTeacherMobilize pojo)throws Exception;
	
	/**
	 * 调动管理 审核相关信息
	 * 
	 * @author cl
	 * @create date 2014-4-20
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize queryMobilizeAuditInfo(Integer id)
			throws Exception;
	
	/**
	 * 编制调整管理列表
	 * 
	 * @author cl
	 * @create date 2014-4-26
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryAdjustList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 新建编制调整--不需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-27
	 * @return
	 * @throws Exception
	 */
	public Integer createAdjustForNoAudit(EduTeacherAdjust pojo)
			throws Exception;
	
	/**
	 * 新建编制调整--需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createAdjustForAudit(EduTeacherAdjust pojo)
			throws Exception;
	
	/**
	 * 新建编制调整审核--审核不通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyAdjustInfoNo(EduTeacherAdjust pojo)throws Exception;
	
	/**
	 * 新建编制调整审核--审核通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyAdjustInfo(EduTeacherAdjust pojo)throws Exception;
	
	/**
	 * 我的调动记录列表
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryTeacherMobilizeList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception;

	/**
	 * 离退审核
	 * @param auditId
	 * @param teahcerId
	 * @param changeType 审核类别
	 * @param auditStatus 审核状态
	 * @param auditOption 建议
	 * @param auditName 真实名字
	 * @param auditAccunt 审核账号
	 * @return
	 * @throws Exception
	 */
	public Integer modifyTeacherRetireesAudit(String auditId, String teahcerId,
			String changeType, String auditStatus, String auditOption,
			String auditName, String auditAccunt) throws Exception;


	
}
