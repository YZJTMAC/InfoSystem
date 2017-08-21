package project.organization.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.pojo.OrgProjectInfoActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import framelib.utils.page.PageObject;

/**
 * Title: IOrganizationServiceIF
 * Description: 机构service接口
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public interface IOrganizationServiceIF {

	// 机构: 承培项目列表
	public PageObject selectOrgProjectList(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception;

	// 机构: 承培项目详情
	public OrgProjectInfoActivity selectOrgProjectInfoByProjectId(Integer projectId, Integer orgId) throws Exception;

	// 机构: 设置承培项目培训平台地址
	public boolean modifyOrgProject(Map<String, Object> paramMap) throws Exception;

	// 机构: 项目状态设置
	public String modifyOrgProjectStatus(Map<String, Object> paramMap) throws Exception;

	// 机构: 某一项目参训教师列表(分页)
	public PageObject selectOrgProjectTeachers(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;

	// 机构: 导出 某一项目所有的参训教师
	public String exportExcel(Map<String, Object> paramMap) throws Exception;

	// 机构: 承培项目教师评价
	public PageObject selectOrgProTeacherScore(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception;
	
	List selectOrgByArea(Map<String, Object> paramMap) throws Exception;
	List projectNameList(Map<String, Object> paramMap) throws Exception;
	
	boolean saveOP(OrganizationProject op) throws Exception;
	
	PageObject selectOPByProjectId(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception;
	
	boolean setOP(Map<String, Object> params) throws Exception;

	public int selectOrgIdByUserId(int userId) throws Exception;
	
	public Organization selectOrgProByUserId(int userId);

	// 机构: 查询项目课程
	public PageObject selectOrgProClassList(int startIndex, int pageSize, Map<String, Object> paramMap) throws Exception;

	// 机构: 某一项目下的课程设置列表
	public PageObject selectOrgProClass(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception;

	// 上传文件保存
	public Map<String, Object> saveFile(HttpServletRequest request,String path, MultipartFile file, String account) throws Exception;

	// 删除上传的文件
	public boolean delUploadFile(String filePath) throws Exception;
	
	/**导入机构
	 * @author yinxiaolong
	 * @param is
	 * @param fileType
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> parseExcel(InputStream is,String fileType, Map<String,Object> params) throws Exception;
	
	// 解析excel
	public Map<String, Object> parseExcel(InputStream is, Map<String, Object> paramMap, String fileType) throws Exception;

	
	// 机构: 上传培训成绩
	public Map<String, Object> importTeacherScore(MultipartFile file, String savePath) throws Exception;

	// 机构:导出某一项目某些条件下的参训教师
	public List<TeacherExportActivity> queryTeacherActivetyListNoPage(Map<String, Object> paramMap) throws Exception;

	/**
	 * 根据projectId查询项目下所有的承培机构承培项目信息
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<OrganizationProject> queryOrgByProId(int projectId) throws Exception;

	/**
	 * 解析实施机构excel
	 * @param is
	 * @param fileType
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> parseSSOrgExcel(InputStream is, String fileType, Map<String, Object> paramMap) throws Exception;

	
	
	public boolean saveTrainingMaterials(EduProjectTrainingMaterials eduProjectTrainingMaterials) throws Exception;

	List<EduProjectTrainingMaterials> queryTrainingMaterialsByPid(Integer pid)throws Exception;
	
    boolean delteTrainingMaterials(Map<String,Object> params) throws Exception;

    public PageObject selectSsOrgProjectList(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception;
}
