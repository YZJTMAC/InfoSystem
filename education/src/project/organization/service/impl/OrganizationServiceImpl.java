package project.organization.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.multipart.MultipartFile;

import project.common.Common;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.dao.IOrganizationReadDAOIF;
import project.organization.dao.IOrganizationWriteDAOIF;
import project.organization.dto.OrgProjectListDTO;
import project.organization.dto.OrganizationDto;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.OrgProTeacherScoreActivity;
import project.organization.pojo.OrgProjectInfoActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.OrganizationProjectActivity;
import project.organization.pojo.ProjectClassActivity;
import project.organization.pojo.ProjectCommonActivity;
import project.organization.service.IOrganizationServiceIF;
import project.system.dao.ISysReadDAO;
import project.system.pojo.SysArea;
import project.teacher.teacherProject.dao.ITeacherProjectReadDaoIF;
import project.teacher.teacherProject.pojo.EduUserPojo;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.util.DataUtil;
import framelib.service.AbsService;
import framelib.utils.FileUtils;
import framelib.utils.StringUtil;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

/**
 * Title: OrganizationServiceImpl
 * Description: 机构service接口实现
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public class OrganizationServiceImpl extends AbsService implements IOrganizationServiceIF {

	private static final Logger log = Logger.getLogger(OrganizationServiceImpl.class);
	
	
	@Autowired
	@Qualifier("organizationReadDAO")
	IOrganizationReadDAOIF orgReadDAO;
	
	@Autowired
	@Qualifier("organizationWriteDAO")
	IOrganizationWriteDAOIF orgWriteDAO;

	
	@Autowired
	@Qualifier("teacherProjectReadDao")
	ITeacherProjectReadDaoIF teacherProReadDao;
	
	
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO;
	
	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	public PageObject selectOrgProjectList(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception{
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		int count = orgReadDAO.selectOrgProjectCount(paramMap);
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<OrganizationProjectActivity> list = orgReadDAO.selectOrgProjectList(paramMap);
		if(list!= null && list.size()!= 0){
			List<OrgProjectListDTO> dtos = new ArrayList<OrgProjectListDTO>();
			for (OrganizationProjectActivity opa : list) {
				OrgProjectListDTO dto = new OrgProjectListDTO();
				BeanUtils.copyProperties(opa, dto);
				dtos.add(dto);
			}
			po.setObjects(dtos);
		} else {
			po.setCount(0);
		}
		return po;
	}

	/**
	 * 查询机构承培平台设置项目列表
	 */
	public PageObject selectSsOrgProjectList(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception{
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		int count = orgReadDAO.selectSsOrgProjectCount(paramMap);
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<OrganizationProjectActivity> list = orgReadDAO.selectSsOrgProjectList(paramMap);
		if(list!= null && list.size()!= 0){
			List<OrgProjectListDTO> dtos = new ArrayList<OrgProjectListDTO>();
			for (OrganizationProjectActivity opa : list) {
				OrgProjectListDTO dto = new OrgProjectListDTO();
				BeanUtils.copyProperties(opa, dto);
				dtos.add(dto);
			}
			po.setObjects(dtos);
		} else {
			po.setCount(0);
		}
		return po;
	}

	public OrgProjectInfoActivity selectOrgProjectInfoByProjectId(Integer projectId, Integer orgId) throws Exception {
		OrgProjectInfoActivity activity = new OrgProjectInfoActivity();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("projectId", projectId);
		map.put("orgId", orgId);
		activity = orgReadDAO.selectOrgProjectInfoByProjectId(map);
		//List<String> orgList = orgReadDAO.selectOrgNameByProjectId(projectId);
		//OrganizationProject project = orgReadDAO.selectOrgProject(map);
		//activity.setUpdateDate(project.getUpdateDate());
		//activity.setTrainingAddress(project.getTrainingAddress());
		//BeanUtils.copyProperties(activity, dto);
		//activity.setOrgList(orgList);
		return activity;
	}


	public boolean modifyOrgProject(Map<String, Object> paramMap) throws Exception {
		// 加锁
		//OrganizationProject oldProject = orgWriteDAO.selectOrgProjectForLock(paramMap);
		//String updateDate = paramMap.get("updateDate").toString();
		//if(updateDate.equals(oldProject.getUpdateDate())){
			return orgWriteDAO.updateOrgProject(paramMap);
		//	return true;
		//} else {
		//	return false;
		//}
	}


	//  机构:项目状态设置
	public String modifyOrgProjectStatus(Map<String, Object> paramMap) throws Exception {
		OrganizationProject oldProject = orgWriteDAO.selectOrgProjectForLock(paramMap);
		Integer oldStatus = Integer.parseInt(paramMap.get("oldStatus").toString());
		if(oldStatus.equals(oldProject.getProjectStatus())){
			//废弃准备就绪状态31
//			Integer status = Integer.parseInt(paramMap.get("status").toString());
			
			// 如果项目要变更为准备就绪, 则先去检查是否已设置培训地址
//			if(status.intValue() == 31){
//				/*if(!orgWriteDAO.selectOrgProUrl(paramMap)){
//					log.info("更改为进行中时在此之前未设置培训url");
//					return "noURL";
//				}*/
				OrgProjectListDTO dto = orgWriteDAO.selectOrgProUrl(paramMap);
				if(dto == null){
					return "noURL";
				}else if(StringUtil.isEmpty(dto.getTrainingAddress()) || StringUtil.isEmpty(dto.getTrainingHomeAddress()) ||
						dto.getTrainingAddress().equals("http://") || dto.getTrainingHomeAddress().endsWith("http://")){
					return "noURL";
				}
//			}
			
			// 更新项目状态
			Integer rtn = orgWriteDAO.updateOrgProjetStatus(paramMap);
			if( rtn == null || rtn.intValue() == 0){
				return "false";
			} else {
				return "true";
			}
		} else {
			return "false";
		}
	}


	public PageObject selectOrgProjectTeachers(Map<String, Object> paramMap, int startPage, int pageSize) throws Exception {
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		int count = orgReadDAO.selectOrgProjectTeachersCount(paramMap);
		po.setCount(count);
		
		// 查询此项目的参培人数
		/*int actualNum = orgWriteDAO.selectOrgProTeacherCount(paramMap);
		if(actualNum != 0){
			paramMap.put("actualNum", actualNum);
			// 更新
			if(!orgWriteDAO.updateOrgProActualNum(paramMap)){
				log.error("edu_organization_project 参培人数更新失败!");
				throw new Exception("参培人数更新失败！");
			}
		} else {
			log.error("项目结束时查询参培人数为0!");
		}*/
		
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		paramMap.put("page", "page");// 分页
		List<OrgProTeacherActivity> list = orgReadDAO.selectOrgProjectTeachers(paramMap);
		int rtn = Integer.parseInt(paramMap.get("rtn").toString());
		if(rtn == 1){
			po.setObjects(list);
		} else {
			for(OrgProTeacherActivity activity : list){
				if(!StringUtil.isEmpty(activity.getIdNumber())){
					activity.setIdNumber(DataUtil.replaceStr(activity.getIdNumber()));
				}
				if(!StringUtil.isEmpty(activity.getMobile())){
					activity.setMobile(DataUtil.replaceStr(activity.getMobile()));
				}
			}
			po.setObjects(list);
		}
		
		return po;
	}

	
	// 机构: 导出 某一项目所有的参训教师
	public String exportExcel(Map<String, Object> paramMap) throws Exception {
		List<OrgProTeacherActivity> list = orgReadDAO.selectOrgProjectTeachers(paramMap);
		for(int i=1; i<list.size(); i++){
			
		}
		
		return "";
	}
	

	public PageObject selectOrgProTeacherScore(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception {
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		/*int count = orgReadDAO.selectOrgProTeacherScoreCount(paramMap);
		po.setCount(count);*/
		
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<OrgProTeacherScoreActivity> list = orgReadDAO.selectOrgProTeacherScore(paramMap);
		po.setObjects(list);
		po.setCount(list.size());
		return po;
	}

	/**
	 * 通过地区查询机构
	 */
	@Override
	public List selectOrgByArea(Map<String, Object> params) throws Exception {
		// 包装分页类
		List<Organization> orgs = orgReadDAO.selectOrgByArea(params);
		return orgs;
	}
	/**
	 * 获取项目名称列表
	 */
	@Override
	public List projectNameList(Map<String, Object> params) throws Exception {
		// 包装分页类
		List<Organization> orgs = orgReadDAO.projectNameList(params);
		return orgs;
	}

	@Override
	public Map<String, Object> importTeacherScore(MultipartFile file, String account) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> result = parseExcel(file, orgId, projectId);
		//List<ProjectCommonActivity> list = (List<ProjectCommonActivity>) result.get("toDB");
		//List<XSSFRow> rows = (List<XSSFRow>)result.get("toExl");
		//if(list.size()>0){
		//	for(ProjectCommonActivity pojo : list){
				//int teacherId = teacherProReadDao.selectTeacherIdByIdNumber(pojo.getTeacherIdNumber());
				//pojo.setTeacherId(teacherId);
				//pojo.setProjectId(projectId);
				//pojo.setOrganizationId(orgId);
		//		pojo.setUpdateBy(account);
		//		pojo.setUpdateDate(new Date());
		//	}
		//	if(orgWriteDAO.updateTeacherScore(list) == 0){
		//		log.error("edu_project_common 教师成绩更新失败!");
		//		throw new Exception("教师成绩更新失败！");
		//	}
		//} 
		//map.put("toExl", rows.size());
		//map.put("toDB", list.size());
		return map;
	}


	/**
	 * 解析EXCEL
	 * @param file
	 * @param loginAccount
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> parseExcel(InputStream is, Map<String, Object> paramMap, String fileType) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		//正确的数据
		List<ProjectCommonActivity> pojos = new ArrayList<ProjectCommonActivity>();
		List<Row> dbRows = new ArrayList<Row>();
		
		//String roleId = paramMap.get("roleId").toString();
		List<EduUserPojo> list = new ArrayList<EduUserPojo>();
		//if(roleId.equals("")){// 实施机构
			
	//	} else {// 承培机构
			 list = orgReadDAO.selectTeacherInfoByOrgIdProId(paramMap);
		//}
			// 根据projectId 查询出此项目的学时/学分
			EduProjectDTO dto = eduProjectReadDAO.selectProFullInfoById(Integer.parseInt(paramMap.get("projectId").toString()));
		//数据不合格的row
		List<Row> rows = new ArrayList<Row>();
		Workbook wb = null;
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
			
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		
		for(int i = 1;i<=sheet.getLastRowNum();i++){
			ProjectCommonActivity pojo = new ProjectCommonActivity();
			
			Row row = sheet.getRow(i);
			if(row != null){
				Cell cell = row.getCell(6);
				if(cell==null){
					cell = row.createCell(6);
				}
				// 姓名
				String teacherName = DataUtil.getCellValue(row.getCell(0));
				if(teacherName.length()<1){
					//if(!DataUtil.validateName(teacherName)){
					//	cell.setCellValue("教师姓名为空!");
					//	rows.add(row);
					//	continue;
					//}
				//} else {
					cell.setCellValue("教师姓名为必填项!");
					rows.add(row);
					continue;
				}
				
				// 身份证号
				String idNumber = DataUtil.getCellValue(row.getCell(1));
				if(idNumber.length()>0){
					if(!DataUtil.validateIDCard(idNumber)){
						cell.setCellValue("身份证号填写不规范!");
						rows.add(row);
						continue;
					}
				} else {
					cell.setCellValue("身份证号为必填项!");
					rows.add(row);
					continue;
				}
				
				// 验证姓名和身份证号是否对应
				boolean validate = false;
				for(EduUserPojo user : list){
					if(user.getIdNumber().equalsIgnoreCase(idNumber) && user.getRealName().equals(teacherName)){
						pojo.setTeacherId(user.getId());
						pojo.setTeacherIdNumber(idNumber);
						validate = true;
						break;
					}
				}
				
				if(!validate){
					log.error("身份证号: "+idNumber+"在机构Id: "+paramMap.get("orgId")+"的项目Id: "+paramMap.get("projectId")+"中不存在, 或者姓名: "+teacherName+"与身份证号不一致");
					cell.setCellValue("教师姓名和身份证号不对应或者该教师不在此项目中!");
					rows.add(row);
					continue;
				}
				
				/*// 姓名
				String teacherName = DataUtil.getCellValue(row.getCell(0));
				if(teacherName.length()>0){
					if(!DataUtil.validateName(teacherName)){
						rows.add(row);
						continue;
					}
				} else {
					rows.add(row);
					continue;
				}
				
				// 身份证号
				String idNumber = DataUtil.getCellValue(row.getCell(1));
				if(idNumber.length()>0){
					if(DataUtil.validateIDCard(idNumber)){
						try {
							paramMap.put("idNumber", idNumber);
							int teacherId = orgReadDAO.selectTeacherIdByIdNumberOrgIdProId(paramMap);
							// 判断此身份证号是否存在
							if(teacherId != 0){
								pojo.setTeacherId(teacherId);
							} else {
								rows.add(row);
								continue;
							}
						} catch (Exception e) {
							log.info("身份证号: "+idNumber+"在机构Id: "+paramMap.get("orgId")+"的项目Id: "+paramMap.get("projectId")+"中不存在");
							e.printStackTrace();
							rows.add(row);
							continue;
						}
						pojo.setTeacherIdNumber(idNumber);
					}else{
						rows.add(row);
						continue;
					}
				}else{
					rows.add(row);
					continue;
				}*/
				
				//培训成绩状态（合格或不合格）
				String status = DataUtil.getCellValue(row.getCell(2));
				//培训成绩
				String score = DataUtil.getCellValue(row.getCell(3));
				//培训学时
				String period = DataUtil.getCellValue(row.getCell(4));
				//成绩 是否合格 都是必填项-- 改为 培训状态为必填项，成绩和学时为非必填项  || score.length()<1 || period.length()<0
				if(status.length()<1){
					cell.setCellValue("'是否合格'都是必填项!");
					rows.add(row);
					continue;
				} else if(status.length() > 0 && score.length()>0 && DataUtil.validateScore(score)){
					if(DataUtil.validateStatus(status) == 1){
						//判断成绩分数区间是否与合格状态对应  0-59为不合格，60-100为合格【先暂定为百分制】
						if(!"".equals(score) && Integer.valueOf(score)<=Common.SCORE_TOP && Integer.valueOf(score)>=Common.SCORE_PASS ){
							pojo.setTeacherTrainStatusId(1);
							pojo.setTeacherTrainStatusName(status);
							pojo.setTeacherScore(Float.valueOf(score));
						}else{
							cell.setCellValue("成绩分数和合格状态不匹配！");
							rows.add(row);
						}
					}else if(DataUtil.validateStatus(status) == 0){
						if(!"".equals(score) && Integer.valueOf(score)<Common.SCORE_PASS && Integer.valueOf(score)>=Common.SCORE_ZERO ){
							pojo.setTeacherTrainStatusId(0);
							pojo.setTeacherTrainStatusName(status);
							pojo.setTeacherScore(Float.valueOf(score));
						}else{
							cell.setCellValue("成绩分数和不合格状态不匹配！");
							rows.add(row);
						}
					}else {
						cell.setCellValue("合格状态验证不通过, 请按照规范填写!");
						rows.add(row);
						continue;
					}
				} else {
					//如果成绩不输入 设置为默认值 如果合格，成绩设置为80分，如果不合格成绩设置为0分
					if(status.equals(Common.SCORE_STATUS_PASS) && "".equals(score)){
						pojo.setTeacherScore(Float.valueOf(80));
						pojo.setTeacherTrainStatusId(1);
						pojo.setTeacherTrainStatusName(status);
					}else if(status.equals(Common.SCORE_STATUS_NO_PASS) && "".equals(score)){
						pojo.setTeacherScore(Float.valueOf(0));
						pojo.setTeacherTrainStatusId(0);
						pojo.setTeacherTrainStatusName(status);
					}else{
						cell.setCellValue("成绩格式规范验证不通过, 请按照规范填写!");
						rows.add(row);
						continue;
					}
				}
				if(period.length() > 0){
					if(DataUtil.validateNum2(period)){
						pojo.setTeacherClassPeriod(Integer.parseInt(period));
					} else {
						cell.setCellValue("学时验证失败, 请按照规范填写!");
						rows.add(row);
						continue;
					}
				}
				
				pojos.add(pojo);
				dbRows.add(row);
			} else {
				break;
			}
		}
		//存数据库的数据
		result.put("toDB", pojos);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}



	@Override
	public boolean saveOP(OrganizationProject op) throws Exception {
		return orgWriteDAO.insertOrgProject(op);
	}


	@Override
	public PageObject selectOPByProjectId(Map<String, Object> params, int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = orgReadDAO.countOPByProjectId(params);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		params.put("startIndex", po.getStartIndex());
		params.put("endIndex", pageSize);
		List<OrganizationProject> pos = orgReadDAO.selectOPByProjectId(params);
		po.setObjects(pos);
		return po;
	}


	@Override
	public boolean setOP(Map<String, Object> params) throws Exception {
		int i = orgWriteDAO.updateOP(params);
		if(i>0){
			return true;
		}
		return false;
	}


	@Override
	public int selectOrgIdByUserId(int userId) throws Exception {
		return orgReadDAO.selectOrgIdByUserId(userId);
	}


	@Override
	public PageObject selectOrgProClassList(int startIndex, int pageSize, Map<String, Object> paramMap) throws Exception {

		PageObject po = new PageObject();
		List<ProjectClassActivity> dtos = new ArrayList<ProjectClassActivity>();
		int count = orgReadDAO.selectOrgProjectCount(paramMap);
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		
		//项目列表
		List<OrganizationProjectActivity> list = orgReadDAO.selectOrgProjectList(paramMap);
		for(OrganizationProjectActivity activity : list){
		
			ProjectClassActivity dto = new ProjectClassActivity();
			dto.setProjectId(activity.getId());
			dto.setProjectName(activity.getProjectName());
			dto.setYear(activity.getYear());
			dto.setPlanNum(activity.getPlanNum());
			
			//项目对应的课程
			paramMap.put("projectId", activity.getId());
			List<ProjectClassActivity> proClasses = orgReadDAO.selectClassByCondition(paramMap);
			if(proClasses!= null && proClasses.size()>0){
				StringBuilder sb = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				for(ProjectClassActivity clazz:proClasses){
					String name = clazz.getClassSubjectName();
					if(name != null && name.length() >0){
						sb.append(name);
						sb.append(",");
					}
					String className = clazz.getClassName();
					if(className != null && className.length() >0){
						sb2.append(className);
						sb2.append(",");
					}
				}
				if(sb.length() > 0){
					dto.setClassSubjectName(sb.toString().substring(0,sb.length()-1));
				}
				if(sb2.length()>0){
					dto.setClassName(sb2.toString().substring(0,sb2.length()-1));
				}
			}
			dtos.add(dto);
		}
		po.setObjects(dtos);
		return po;
	}


	@Override
	public PageObject selectOrgProClass(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception {
		// 查询当前机构的当前项目的可以设置的培训学科
		//OrganizationProject organizationProject = orgReadDAO.selectOrgProClassScope(paramMap);
		// 查询当前机构下某一项目的课程
		PageObject po = new PageObject();
		int count = orgReadDAO.selectOrgProClassCount(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<ProjectClassActivity> classes = orgReadDAO.selectClassByCondition(paramMap);
		/*if(classes!= null && classes.size()>0){
			for(ProjectClassActivity activity : classes){
				activity.setOrganizationProject(organizationProject);
			}
		}*/
		po.setObjects(classes);
		return po;
	}


	/**
	 * 保存文件
	 */
	@Override
	public Map<String, Object> saveFile(HttpServletRequest request,String path, MultipartFile file, String savePath) throws Exception {
		String fullPath = "";
		String filePath = "";
		Map<String, Object> result = new HashMap<String, Object>();
		String projectPath = request.getSession().getServletContext().getRealPath("/");

		if(savePath.equals("")){
			filePath = path+(new Date().getTime())+File.separator;;
		} else {
			filePath = savePath;
		}
		String name = FileUtils.write(file, projectPath + filePath);
//		String name = FileUtils.write(file, filePath);
		fullPath = filePath+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
		result.put("filePath", fullPath);
		result.put("savePath", filePath);
		return result;
	}


	/**
	 * 删除上传文件
	 */
	@Override
	public boolean delUploadFile(String filePath) throws Exception {
		File file = new File(filePath);
		boolean rtn = false;
		if(file.exists()){
		    rtn = file.delete();
		}
		return rtn;
	}
/**
 * @author yinxiaolong
 * 解析EXCEL
 */
	@Override
	public Map<String, Object> parseExcel(InputStream is, String fileType, Map<String,Object> params)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		//正确的数据
		List<OrganizationDto> dtos = new ArrayList<OrganizationDto>();
		List<Row> dbRows = new ArrayList<Row>();
		//数据库所有机构
		List<Organization> orgList = orgReadDAO.selectAllOrganizations();
		//数据库当前登录人所控制的范围
		//List<SysArea> areaLiat = sysReadDAO
		//数据不合格的row
		List<Row> rows = new ArrayList<Row>();
		// 
		
		Workbook wb = null;
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		for(int i = 1;i<sheet.getLastRowNum();i++){
			OrganizationDto dto = new OrganizationDto();
			Row row = sheet.getRow(i);
			if(row != null){
				String orgName = DataUtil.getCellValue(row.getCell(0));
				String contacts = DataUtil.getCellValue(row.getCell(1));
				String contactsType  = DataUtil.getCellValue(row.getCell(2));
				String organizationAdderss = DataUtil.getCellValue(row.getCell(3));
				String memo = DataUtil.getCellValue(row.getCell(4));
				if(orgName.trim().length()>0){
					if(!validateOrg(orgList, orgName)){
						dto.setOrganizationName(orgName);
						dto.setContacts(contacts);
						dto.setContactsType(contactsType);
						dto.setOrganizationAdderss(organizationAdderss);
						dto.setMemo(memo);
						dto.setType((String)params.get("type"));
						dto.setOrganizationProvinceId((String)params.get("provinceId"));
						dto.setOrganizationProvinceName((String)params.get("provinceName"));
						dto.setOrganizationCityId((String)params.get("cityId"));
						dto.setOrganizationCityName((String)params.get("cityName"));
						dto.setOrganizationDistrictId((String)params.get("districtId"));
						dto.setOrganizationDistrictName((String)params.get("districtName"));
						dtos.add(dto);
						dbRows.add(row);
					}else{
						rows.add(row);
						continue;
					}
				}
			}else{
				break;
			}
		}
		//存数据库的数据
		result.put("toDB", dtos);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}
	
	public static boolean validateOrg(List<Organization> orgList,String orgName) {
		if(orgName != null &&orgName.length()>0){
			for(Organization org:orgList){
				if(org.getOrganizationName().equals(orgName)){
					return true;
				}
			}
		}
		return false;
	}


	// 机构:导出某一项目某些条件下的参训教师
	@Override
	public List<TeacherExportActivity> queryTeacherActivetyListNoPage(Map<String, Object> paramMap) throws Exception {
		List<TeacherExportActivity> list = orgReadDAO.queryTeacherActivetyListByConditionNoPage(paramMap);
		
		// 根据edu_project_commom表version查询教师报名时的任教学科/学段
		for(TeacherExportActivity activity : list){
			paramMap.put("teacherId", activity.getId());
			TeacherExportActivity dto = orgReadDAO.queryTeacherByCondition(paramMap);
			activity.setTeachingSection(dto.getTeachingSection());
			activity.setTeachingSubject(dto.getTeachingSubject());
		}
		return list;
	}


	@Override
	public Organization selectOrgProByUserId(int userId) {
		try {
			return orgReadDAO.selectOrgProByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<OrganizationProject> queryOrgByProId(int projectId) throws Exception {
		
		return orgReadDAO.queryOrgByProId(projectId);
	}


	/**
	 *解析实施机构excel 
	 */
	@Override
	public Map<String, Object> parseSSOrgExcel(InputStream is, String fileType, Map<String, Object> paramMap) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		//正确的数据
		List<OrganizationDto> dtos = new ArrayList<OrganizationDto>();
		List<Row> dbRows = new ArrayList<Row>();
		//数据库所有机构
		List<Organization> orgList = orgReadDAO.selectAllOrganizations();
		// excel中单位编码集合
		List<String> excelList = new ArrayList<String>(); 
		//数据库当前登录人所控制的范围
		List<SysArea> areaList = sysReadDAO.selectAreasByUserCode(paramMap);
		//数据不合格的row
		List<Row> rows = new ArrayList<Row>();
		
		Workbook wb = null;
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			OrganizationDto dto = new OrganizationDto();
			Row row = sheet.getRow(i);
			Cell cell = row.createCell(9);
			if(row != null){
				String provinceName = DataUtil.getCellValue(row.getCell(0));
				String cityName = DataUtil.getCellValue(row.getCell(1));
				String districtName = DataUtil.getCellValue(row.getCell(2));
				
				if(provinceName.length()==0){
					cell.setCellValue("请填写一级地区, 此为必填项!");
					rows.add(row);
					continue;
				} else if(provinceName.length()>0 && cityName.length()==0 && districtName.length()==0) {//省实施机构
					String province_name = paramMap.get("provinceName").toString();
					if(provinceName.equals(province_name)){
						dto.setOrganizationProvinceId(paramMap.get("provinceId").toString());
						dto.setOrganizationProvinceName(provinceName);
					} else {
						cell.setCellValue("所填写一级地区不在您的范围内, 或在系统中不存在!");
						rows.add(row);
						continue;
					}
				} else if(provinceName.length()>0 && cityName.length()>0 && districtName.length()==0){//市实施机构
					String province_name = paramMap.get("provinceName").toString();
					if(provinceName.equals(province_name)){
						dto.setOrganizationProvinceId(paramMap.get("provinceId").toString());
						dto.setOrganizationProvinceName(provinceName);
					} else {
						cell.setCellValue("所填写一级地区不在您的范围内, 或在系统中不存在!");
						rows.add(row);
						continue;
					}
					
					boolean valCity = false;
					for(SysArea area : areaList){
						if(area.getName().equals(cityName)){
							dto.setOrganizationCityId(area.getCode());
							dto.setOrganizationCityName(cityName);
							valCity = true;
							break;
						}
					}
					
					if(!valCity){
						cell.setCellValue("所填写二级地区不在您的范围内, 或在系统中不存在!");
						rows.add(row);
						continue;
					}
				} else if(provinceName.length()>0 && cityName.length()>0 && districtName.length()>0){//区实施机构
					String province_name = paramMap.get("provinceName").toString();
					if(provinceName.equals(province_name)){
						dto.setOrganizationProvinceId(paramMap.get("provinceId").toString());
						dto.setOrganizationProvinceName(provinceName);
					} else {
						cell.setCellValue("所填写一级地区不在您的范围内, 或在系统中不存在!");
						rows.add(row);
						continue;
					}
					
					boolean valCity = false;
					for(SysArea area : areaList){
						if(area.getName().equals(cityName)){
							dto.setOrganizationCityId(area.getCode());
							dto.setOrganizationCityName(cityName);
							valCity = true;
							break;
						}
					}
					
					boolean valDistrict = false;
					for(SysArea area : areaList){
						if(area.getName().equals(districtName)){
							dto.setOrganizationDistrictId(area.getCode());
							dto.setOrganizationDistrictName(districtName);
							valDistrict = true;
							break;
						}
					}
					
					if(!valCity || !valDistrict){
						cell.setCellValue("所填写三级地区不在您的范围内, 或在系统中不存在!");
						rows.add(row);
						continue;
					}
				} else {
					cell.setCellValue("不符合规范:'只填写一级地区,则是一级地区(省级)的实施机构; 只填写一级地区和二级地区,则是二级地区(市级)的实施机构; 一级地区,二级地区,三级地区都填写,则是三级地区(区县级)的实施机构'");
					rows.add(row);
					continue;
				}
				
				String orgCode = DataUtil.getCellValue(row.getCell(3));//单位编码
				if(orgCode.length()>=2 && orgCode.length()<=16){
					if(DataUtil.validateOrgCode(orgCode)){
						boolean valOrgCode = true;
						for(Organization org : orgList){
							if(org.getOrgCode()!=null && org.getOrgCode().equals(orgCode)){
								valOrgCode = false;
								break;
							}
						}
						if(valOrgCode){
							if(excelList!=null && excelList.size()>0){
								for(String str : excelList){
									if(str.equals(orgCode)){
										valOrgCode = false;
										break;
									}
								}
								if(valOrgCode){
									dto.setOrgCode(orgCode);
								} else {
									cell.setCellValue("所填写单位编码在Excel文档中已存在, 重复填写!");
									rows.add(row);
									continue;
								}
							} else {
								dto.setOrgCode(orgCode);
							}
						} else {
							cell.setCellValue("所填写单位编码在系统中已存在!");
							rows.add(row);
							continue;
						}
						excelList.add(orgCode);
					} else {
						cell.setCellValue("请填写字母和数字组合的单位编码!");
						rows.add(row);
						continue;
					}
				} else {
					cell.setCellValue("单位编码长度必须是2~16位!");
					rows.add(row);
					continue;
				}
				
				String orgName = DataUtil.getCellValue(row.getCell(4));//单位名称
				if(orgName.length()>0){
					dto.setOrganizationName(orgName);
				} else {
					cell.setCellValue("单位名称为必填项!");
					rows.add(row);
					continue;
				}
				
				String contacts = DataUtil.getCellValue(row.getCell(5));//联系人
				dto.setContacts(contacts);
				
				String contactsType = DataUtil.getCellValue(row.getCell(6));//联系方式
				dto.setContactsType(contactsType);
				
				String address = DataUtil.getCellValue(row.getCell(7));//联系地址
				dto.setTrainingAddress(address);
				
				String memo = DataUtil.getCellValue(row.getCell(8));//备注
				dto.setMemo(memo);
				
				dtos.add(dto);
				dbRows.add(row);
			}else{
				break;
			}
		}
		//存数据库的数据
		result.put("toDB", dtos);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}


	@Override
	public boolean saveTrainingMaterials(EduProjectTrainingMaterials eduProjectTrainingMaterials)
			throws Exception {
		boolean result  = orgWriteDAO.insertTrainingMaterials(eduProjectTrainingMaterials);
		return result;
	}


	@Override
	public List<EduProjectTrainingMaterials> queryTrainingMaterialsByPid(
			Integer pid) throws Exception {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("projectId", pid);
		return orgReadDAO.queryEduProjectTrainingMaterialsByCondition(params);
	}


	@Override
	public boolean delteTrainingMaterials(Map<String, Object> params)
			throws Exception {
		boolean result = orgWriteDAO.delteTrainingMaterials(params);
		return result;
	}
}
