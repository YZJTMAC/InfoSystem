package project.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.multipart.MultipartFile;

import project.common.Common;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.edupm.projectmanage.pojo.EduQustionSummary;
import project.edupm.projectmanage.service.IEduProjectService;
import project.fileupload.pojo.FileType;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.master.service.IEduMasterService;
import project.message.pojo.NoticeTree;
import project.organization.dao.IOrganizationWriteDAOIF;
import project.organization.dto.OrganizationDto;
import project.organization.pojo.Organization;
import project.organization.pojo.ProjectCommonActivity;
import project.organization.service.IOrganizationServiceIF;
import project.person.dao.IUserReadDAO;
import project.person.pojo.EduUser;
import project.system.dao.ISysReadDAO;
import project.system.dao.ISysWriteDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.FjTeacherStudyInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportActivty;
import project.system.pojo.FjimportHistory;
import project.system.pojo.ProjectStatisticsActivty;
import project.system.pojo.RoleType;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.pojo.SysFunction;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysRoleFuncActivty;
import project.system.pojo.SysSetup;
import project.system.pojo.ZTree;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.teacher.teacherProject.dao.ITeacherProjectReadDaoIF;
import project.teacher.teacherProject.pojo.EduProjectActivityPojo;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.dto.TeacherDTO;
import project.teacher.teachermanage.service.ITeacherManageService;
import project.util.DataUtil;
import project.util.DateUtil;
import project.util.ExcelUtil;
import project.util.SendHttpRequest;
import framelib.utils.FileUtils;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

@SuppressWarnings("unchecked")
public class SysServiceImpl implements ISysService{
	
	private static final Logger log = Logger.getLogger(SysServiceImpl.class);
	
	@Autowired
	@Qualifier("teacherManageService")
	ITeacherManageService teacherManageService;
	
	@Autowired
	@Qualifier("sysWriteDAO")
	ISysWriteDAO sysWriteDAO;
	
	
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO; 
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("organizationService")
	IOrganizationServiceIF orgService;
	
	@Autowired
	@Qualifier("organizationWriteDAO")
	IOrganizationWriteDAOIF orgWriteDAO;

	
	@Autowired
	@Qualifier("teacherProjectReadDao")
	ITeacherProjectReadDaoIF teacherProReadDao;
	
	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("userReadDao")
	IUserReadDAO userReadDao;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	@Autowired
	@Qualifier("eduMasterService")
	IEduMasterService eduMasterService;
	
	/**
	 * 保存文件
	 */
	@Override
	public Map<String, Object> saveFile(String path, MultipartFile file, String savePath) throws Exception {
		String fullPath = "";
		String filePath = "";
		Map<String, Object> result = new HashMap<String, Object>();
		filePath = path+File.separator + FileType.PHOTO +File.separator;
		String name = FileUtils.write(file, filePath);
		fullPath = filePath+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
		result.put("filePath", FileType.PHOTO + "/" +name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length()));
		result.put("savePath", filePath);
		return result;
	}
	
	/**
	 * 通过字典类型查询字典表数据
	 * @param dicType 字典类型 如：project_class 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysDictionary> queryDicByDicType(String dicType)
			throws Exception {
		return sysReadDAO.selectDicByDicType(dicType);
	}
	
	@Override
	public EduDiploma queryDeplomaById(Integer id, String projectId, String type,String certificateView)
			throws Exception {
		EduDiploma diploma = sysReadDAO.selectDiplomaById(id, projectId, type);
		if (diploma == null) {
			return null;
		}
		if(certificateView != null && certificateView.equals("1")){
			String content = diploma.getContent();
			if(type.equals("1")){
				content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getProjectPrefix()+"000000");
				content = content.replace("{name}", "姓 名");
				content = content.replace("{title}", diploma.getTitle());
				content = content.replace("{startDate}", diploma.getStartDate());
				content = content.replace("{endDate}", diploma.getEndDate());
				content = content.replace("{period}", diploma.getNeedPeriod().toString());
				content = content.replace("{credit}", diploma.getNeedCredit().toString());
				content = content.replace("{creditLend}", "（如果有学分借贷，显示‘经学分借贷，视为合格’）");
				diploma.setContent(content);
				return diploma;
			}
			EduProject project = eduProjectReadDAO.selectBaseInfoById(new Integer(projectId));
			
			if (content != null && content.length() > 0) {			
				//项目证书编码
				if(type.equals("2")){
					content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getProjectCode()+"000000");
				}
				//学时证书编码
				else if(type.equals("3")){
					content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getProjectCode()+"000000");
				}
				content = content.replace("{name}", "姓 名");
				content = content.replace("{projectName}", project.getProjectName());
				content = content.replace("{startDate}", project.getStartDate());
				content = content.replace("{endDate}", project.getEndDate());
				content = content.replace("{period}", project.getClassPeriod().toString());
			}
				diploma.setContent(content);
				return diploma;
		}else{
			return diploma;
		}
		
	}
	
	@Override
	public EduDiploma queryYearDeplomaById(Integer id, String teacherName, int teacherId, String type)
			throws Exception {
		EduDiploma diploma = sysReadDAO.selectDiplomaById(id, null, type);
		if (diploma == null) {
			return null;
		}
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("lendYear", diploma.getYear());
		condition.put("teacherId", teacherId);
		condition.put("lendStatus", 1);
		PageObject pageObject = teacherProjectServiceIF.queryTeacherLendCredit(condition);
		
		String content = diploma.getContent();
			if(type.equals("1")){
				if(pageObject.getObjects().size() > 0){
					content = content.replace("{creditLend}", "(经学分借贷，视为合格)");
				}else{
					content = content.replace("{creditLend}", "");
				}
				content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getProjectPrefix()+StringUtils.leftPad(String.valueOf(teacherId), 7).replace(" ", "0"));
				content = content.replace("{name}", teacherName);
				content = content.replace("{title}", diploma.getTitle());
				content = content.replace("{startDate}", diploma.getStartDate());
				content = content.replace("{endDate}", diploma.getEndDate());
				content = content.replace("{period}", diploma.getNeedPeriod().toString());
				content = content.replace("{credit}", diploma.getNeedCredit().toString());
				diploma.setContent(content);
				return diploma;
			}
				diploma.setContent(content);
				return diploma;
		
	}
	
	@Override
	public Integer removeDeplomaById(Integer id)
			throws Exception {
		return sysWriteDAO.deleteCertificate(id);
	}
	
	@Override
	public Integer modifyCertificate(EduDiploma pojo) {
		return sysWriteDAO.updateCertificate(pojo);
	}
	
	@Override
	public Integer saveCertificate(EduDiploma pojo) {
		return sysWriteDAO.insertCertificate(pojo);
	}


	@Override
	public boolean addArea(SysArea area) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		List<SysArea> areas = sysReadDAO.selectAreaByBelong(params);
		for(SysArea areaList:areas){
			if(areaList.getAreaCode().equals(area.getAreaCode()))
				return false;			
		}
		Map<String,Object> param2 = new HashMap<String,Object>();
		param2.put("belong", area.getUpLvCode());
		List<SysArea> area2 = sysReadDAO.selectAreaByBelong(param2);
		for(SysArea areaList2:area2){			
			if(areaList2.getName().equals(area.getName())){
				return false;
			}
		}
		area.setStatus(Common.DATA_VALID);
		return sysWriteDAO.insertSysArea(area);
	}

	
	@Override
	public PageObject qryAreaList(int startIndex, int pageSize,int belong)
			throws Exception {
		PageObject po = new PageObject();
		Map<String,Object> params = new HashMap<String,Object>();
//		if(type.equals("p")){//查询所有省
//			params.put("belongProvinceId", 0);
//		}else if(type.equals("c")){//查询省下所有市
//			params.put("belongProvinceId", belong);
//		}else{
//			params.put("belongCityId", belong);
//		}
		params.put("upLvCode", belong);
		int count = sysReadDAO.countAreaByConditions(params);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		params.put("startIndex", po.getStartIndex());
		params.put("endIndex", pageSize);
		List<SysArea> areas = sysReadDAO.selectAreaByConditions(params);
		po.setObjects(areas);
		return po;
	}


	@Override
	public List<SysArea> selectAreaList(Map<String , Object> pram) throws Exception {
		List<SysArea> areas = sysReadDAO.selectAreaByBelong(pram);
		return areas;
	}
	
	@Override
	public PageObject queryDeplomaListPage(	Map<String, Object> paramMap, int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectDiplomaCountByCondition(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list =  sysReadDAO.selectDiplomaListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}

	/**
	 * 项目汇总统计 列表
	 * @author cl
	 * create date 2014-4-3
	 * @param paramMap
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryProjectStatistics(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectProjectCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<ProjectStatisticsActivty> list =  sysReadDAO.selectProjectList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	public PageObject queryModelStatistics(Map<String, Object> paramMap,int pageIndex,int pageSize) throws Exception{
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectModeStatisticsCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<ProjectStatisticsActivty> list = sysReadDAO.selectModelStatisticsList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	/**
	 * 
	 */
	public PageObject queryAreaStatistics(Map<String, Object> paramMap,int pageIndex,int pageSize) throws Exception{
		PageObject po = new PageObject();
		int count = 0;
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<ProjectStatisticsActivty> list = sysReadDAO.selectAreaStatisticsList(paramMap);
		po.setObjects(list);
		return po;
	}

	 /**
	 * 获取角色对应的权限
	 * @author cl
	 * @create date 2014-4-4
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRoleFuncActivty> queryRoleFuncList(Integer id)
			throws Exception {
		return sysReadDAO.selectRoleFuncList(id);
	}

	@Override
	public List<SysDictionary> querySubjectBySection(String id, String sectionName)
			throws Exception {
		return sysReadDAO.selectSubjectBySection(id, sectionName);
	}

	/**
	 * 获取角色列表
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> queryRoleList(Map<String, Object> param) throws Exception {
		return sysReadDAO.selectRoleList(param);
	}

	/**
	 * 更新角色
	 * @author cl
	 * @create date 2014-4-10
	 * @return
	 */
	public Integer updateRole(SysRole pojo) throws Exception {
		return sysWriteDAO.updateRole(pojo);
	}
	
	/**
	 * 通过code查询地区
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public SysArea queryAreaByCode(String code) throws Exception{
		SysArea area = sysReadDAO.selectAreaByCode(code);
		return area;
	}

	@Override
	public PageObject querySysOrganization(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectSysOrganizationCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Organization> list = sysReadDAO.selectSysOrganizationList(paramMap);
		po.setObjects(list);
		return po;
	}

	@Override
	public boolean addOrganizationInfo(Map<String, Object> paramMap)
			 {
//		boolean flagUser = false;
		boolean flagOrg = false ;
		try {
//			flagUser = sysWriteDAO.insertUserInfo(paramMap);
			flagOrg =  sysWriteDAO.insertOrganizationInfo(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flagOrg){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateOrganizationInfo(Map<String, Object> paramMap)
			throws Exception {
		return sysWriteDAO.updateOrganizationInfo(paramMap);
	}

	@Override
	public boolean deleteOrganizationInfo(Map<String, Object> paramMap)
			throws Exception {
		return sysWriteDAO.deleteOrganizationInfo(paramMap);
	}
	
	/**
	 * 查询系统设置的功能设置
	 * @author zxq
	 * @return
	 * @throws Exception
	 */
	@Override
	public SysSetup selectSysSetupInfo() throws Exception {
		SysSetup sysSetup = sysReadDAO.selectSysSetupInfo();
		return sysSetup;
	}

	
	/**
	 * 系统设置--功能设置修改
	 * @author zxq
	 * @return
	 */
	@Override
	public int modifySysSetup(SysSetup pojo) throws Exception {
		return sysWriteDAO.updateSysSetup(pojo);
	}

	@Override
	public Organization selectOrganizationInfoById(Integer organizationId)
			throws Exception {
		return sysReadDAO.selectOrganizationInfoById(organizationId);
	}

	
	@Override
	public Map<String,Object> parseExcel(String path,String type, Map<String, Object> paramMap) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
//		String random = String.valueOf(new Date().getTime());
		path = path.replace("\\", "/");
		File file = new File(path);
//		String account = path.substring(path.lastIndexOf("\\")+1,path.length());
		if(file.isDirectory()){
			// 文件按照上传时间的先后排序
			File[]  files = file.listFiles();
			Arrays.sort(files, new Comparator<File>() {
				public int compare(File f1, File f2) {
					 long diff = f1.lastModified() - f2.lastModified();  
					 if (diff > 0) {
						 return 1;  
					 } else if (diff == 0){
						 return 0;  
					 } else{
						 return -1;  
					 }
				}
				public boolean equals(Object obj){  
				    return true;  
				}
			}); 
			List<String> toExl = new ArrayList<String>();
			List<String> toDB = new ArrayList<String>();
			for(File f:files){
				if(!f.isDirectory()){
					String srcFileName = "";
					String srcFileName2 = "";
					Map<String,Object> map = null;
					InputStream is = new FileInputStream(f);
					String filename = f.getName();
					String fileType = filename.substring(filename.lastIndexOf(".")+1,filename.length());
					if(type.equals("teacher")){
						//自定义解析模板方法
						map = eduProjectService.parseExcel(is,fileType);
						//要拷贝的模板名称
						srcFileName = "import_teacher";
					}else if(type.equals("uploadScore")){// 解析上传培训成绩
						//自定义解析模板方法
						map = orgService.parseExcel(is, paramMap, fileType);
						//要拷贝的模板名称
						srcFileName = "upload_score";
					}else if(type.equals("orgainzations")){//承培机构----yinxiaolong
						//自定义解析模板方法
						map = orgService.parseExcel(is,fileType, paramMap);
						srcFileName = "import_org";
					}else if(type.equals("SSOrgs")){//实施机构----曉
						//自定义解析模板方法
						map = orgService.parseSSOrgExcel(is,fileType, paramMap);
						srcFileName = "import_ssjg";
					}else if(type.equalsIgnoreCase("student")){
						map = eduProjectService.parseStudentExcel(is,fileType,paramMap);
						srcFileName = "import_student";
					}else if(type.equals("area")){
						map = this.parseAreaExcel(is, fileType);
						srcFileName = "import_region";
					}else if(type.equalsIgnoreCase("school")){//导入学校
						map = schoolService.searchSchoolExcel(is,fileType);
						srcFileName = "import_school";
					}
					else if(type.equalsIgnoreCase("retirees")){
						//教师离退休导入
						map = eduProjectService.parseRetireesTeacherExcel(is,fileType,paramMap);
						srcFileName = "import_lituixiu";
					} else if(type.equalsIgnoreCase("fjimport")) {//能力提升报表
						srcFileName = "fjimport";
						map = this.parseFJExcel(is, fileType,paramMap);
					} else if(type.equalsIgnoreCase("import_teacher_train_score")) {//培训学情数据（学分汇总）
						srcFileName = "import_teacher_train_score";
						map = this.parseTrainScoreExcel(is, fileType,paramMap);
					}else if(type.equalsIgnoreCase("question")){
						//自定义解析模板方法
						map = eduProjectService.parsePaperQuestionExcel(is,fileType,null);
						//要拷贝的模板名称
						srcFileName = "import_paper_questions";
					}else if(type.equalsIgnoreCase("master")){//导入专家
						map = eduMasterService.searchMasterExcel(is,fileType);
//						map = schoolService.searchSchoolExcel(is,fileType);
						srcFileName = "import_master";
					}
					
					//String srcPath = path.split("uploadFile")[0]+"template";
					String srcPath = path.split("uploadFile")[0]+"uploadFile";
					
					String[] p = path.split("/");
					srcFileName2 = filename.substring(0,filename.lastIndexOf("."));

					//拷贝目标路径
//					String desPath = path+File.separator+"toDB_"+random;
					String desPath = path+"toDB";
					//新文件名
					String newName = srcFileName+"_"+new Date().getTime();
					log.warn("path="+path);
					log.warn("srcPath="+srcPath);
					log.warn("srcFileName2="+srcFileName2);
					log.warn("newName="+newName);
					
					//用于页面链接的文件路径
					String fp = desPath.split("uploadFile")[1]+File.separator+newName+".xls";
					if(((List<Row>)map.get("toDBRow")).size()!=0){
						List<Row> rows = (List<Row>) map.get("toDBRow");
						toDB.add(fp.replace("\\", "/")+":"+rows.size());
						//createExl(rows, srcPath, srcFileName, desPath, newName);
						createExl(rows, path, srcFileName2, desPath, newName);
					}
					
					if(((List<Row>)map.get("toExl")).size()!=0){
//						desPath = path+File.separator+"toExl_"+random;
						desPath = path+"toExl";
						fp = desPath.split("uploadFile")[1]+File.separator+newName+".xls";
						List<Row> rows = (List<Row>) map.get("toExl");
						toExl.add(fp.replace("\\", "/")+":"+rows.size());
						createExl(rows, path, srcFileName2, desPath, newName);
					}
				
				}
			}
			result.put("toDB", toDB);
			result.put("toExl", toExl);
		}else{
			throw new Exception("文件目录不存在或不是目录！");
		}
			
		return result;
	}
	
	//解析培训学情数据
	private Map<String, Object> parseTrainScoreExcel(InputStream is,
			String fileType, Map<String, Object> paramMap) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();	
		
		//List<SysArea> areaList = sysReadDAO.selectAllAreas();
		//List<EduSchool> schoolList = sysReadDAO.selectAllSchool();
		
		//正确的数据
		List<EduTeacherScoreInfo> dtos = new ArrayList<EduTeacherScoreInfo>();
		List<Row> dbRows = new ArrayList<Row>();//正确的行
		List<Row> rows = new ArrayList<Row>();//出错的数据
		
		List<String> checkExcIdNumList = new ArrayList<String>();
		int errCell = 10;
		Workbook wb = null;
		//excel 2003
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
		}
		//excel 2007
		else{
			wb = new XSSFWorkbook(is);				
		}
		Sheet sheet = wb.getSheetAt(0);
		int j = 0;
		Date importTime = new Date();
		for(int i = 1;i<=sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			String errorInfo = "";
			Cell errorCell = row.getCell(10);
			if(errorCell == null) {
				errorCell = row.createCell(10);
			}		
			if(row != null){
				j = 0;
				String realSchoolName = "";
				EduTeacherScoreInfo dto = new EduTeacherScoreInfo();
				String teacherName = DataUtil.getCellValue(row.getCell(j++));
				if(teacherName.length() >0 && teacherName.length() <14){
					teacherName = teacherName.replaceAll(" ", "");
					dto.setTeacherName(teacherName);
				}else{
					row.getCell(errCell).setCellValue("教师姓名为空或错误！");
					log.info("教师姓名不正确");
					rows.add(row);
					continue;
				}
				String idNumber = DataUtil.getCellValue(row.getCell(j++));
				if(idNumber.length() > 0){
					// 检查身份证号码在系统中是否存在
					EduUser user = userReadDao.getUserByLoginAccountOrIdNumber(idNumber);
					if(user == null){
						row.getCell(errCell).setCellValue("该身份证号码在系统中不存在！");
						log.info("该身份证号码在系统中不存在！");
						rows.add(row);
						continue;
					}else {
						realSchoolName = user.getSchoolName();
						if(!user.getRealName().equals(teacherName)){
							row.getCell(errCell).setCellValue("教师姓名与身份证号码不对应！");
							log.info("教师姓名与身份证号码不对应！");
							rows.add(row);
							continue;
						}
						
						if(!checkExcIdNumList.contains(idNumber)){
							checkExcIdNumList.add(idNumber);
							if(DataUtil.validateIDCard(idNumber)){
								dto.setIdNumber(idNumber.toUpperCase());
							}else{
								row.getCell(errCell).setCellValue("身份证号为空或错误！");
								log.info("身份证号不正确");
								rows.add(row);
								continue;
							}
						}else{
							row.getCell(errCell).setCellValue("模板中有重复的身份证号码！");
							log.info("模板中有重复的身份证号码");
							rows.add(row);
							continue;
						}
					}
				}
				String schoolName = DataUtil.getCellValue(row.getCell(j++));
				log.info(schoolName +" ---- "+realSchoolName);
				if(StringUtils.isNotEmpty(schoolName) && realSchoolName.equals(schoolName)){
					result.put("schoolName", schoolName);
					EduSchool school = sysReadDAO.selectSchoolByName(result);
					if(school != null){
						dto.setSchoolId(school.getSchoolId());
						dto.setSchoolName(school.getSchoolName());
					}
				}else{
					row.getCell(errCell).setCellValue("学校信息不存在或导入教师学校名称不匹配,原学校名称为 "+"【"+realSchoolName+"】");
					log.info("学校信息不存在或学校名称填写不匹配！");
					rows.add(row);
					continue;
				}
				
				String courseWorkNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(courseWorkNum)){
					dto.setCourseWorkNum(courseWorkNum);
				}
				String workShopNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(workShopNum)){
					dto.setWorkShopNum(workShopNum);
				}
				String trainActivitNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(trainActivitNum)){
					dto.setTrainActivitNum(trainActivitNum);
				}
				String trainActivitJoinNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(trainActivitJoinNum)){
					dto.setTrainActivitJoinNum(trainActivitJoinNum);
				}
				String practiceActivitNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(practiceActivitNum)){
					dto.setPracticeActivitNum(practiceActivitNum);
				}
				String projectReportNum = DataUtil.getCellValue(row.getCell(j++));
				if(StringUtils.isNotEmpty(projectReportNum)){
					dto.setProjectReportNum(projectReportNum);
				}
					
				dto.setCreateDate(DateUtil.dateToLongStr(importTime));
				dto.setUpdateDate(DateUtil.dateToLongStr(importTime));
				dto.setPushExcellent(Common.DEFAULT_STR);
				dto.setStatus(Common.DATA_VALID.toString());
			    if(errorInfo.equals("")) {
			    	dtos.add(dto);
			    	dbRows.add(row);
			    }else {
			    	errorCell.setCellValue(errorInfo);
			    	rows.add(row);
			    }    	
					    		 			
				}
			}
		//存数据库的数据
		result.put("toDB", dtos);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}

	/**
	 * 导出excel
	 * @param rows
	 * @param srcPath
	 * @param srcFileName
	 * @param desPath
	 * @param newName
	 * @return
	 * @throws Exception
	 */
	public void createExl(List<Row> rows,String srcPath,String srcFileName,String desPath,String newName) throws Exception{
		//拷贝模板
		String newFile = ExcelUtil.copyExcel(srcPath, srcFileName, desPath, newName);
		//导出excel
		ExcelUtil.exportExcel(rows, newFile);
	}
	
	/**
	 * 提交数据
	 * @param toDBpath 数据正确的excel路径
	 * @param type
	 * @param params 插入数据库时所需要的参数
	 * @param account 登录人，用于creat_by update_by
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> intoDB(String toDBpath,String type,String account,Map<String,Object> params) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		//导入总数
		int total = 0;
		int toExl = 0;		
		File file = new File(toDBpath);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File f:files){
				InputStream is = new FileInputStream(f);
				if(type.equals("teacher")){
					Map<String,Object> map = eduProjectService.parseExcel(is,"xls");
					List<TeacherDTO> dtos = (List<TeacherDTO>) map.get("toDB");
					List<Row> rows = (List<Row>) map.get("toExl");
					total += dtos.size();
					toExl += rows.size();
					if(dtos.size()>0){
						try {
							eduProjectService.importTeacher(dtos, account,params);
						} catch (Exception e) {
							// TODO Auto-generated catch block							
					        throw new Exception(e.getMessage());
						}
					}
				}else if(type.equals("student")){
					Map<String,Object> map = eduProjectService.parseStudentExcel(is, "xls",params);
					List<Integer> ids = (List<Integer>) map.get("toDB");
					total += ids.size();
					if(ids.size()>0){
						eduProjectService.procBatchSignUp(ids, (Integer)params.get("projectId"),params.get("account").toString(),params.get("type").toString());
					}
				}else if(type.equals("organization")) {
					Map<String,Object> map = orgService.parseExcel(is,"xls", params);
					List<OrganizationDto> dtos = (List<OrganizationDto>) map.get("toDB");
					total += dtos.size();
					if(dtos.size()>0){
						importOrganization(dtos, account);
					}
					
				}else if(type.equals("ssOrg")) {
					Map<String,Object> map = orgService.parseSSOrgExcel(is,"xls", params);
					List<OrganizationDto> dtos = (List<OrganizationDto>) map.get("toDB");
					total += dtos.size();
					if(dtos.size()>0){
						for(OrganizationDto dto : dtos){
							dto.setType(params.get("type").toString());
							dto.setCreateBy(account);
							dto.setUpdateBy(account);
						}
					}
					if(!orgWriteDAO.insertSSOrgs(dtos)){
						log.error("导入实施机构失败!");
						throw new Exception("导入实施机构失败！");
					}
				}else if(type.equals("uploadScore")){// 机构: 上传培训成绩
					Map<String,Object> map = orgService.parseExcel(is, params, "xls");
					List<ProjectCommonActivity> list = (List<ProjectCommonActivity>) map.get("toDB");
					total += list.size();
					Integer projectId = Integer.parseInt(params.get("projectId").toString());
					Integer orgId = Integer.parseInt(params.get("orgId").toString());
					// 根据projectId 查询出此项目的学时/学分
					// EduProjectDTO dto = eduProjectReadDAO.selectProFullInfoById(projectId);
					if(list.size()>0){
						for(ProjectCommonActivity pojo : list){
							int teacherId = teacherProReadDao.selectTeacherIdByIdNumber(pojo.getTeacherIdNumber());
							pojo.setTeacherId(teacherId);
							pojo.setProjectId(projectId);
							pojo.setOrganizationId(orgId);
							if(pojo.getTeacherTrainStatusId()==1){
								//pojo.setTeacherClassScore(dto.getClassScore());//学分
								//pojo.setTeacherClassPeriod(dto.getClassPeriod());//学时
							} else {
								pojo.setTeacherClassScore((float)0);//学分
								pojo.setTeacherClassPeriod(0);//学时
							}
							pojo.setUpdateBy(account);
							pojo.setUpdateDate(new Date());
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
							pojo.setUploadDate(dateFormat.format(new Date()));
						}
						if(orgWriteDAO.updateTeacherScore(list) == 0){
							log.error("机构: edu_project_common 教师成绩更新失败!");
							throw new Exception("机构: 教师成绩更新失败！");
						}
					} 
				} else if(type.equals("retirees")) {
					
					Map<String,Object> map = eduProjectService.parseRetireesTeacherExcel(is,"xls",params);
					List<Row> row = (List<Row>) map.get("toDBRow");
					List<Integer> ids = (List<Integer>) map.get("toDB");
					List<Row> rows = (List<Row>) map.get("toExl");
					total += ids.size();
					toExl += rows.size();
					//importTeacherTime = ids.get(0).getCreateDate();
					if(ids.size()>0){
						for (int i = 0; i < ids.size(); i++) {
							String changeTypeStr = DataUtil.getCellValue(row.get(i).getCell(2));
							String changeType = "31";
							if (changeTypeStr.equals("退休") ) {
								changeType ="31";
							} else if (changeTypeStr.equals("死亡") ) {
								changeType ="32";
							} else if (changeTypeStr.equals("离休") ) {
								changeType ="33";
							} else if (changeTypeStr.equals("离岗") ) {
								changeType ="34";
							} else if (changeTypeStr.equals("病休") ) {
								changeType ="35";
							} else if (changeTypeStr.equals("其他") ) {
								changeType ="36";
							} 
							teacherManageService.modifyTeacherRetirees(ids.get(i).toString(), changeType, params.get("realName").toString(), account, "");
						}
					}
				} else if(type.equals("uploadScore_admin")){// 管理员: 上传培训成绩
					Map<String,Object> map = orgService.parseExcel(is, params, "xls");
					List<ProjectCommonActivity> list = (List<ProjectCommonActivity>) map.get("toDB");
					total += list.size();
					
					Integer projectId = Integer.parseInt(params.get("projectId").toString());
					// 根据projectId 查询出此项目的学时/学分
					// EduProjectDTO dto = eduProjectReadDAO.selectProFullInfoById(projectId);
					if(list.size()>0){
						for(ProjectCommonActivity pojo : list){
							int teacherId = teacherProReadDao.selectTeacherIdByIdNumber(pojo.getTeacherIdNumber());
							pojo.setTeacherId(teacherId);
							pojo.setProjectId(projectId);
							/*if(pojo.getTeacherTrainStatusId()==1){
								pojo.setTeacherClassScore(dto.getClassScore());//学分
								pojo.setTeacherClassPeriod(dto.getClassPeriod());//学时
							} else {
								pojo.setTeacherClassScore((float)0);//学分
								pojo.setTeacherClassPeriod(0);//学时
							}*/
							pojo.setUpdateBy(account);
							pojo.setUpdateDate(new Date());
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
							pojo.setUploadDate(dateFormat.format(new Date()));
						}
						if(orgWriteDAO.updateTeacherScore(list) == 0){
							log.error("管理员: edu_project_common 教师成绩更新失败!");
							throw new Exception("管理员: 教师成绩更新失败！");
						}
					} 
				}else if(type.equals("area")){
					Map<String,Object> map = this.parseAreaExcel(is, "xls");
					List<SysArea> areas = (List<SysArea>) map.get("toDB");
					if(areas.size()>0){
						total += areas.size();
						importArea(areas);
					}
				}else if(type.equals("fjimport")){
					Map<String,Object> map = this.parseFJExcel(is, "xls",params);
					List<Fjimport> fjList = (List<Fjimport>) map.get("toDB");
					if(fjList.size()>0){
						total += fjList.size();
						for(Fjimport d : fjList) {
							d.setCreateBy(account);	
							d.setUpdateBy(account);	
						}
						
						saveFJimport(fjList);
						FjimportHistory history = new FjimportHistory();
						history.setCreateBy(account);
						history.setCreateDate(fjList.get(0).getCreateTime());
						history.setImportSuccessCount(total);
						history.setHistoryType("eduNltsTrainTeacher");
						saveFjimportHistory(history);
					}
				}else if(type.equals("import_teacher_train_score")){//导入教师学情数据（学分汇总）
					Map<String,Object> map = this.parseTrainScoreExcel(is, "xls",params);
					List<EduTeacherScoreInfo> teacherList = (List<EduTeacherScoreInfo>) map.get("toDB");
					if(teacherList.size()>0){
						total += teacherList.size();
						for(EduTeacherScoreInfo teacherScore : teacherList) {
							teacherScore.setCreateById(account);	
							teacherScore.setUpdateById(account);	
						}
						
						total = saveTeacherTrainScoreData(teacherList);
						FjimportHistory history = new FjimportHistory();
						history.setCreateBy(account);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = sdf.parse(teacherList.get(0).getCreateDate());
						history.setCreateDate(date);
						history.setImportSuccessCount(total);
						history.setHistoryType("teacherTrainScore");
						saveFjimportHistory(history);
					}
				}else if(type.equals("question")){
					Map<String,Object> map = eduProjectService.parsePaperQuestionExcel(is, "xls",params);
					List<Row> rows = (List<Row>) map.get("toDBRow");
					total = rows.size();
					if(total>0){
						eduProjectService.batchInsertPaperQuestion(rows, params);
					}
				}
			}
		}else{
			log.info("文件路径错误-->"+toDBpath);//
		}
//		FileUtils.deleteFolder(toDBpath.substring(0,toDBpath.lastIndexOf("\\")));
		//导入教师历史记录  或 离退历史记录
		if(type.equals("teacher") || type.equals("retirees")){
			String realName = params.get("realName").toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(params.get("date").toString());
			log.info("导入教师历史记录时间---->"+date);
			String names = params.get("names").toString();
			String exlPath = params.get("exlPath").toString();
			eduProjectService.procWrite2ImportTeacherHistory(account, realName,date,total,toExl,names,exlPath, type);
		} 
		result.put("total", total);
		return result;
	}
	
	//保存培训学情数据
	private int saveTeacherTrainScoreData(List<EduTeacherScoreInfo> teacherList) {
		Map<String,Object> params = new HashMap<String,Object>();
		int count = 0;
		for(EduTeacherScoreInfo teacher : teacherList) {
			EduTeacherScoreInfo pojo = null;
			params.put("idNumber", teacher.getIdNumber());
			try {
				List<EduTeacherScoreInfo> teacherTrainList = sysReadDAO.queryEduTeacherScoreInfoList(params);
				if(teacherTrainList.size() > 0){
					pojo = teacherTrainList.get(0);
					params.put("status", Common.DATA_NO_VALID);
					sysWriteDAO.updateEduTeacherTrainScoreInfo(params);
					teacher.setPushExcellent(pojo.getPushExcellent());//修改同时保留推优意见
					teacher.setPushComment(pojo.getPushComment());
				}
				EduUser user = userReadDao.queryUserByIdNumber(teacher.getIdNumber());
				teacher.setTeacherId(user.getId());
				if(sysWriteDAO.insertEduTeacherTrainScoreInfo(teacher) >0){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	/**
	 * 打包下载
	 * @return
	 *	2014-4-19
	 * Devil
	 */
	public String createZipFile(String path,File[] files) throws Exception{
//		long random = new Date().getTime();
		path = path+"edu_export.zip";
		File zip = new File(path);
		FileUtils.ZipFiles(zip, files);
		return path;
	}

	@Override
	public boolean importOrganization(List<OrganizationDto> dtos, String account)  {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("createBy", account);
		params.put("updateBy", account);
		boolean orgFlag = false;
//		boolean userFlag = false;
		try {
			orgFlag = sysWriteDAO.batchOrg(dtos, params);
//			userFlag = sysWriteDAO.batchUser(dtos, params);
			if(orgFlag){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delArea(int id) throws Exception {
		boolean ok = false;
		//判断该地区是否已经被使用
		boolean hasUsed = hasUsed(id);
		
		if(!hasUsed){
			ok = sysWriteDAO.deleteArea(id);
		}
		
		
		return ok; 
	}
	
	public boolean hasUsed(int areaId) throws Exception{
		List<Integer>  areas = sysReadDAO.selectAreaById(areaId);
		for(Integer a:areas){
			if(a>0){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean modifyArea(Map<String, Object> params, int id)
			throws Exception {
		if(sysWriteDAO.updateSysArea(params, id) >0){
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> parseAreaExcel(InputStream is, String fileType)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		//正确的数据
		List<SysArea> dtos = new ArrayList<SysArea>();
		List<Row> dbRows = new ArrayList<Row>();
		List<Row> rows = new ArrayList<Row>();
		
		//地区数据
		List<SysArea> areas = sysReadDAO.selectAllAreas();
		
		Workbook wb = null;
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
			
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		for(int i = 1;i<=sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			if(row != null){
				if(row.getCell(5)==null){
					row.createCell(5);
				}
				String areaCode = DataUtil.getCellValue(row.getCell(0));  //区域编码
				String province = DataUtil.getCellValue(row.getCell(1));
				String city = DataUtil.getCellValue(row.getCell(2));
				String district = DataUtil.getCellValue(row.getCell(3));
				
				Map<String,Object> paramMap = new HashMap<String,Object>();
				
				paramMap.put("name", province);
				SysArea areaProvince = sysReadDAO.getAreaByName(paramMap);
				String provinceId = "";
				if(areaProvince != null){
					provinceId = areaProvince.getUpLvCode();
				}
				
				paramMap.put("name", city);
				if(areaProvince != null){
					paramMap.put("code", areaProvince.getCode());
				}
				SysArea areaCity = sysReadDAO.getAreaByName(paramMap);
				String cityId = "";
				if(areaCity != null){
					cityId = areaCity.getUpLvCode();
				}
				
				paramMap.put("name", district);
				if(areaCity != null){
					paramMap.put("code", areaCity.getCode());
				}
				SysArea areaDistrict = sysReadDAO.getAreaByName(paramMap);
				String districtId = "";
				if(areaDistrict != null){
					districtId = areaDistrict.getUpLvCode();
				}
				
				if(areaCode.length() == 0 || province.length() == 0 || (city.length() == 0 && district.length() != 0) 
						|| (province.length() != 0 && district.length() !=0 && city.length() == 0)){
					row.getCell(5).setCellValue("请按规则填写必填项！");
					rows.add(row);
					continue;
				}
				
				SysArea dto = new SysArea();
				//导入省级
				if(province.length()>0 && city.length()==0){
					if((DataUtil.validateArea(areas, province, "0") ||DataUtil.validateExcelArea(dtos, province,"0")) && city.length() == 0){
						log.info(province + "-->已经存在！");
						row.getCell(5).setCellValue("该省已经存在于系统中！");
						rows.add(row);
						continue;
					}else{
						dto.setAreaCode(areaCode);
						dto.setName(province);
						dto.setUpLvCode("0");
						dto.setStatus(1);
						dto.setType("0");
						dtos.add(dto);
						dbRows.add(row);
					}
				}else if(province.length()>0 && city.length()>0 && district.length() == 0){//导入市级
					//数据库中存在，或者excel表中存在上级
					String provinceCode = DataUtil.getAreaCodeByName(areas, province,"0");  
					if((DataUtil.validateArea(areas, province, "0") || DataUtil.validateExcelArea(dtos, province,"0")) 
							&& !DataUtil.validateExcelArea(dtos, city, "1")){
						if(provinceCode != null && DataUtil.validateArea(areas, city, provinceCode)){
							row.getCell(5).setCellValue("该市没有上级或上级不正确！");
							rows.add(row);
							continue;
						}
						dto.setAreaCode(areaCode);
						dto.setName(city);
						dto.setUpLvName(province);
						for(SysArea a:areas){
							if(a.getName().equals(province) && a.getType().equals("0")){
								dto.setUpLvCode(a.getCode());
							}
						}
						dto.setStatus(1);
						dto.setType("1");
						dtos.add(dto);
						dbRows.add(row);
					}else{
						row.getCell(5).setCellValue("未找到当前地区的父级地区！");
						rows.add(row);
						continue;
					}
				}else if(province.length()>0 && city.length()>0 && district.length()>0){//导入区级
					String cityCode = DataUtil.getAreaCodeByName(areas, city,"1");  //数据库中市Code
					//数据库中存在，或者excel表中存在
					provinceId = StringUtils.isEmpty(provinceId) ? "0" : provinceId;
					cityId  = StringUtils.isEmpty(cityId) ? "1" : cityId;
					
					if((DataUtil.validateArea(areas, province, provinceId) || DataUtil.validateExcelArea(dtos, province,provinceId)) 
							&& (DataUtil.validateArea(areas, city, DataUtil.getAreaCodeByName(areas, province,provinceId)) || DataUtil.validateExcelCityArea(dtos, city,cityId)) 
							&& !DataUtil.validateExcelArea(dtos, district, districtId)){
						if(cityCode != null && DataUtil.validateArea(areas, district, cityCode)){
							row.getCell(5).setCellValue("该地区没有上级或上级不正确！");
							rows.add(row);
							continue;
						}
						dto.setAreaCode(areaCode);
						dto.setName(district);
						dto.setStatus(1);
						dto.setUpLvName(city);
						for(SysArea a:areas){
							if(a.getName().equals(city) && a.getType().equals("1")){
								dto.setUpLvCode(a.getCode());
							}
						}
						dto.setType("2");
						dtos.add(dto);
						dbRows.add(row);
					}else{
						row.getCell(5).setCellValue("未找到当前地区的父级地区！");
						rows.add(row);
						continue;
					}
				}
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
	public void importArea(List<SysArea> areas) throws Exception {
		List<SysArea> provinces = new ArrayList<SysArea>();
		List<SysArea> cities = new ArrayList<SysArea>();
		List<SysArea> districts = new ArrayList<SysArea>();
		for(SysArea area:areas){
			if(area.getType().equals("0")){
				provinces.add(area);
			}else if(area.getType().equals("1")){
				cities.add(area);
			}else if(area.getType().equals("2")){
				districts.add(area);
			}
		}
		procIntoAreaDB(provinces, cities);
		procIntoAreaDB(cities, districts);
		procIntoAreaDB(districts, null);
	}
	
	private void procIntoAreaDB(List<SysArea> toDB,List<SysArea> belongs) throws Exception{
		for(SysArea area:toDB){
			int id = sysWriteDAO.insertSysAreaRtnID(area);
			if(id > 0 && belongs != null){
				procSetUpLvId(String.valueOf(id), area.getName(), belongs);
			}
		}
	}
	/**
	 * 通过上级地区名字，设置上级地区ID
	 * @param upId
	 * @param name
	 * @param areas
	 * @throws Exception
	 */
	private void procSetUpLvId(String upId,String name,List<SysArea> areas) throws Exception{
		for(SysArea area:areas){
			if(area.getUpLvName().equals(name)){
				area.setUpLvCode(upId);
			}
		}
	}
	
	
	/**
	 * 获取系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> selectSysFunction() throws Exception {
		return sysReadDAO.selectSysFunction();
	}

	/**
	 * 获取角色对应的系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> searchSysFunctionRole(Integer id) throws Exception {
		return sysReadDAO.selectSysFunction(id);
	}

	/**
	 * 更新角色信息以及角色权限
	 * @author cl
	 * @create date 2014-4-28
	 * @return
	 */
	public Integer modifyRoleFcun(SysRole pojo, List<SysRole> list)
			throws Exception {
		//1、更新角色信息
		if(sysWriteDAO.updateRoleInfo(pojo)==-1){
			throw new Exception("-1");//更新角色信息失败
		}
		//2、删除角色现有的角色权限
		if(sysWriteDAO.deleteRoleFunc(pojo.getId())==-1){
			throw new Exception("-2");//删除角色现有的角色权限失败
		}
		//3、新增角色权限
		if(list!=null && list.size()>0 && sysWriteDAO.insertRoleFunc(list)==-1){
			throw new Exception("-3");//新增角色权限失败
		}
		return 0;
	}

	@Override
	public List<EduUser> selectOrgAdmins(Map<String, Object> paramMap)
			throws Exception {
		return sysReadDAO.selectAdmins(paramMap);
	}

	@Override
	public PageObject queryselectOrgAdmins(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectOrgAdminsCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduUser> list = sysReadDAO.selectAdmins(paramMap);
		po.setObjects(list);
		return po;
	}

	@Override
	public ZTree getById(Map<String, Object> paramMap) throws Exception {
		return sysReadDAO.getById(paramMap);
	}
	
	@Override
	public ZTree getAreaTeacherById(Map<String, Object> paramMap) throws Exception {
		return sysReadDAO.getAreaTeacherById(paramMap);
	}

	@Override
	public List<ZTree> getChildAreaList(Map<String, Object> paramMap) throws Exception {
		return sysReadDAO.getChildAreaList(paramMap);
	}
	
	@Override
	public List<ZTree> getChildAreaTeacherList(Map<String, Object> paramMap) throws Exception {
		return sysReadDAO.getChildAreaTeacherList(paramMap);
	}

	@Override
	public List<ZTree> getSchoolTypeListOfArea(int areaId) throws Exception {
		return sysReadDAO.getSchoolTypeListOfArea(areaId);
	}

	@Override
	public List<ZTree> getSchoolListOfAreaByType(Map<String, Object> paramMap)
			throws Exception {
		return sysReadDAO.getSchoolListOfAreaByType(paramMap);
	}

	@Override
	public PageObject queryEduProjectNotrain(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.countNotrainByConditions(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduProjectNotrain> list =  sysReadDAO.selectNotrainByConditions(paramMap);
		po.setObjects(list);
		return po;
	}

	@Override
	public EduProjectNotrain selectNotraiByPrimaryKey(Integer id)
			throws Exception {
		return sysReadDAO.selectNotraiByPrimaryKey(id);
	}

	@Override
	public Integer deleteNotrain(Integer id) {
		return sysWriteDAO.deleteNotrain(id);
	}

	@Override
	public Integer updateNotrain(EduProjectNotrain notrain) {
		return sysWriteDAO.updateNotrain(notrain);
	}

	@Override
	public Integer insertNotrain(EduProjectNotrain notrain) {
		return sysWriteDAO.insertNotrain(notrain);
	}

	@Override
	public ZTree getAreaById(Map<String, Object> conditions) throws Exception {
		return sysReadDAO.getAreaById(conditions); 
	}

	@Override
	public List<ZTree> getSchoolTypeList(Map<String, Object> conditions)
			throws Exception {
		return sysReadDAO.getSchoolTypeList(conditions);
	}

	@Override
	public List<ZTree> getChildrenAreaById(Map<String, Object> conditions)
			throws Exception {
		return sysReadDAO.getChildrenAreaById(conditions);
	}

	@Override
	public List<ZTree> getSchoolList(Map<String, Object> conditions)
			throws Exception {
		return sysReadDAO.getSchoolList(conditions);
	}

	@Override
	public boolean enterCredit(Map<String, Object> params) throws Exception {
		return sysWriteDAO.enterCredit(params);
	}

	@Override
	public boolean auditCredit(Map<String, Object> params) throws Exception {
		return sysWriteDAO.auditCredit(params);
	}

	@Override
	public SysPlatformSetup selectSysPlatformSetup() throws Exception {
		return sysReadDAO.selectSysPlatformSetup();
	}

	/**
	 * 修改系统平台设置
	 * @param pojo
	 * @param path
	 * @return
	 * @throws Exception
	 * 
	 * @author 曉
	 */
	@Override
	public boolean updatePlatformSetup(SysPlatformSetup pojo, String path) throws Exception {
		int rtn = sysWriteDAO.updatePlatformSetup(pojo);
		if(rtn > 0){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 通过地区ID获取层级关系
	 */
	@Override
	public String getAreaRelationById(int id) throws Exception {
		StringBuilder areaStr = new StringBuilder();
		SysArea area = sysReadDAO.selectAreaByCode(String.valueOf(id));
		SysArea area2 = null;
		if("0".equals(area.getType())){
			areaStr.append(area.getName());
		}else	if("1".equals(area.getType())){
			area2 = sysReadDAO.selectAreaByCode(area.getUpLvCode());
			areaStr.append(area2.getName());
			areaStr.append(" >> ");
			areaStr.append(area.getName());
		}
//		else{
//			//市
//			area2 = sysReadDAO.selectAreaByCode(area.getUpLvCode());
//			//省
//			SysArea area3 = sysReadDAO.selectAreaByCode(area2.getUpLvCode());
//			areaStr.append(area3.getName());
//			areaStr.append(" >> ");
//			areaStr.append(area2.getName());
//			areaStr.append(" >> ");
//			areaStr.append(area.getName());
//		}
		return areaStr.toString();
	}

	//也不知道这个还有没有用。先留着吧
	@Override
	public List<ZTree> getNodes() throws Exception {
		return sysReadDAO.getNodes();
	}

	/**
	 * liuyiyou
	 */
	@Override
	public List<NoticeTree> getNodes(String id) throws Exception {
		return sysReadDAO.getNodes(id);
	}

	@Override
	public List<ZTree> getSchoolListOfTeacherByType(
			Map<String, Object> conditions) throws Exception {
		return sysReadDAO.getSchoolListOfTeacherByType(conditions);
	}

	public SysArea selectAreaByCode(String trainScopeId) throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.selectAreaByProScopeId(trainScopeId);
	}
	
	//检查地区名称
	private String checkArea(List<SysArea> areaList, String areaName) {
		String areaId = null;
		for(SysArea a : areaList) {
			if(a.getName().equals(areaName)) {
				areaId = a.getCode();
				break;
			}
		}
		return areaId;
	}
	
	private int checkSchool(List<EduSchool> schoolList, String schoolName) {
		int schoolId = -1;
		for(EduSchool school : schoolList) {
			if(school.getSchoolName().equals(schoolName)) {
				schoolId = school.getSchoolId();
				break;
			}
		}	
		return schoolId;
	}
	
	 @Override
	public Map<String, Object> parseFJExcel(InputStream is, String fileType,Map<String, Object> paramMap)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();	
		
		List<SysArea> areaList = sysReadDAO.selectAllAreas();
		List<EduSchool> schoolList = sysReadDAO.selectAllSchool();
		
		DecimalFormat df = new DecimalFormat("#.00");
	//正确的数据
		List<Fjimport> dtos = new ArrayList<Fjimport>();
		List<Row> dbRows = new ArrayList<Row>();//正确的行
		List<Row> rows = new ArrayList<Row>();//出错的数据
		
		Workbook wb = null;
		//excel 2003
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
		}
		//excel 2007
		else{
			wb = new XSSFWorkbook(is);				
		}
		Sheet sheet = wb.getSheetAt(0);
		int j = 0;
		Date importTime = new Date();
		for(int i = 1;i<=sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			String errorInfo = "";
			Cell errorCell = row.getCell(15);
			if(errorCell == null) {
				errorCell = row.createCell(15);
			}		
			if(row != null){
				 j = 0;			
				String cityName = DataUtil.getCellValue(row.getCell(j++));
				String districtName = DataUtil.getCellValue(row.getCell(j++));
				String schoolName = DataUtil.getCellValue(row.getCell(j++));
				String shangbaoNum = DataUtil.getCellValue(row.getCell(j++));
				String dengluNum = DataUtil.getCellValue(row.getCell(j++));
				String canxunlv = DataUtil.getCellValue(row.getCell(j++));
				String youxiaoxuexiNum = DataUtil.getCellValue(row.getCell(j++));
				String xuexilv = DataUtil.getCellValue(row.getCell(j++));
				String hegenum = DataUtil.getCellValue(row.getCell(j++));
				String hegelv = DataUtil.getCellValue(row.getCell(j++));
				String kechengzuoyeNum = DataUtil.getCellValue(row.getCell(j++));
				String gongzuofangNum = DataUtil.getCellValue(row.getCell(j++));
				String yanxiuhuodongNum = DataUtil.getCellValue(row.getCell(j++));
				String yanxiuhuodongcanyuNum = DataUtil.getCellValue(row.getCell(j++));
				String shijianyanxiuNum = DataUtil.getCellValue(row.getCell(j++));
				String xiaomujianbaoNum = DataUtil.getCellValue(row.getCell(j++));
				
				Fjimport dto = new Fjimport();
					dto.setProvinceId(paramMap.get("provinceId").toString());
					dto.setProvinceName(paramMap.get("provinceName").toString());
					dto.setCityName(cityName);
					dto.setDistrictName(districtName);
					dto.setSchoolName(schoolName);
					if(shangbaoNum != null && !"".equals(shangbaoNum)){
						dto.setShangbaoNum(Integer.valueOf(shangbaoNum));
					}
					if(dengluNum != null && !"".equals(dengluNum)){
						dto.setDengluNum(Integer.valueOf(dengluNum));
					}
					if(youxiaoxuexiNum != null && !"".equals(youxiaoxuexiNum)){
						dto.setYouxiaoxuexiNum(Integer.valueOf(youxiaoxuexiNum));
					}
					if(shangbaoNum != null && !"".equals(hegenum)){
						dto.setHegenum(Integer.valueOf(hegenum));
					}
					//课程作业数
					if(kechengzuoyeNum != null && !"".equals(kechengzuoyeNum)){
						dto.setKechengzuoyeNum(Integer.valueOf(kechengzuoyeNum));
					}
					//工作坊数
					if(gongzuofangNum != null && !"".equals(gongzuofangNum)){
						dto.setGongzuofangNum(Integer.valueOf(gongzuofangNum));
					}
					//研修活动数
					if(yanxiuhuodongNum != null && !"".equals(yanxiuhuodongNum)){
						dto.setYanxiuhuodongNum(Integer.valueOf(yanxiuhuodongNum));
					}
					//研修活动参与数
					if(yanxiuhuodongcanyuNum != null && !"".equals(yanxiuhuodongcanyuNum)){
						dto.setYanxiuhuodongcanyuNum(Integer.valueOf(yanxiuhuodongcanyuNum));
					}
					//实践研修成果数
					if(shijianyanxiuNum != null && !"".equals(shijianyanxiuNum)){
						dto.setShijianyanxiuNum(Integer.valueOf(shijianyanxiuNum));
					}
					//项目简报数
					if(xiaomujianbaoNum != null && !"".equals(xiaomujianbaoNum)){
						dto.setXiaomujianbaoNum(Integer.valueOf(xiaomujianbaoNum));
					}
					
					dto.setCreateTime(importTime);
					dto.setUpdateTime(importTime);
				
				
				String areaId = checkArea(areaList,cityName);
				if(areaId == null) {
					 errorInfo += "该地市不存在;";
				}else {
					dto.setCityId(areaId);
				}
				areaId = checkArea(areaList,districtName);
				if(areaId == null) {
					 errorInfo += "该区县不存在;";
				}else{
					dto.setDistrictId(areaId);	
				}
				int schoolId = checkSchool(schoolList,schoolName);
			    if(schoolId == -1) {
					 errorInfo += "该学校不存在;";
				}else {
					dto.setSchoolId(String.valueOf(schoolId));		
				}
			    
			    if(errorInfo.equals("")) {
			    	dtos.add(dto);
			    	dbRows.add(row);
			    }else {
			    	errorCell.setCellValue(errorInfo);
			    	rows.add(row);
			    }    	
					    		 			
				}
			}
		
				
		//存数据库的数据
		result.put("toDB", dtos);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}
	
	 private int saveFJimport(List<Fjimport> fjList) {
		 Map<String,Object> params = new HashMap<String,Object>();
		int count = 0;
		for(Fjimport d : fjList) {
			Fjimport f = new Fjimport();
			params.put("schoolName", d.getSchoolName());
			try {
				List<Fjimport> fjimportList = sysWriteDAO.queryFjimportList(params);
				if(fjimportList.size() > 0){
					f = fjimportList.get(0);
					sysWriteDAO.updateFjimport(d);
				}
				//导入能力提升数据时，防止orgName为null
				if(d.getOrgName() == null){
					d.setOrgName(f.getOrgName());
				}
				//各机构推送能力提升数据时，设置已经上传的上报人数和合格人数
				/*if(d.getShangbaoNum() == null || d.getShangbaoNum() == 0){
					d.setShangbaoNum(f.getShangbaoNum());
				}
				if(d.getHegenum() == null || d.getHegenum() == 0){
					d.setHegenum(f.getHegenum());
				}*/
				if(sysWriteDAO.insertFJimport(d) >0){
					count++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public List<Fjimport> getFjimportList(Map<String, Object> paramMap) {
		List<Fjimport>  result = sysWriteDAO.getFjimportList(paramMap);
		return result;
	}


	private int saveFjimportHistory(FjimportHistory f) {
		sysWriteDAO.insertFJimportHistory(f);
		return 0;
	}

	@Override
	public List<FjimportHistory> getFjimportHistoryList(Map<String, Object> paramMap) {
		return sysWriteDAO.getFjimportHistoryList(paramMap);
		 
	}

	@Override
	public PageObject getFjimportHistoryListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) {
		PageObject po = new PageObject();
		po.setCount(sysWriteDAO.getFjimportHistoryCount(paramMap));
		
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		
		List<FjimportHistory> list = sysWriteDAO.getFjimportHistoryList(paramMap);
		po.setObjects(list);
		return po;
	}

	public List<FjTeacherStudyInfo> FJTeacherAchievements(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		// 通过地区name查询Id
		SysArea area = sysReadDAO.getAreaByName(params);
		List<FjTeacherStudyInfo> info = null ;
		if(area != null){
		params.put("areaId", area.getId());
		info = sysReadDAO.getFJTeacherAchievements(params);		
		}
		return info;
	}

	@Override
	public List<SysArea> getDistrictList() {
		List<SysArea> districtList= sysReadDAO.getDistrictList(null);
		return districtList;
	}

	@Override
	public List<SysArea> getAreaListByUpcode(String upcode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("upcode", upcode);
		List<SysArea> areaList = sysReadDAO.getAreaListByUpcode(paramMap);
		return areaList;
	}

	public PageObject getFjimportListPage(Map<String, Object> param,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysWriteDAO.getFjimportListCount(param));
		
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po
				.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		
		List<Fjimport> list = sysWriteDAO.getFjimportListPage(param);
		po.setObjects(list);
		return po;
	}

	public List<Fjimport> queryFjimportList(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Fjimport>  result = sysWriteDAO.queryFjimportList(params);
		return result;
	}

	public List<SysRole> queryRoleListByUser(Map<String, Object> param,Integer userRoleType, boolean onlyManager,
			boolean onlyShishi,boolean exceptShishi)
			throws Exception {
		Integer[] roleTypeIds;
		if(onlyManager) {
			if(exceptShishi) {
				// 添加管理员查询角色列表
				roleTypeIds = getManagerRoleTypeIdsByUserExceptShishi(userRoleType);
			}else {
				roleTypeIds = getManagerRoleTypeIdsByUser(userRoleType);
			}
			
		}else {
			// 查询用户角色列表
			roleTypeIds = getRoleTypeIdsByUser(param,userRoleType);
		}
		
		if(onlyShishi) {
			//添加实施机构管理员
			roleTypeIds = getShishiManagerRoleTypeIdsByUser(userRoleType);
		}
		param.put("roleTypeIds", roleTypeIds);
			
		// TODO Auto-generated method stub
		List<SysRole> roleList = sysReadDAO.selectRoleList(param);
		return roleList;
	}
	
	private Integer[] getRoleTypeIdsByUser(Map<String, Object> param,Integer userRoleType) {
		
		Integer[] systemRoleTypeArray = {
				0,1,2,3,4,5,6,7,8,9,10,20
		};
		Integer[] provinceRoleTypeArray = {
				1,2,3,4,5,6,7,8,9,10,20
		};
		Integer[] cityRoleTypeArray = {
				2,3,4,5,6,8,9,10,20
		};
		Integer[] districtRoleTypeArray = {
				3,4,5,6,9,10,20
		};
		Integer[] schoolRoleTypeArray = {
				4,5,6,10,20
		};
		
		Integer[] roleTypeArray = null;
		switch(userRoleType){
		case 0:roleTypeArray = systemRoleTypeArray;break;
		case 1:roleTypeArray = provinceRoleTypeArray;break;
		case 2:roleTypeArray = cityRoleTypeArray;break;
		case 3:roleTypeArray = districtRoleTypeArray;break;
		case 4:roleTypeArray = schoolRoleTypeArray;break;
		default:roleTypeArray = systemRoleTypeArray;
		}
		
		return roleTypeArray;
	}
	
    private Integer[] getManagerRoleTypeIdsByUser(Integer userRoleType) {
		
		Integer[] systemRoleTypeArray = {
				1,2,3,4,6,7,8,9,10
		};
		Integer[] provinceRoleTypeArray = {
				1,2,3,4,6,7,8,9,10
		};
		Integer[] cityRoleTypeArray = {
				2,3,4,6,8,9,10
		};
		Integer[] districtRoleTypeArray = {
				3,4,6,9,10
		};
		Integer[] schoolRoleTypeArray = {
				4,6,10
		};
		
		
		Integer[] roleTypeArray = null;
		switch(userRoleType){
		case 0:roleTypeArray = systemRoleTypeArray;break;
		case 1:roleTypeArray = provinceRoleTypeArray;break;
		case 2:roleTypeArray = cityRoleTypeArray;break;
		case 3:roleTypeArray = districtRoleTypeArray;break;
		case 4:roleTypeArray = schoolRoleTypeArray;break;
		default:roleTypeArray = systemRoleTypeArray;
		}
		
		return roleTypeArray;
	}
    
   private Integer[] getShishiManagerRoleTypeIdsByUser(Integer userRoleType) {
		
		Integer[] systemRoleTypeArray = {
				7,8,9,10
		};
		Integer[] provinceRoleTypeArray = {
				7,8,9,10
		};
		Integer[] cityRoleTypeArray = {
				8,9,10
		};
		Integer[] districtRoleTypeArray = {
				9,10
		};
		Integer[] schoolRoleTypeArray = {
			    10
		};
				
		
		Integer[] roleTypeArray = null;
		switch(userRoleType){
		case 0:roleTypeArray = systemRoleTypeArray;break;
		case 1:roleTypeArray = provinceRoleTypeArray;break;
		case 2:roleTypeArray = cityRoleTypeArray;break;
		case 3:roleTypeArray = districtRoleTypeArray;break;
		case 4:roleTypeArray = schoolRoleTypeArray;break;
		default:roleTypeArray = systemRoleTypeArray;
		}
		
		return roleTypeArray;
	}
   
   private Integer[] getManagerRoleTypeIdsByUserExceptShishi(Integer userRoleType) {
		
		Integer[] systemRoleTypeArray = {
				1,2,3,4,6
		};
		Integer[] provinceRoleTypeArray = {
				1,2,3,4,6
		};
		Integer[] cityRoleTypeArray = {
				2,3,4,6
		};
		Integer[] districtRoleTypeArray = {
				3,4,6
		};
		Integer[] schoolRoleTypeArray = {
				4,6
		};
		
		Integer[] roleTypeArray = null;
		switch(userRoleType){
		case 0:roleTypeArray = systemRoleTypeArray;break;
		case 1:roleTypeArray = provinceRoleTypeArray;break;
		case 2:roleTypeArray = cityRoleTypeArray;break;
		case 3:roleTypeArray = districtRoleTypeArray;break;
		case 4:roleTypeArray = schoolRoleTypeArray;break;
		default:roleTypeArray = systemRoleTypeArray;
		}
		
		return roleTypeArray;
	}

	
	public List<RoleType> getRoleTypeListByUser(Map<String, Object> param,Integer userRoleType) {
		// TODO Auto-generated method stub
		List<RoleType> roleTypeList = sysReadDAO.getRoleTypeList(param);
		List<RoleType> resultList = new ArrayList<RoleType>();
		Integer[] roleTypeIds = getRoleTypeIdsByUser(param,userRoleType);
		for(RoleType r:roleTypeList) {
			for (Integer temp : roleTypeIds) {
				if(temp.toString().equals(r.getId().toString())) {
					resultList.add(r);
				}
			}
		}
		return resultList;
	}

	public int addRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		int result = sysWriteDAO.insertRole(sysRole);
		return result;
	}

	public int saveTrainingInfo(List<Fjimport> objList) throws Exception {
		// TODO Auto-generated method stub
		//删除无效数据 status = 0
		deleteTrainingInfo(objList);
		return saveFJimport(objList);
	}

	private int deleteTrainingInfo(List<Fjimport> objList) throws Exception{
		// TODO Auto-generated method stub
		return sysWriteDAO.deleteTrainingInfoByStatus(objList);
	}

	public int insertSysLog(HttpServletRequest request,Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("createDate",new Date());
		params.put("userIp",SendHttpRequest.getLocalIp(request));
		return sysWriteDAO.insertSysLog(params);
	}

	public List<EduDiploma> queryAllProjectDeploma() throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.queryAllProjectDeploma();
	}

	public FjimportActivty getFjimportShangbaoNumAndHegeNum(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.getFjimportInfo(param);
	}

	public PageObject getTeacherTrainScorePage(Map<String, Object> param,int startIndex, int pageSize) throws Exception  {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.getTeacherTrainScoreCount(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduTeacherScoreInfo> list = sysReadDAO.getTeacherTrainScoreListPage(param);
		po.setObjects(list);
		return po;
	}

	/**
	 * 查询学情导入历史记录信息
	 */
	public PageObject getTeacherScoreHistoryListPage(Map<String, Object> param, int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.getTeacherScoreHistoryCount(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<FjimportHistory> list = sysReadDAO.getTeacherScoreHistoryListPage(param);
		po.setObjects(list);
		return po;
	}

	public List<EduTeacherScoreInfo> queryTeacherScoreListNoPage(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.queryTeacherScoreListNoPage(paramMap);
	}

	public int updateTeacherScore(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return sysWriteDAO.updateEduTeacherTrainScoreInfo(paramMap);
	}

	public EduTeacherScoreInfo getTeacherScoreInfoById( Map<String, Object> result) throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.getTeacherScoreInfoById(result);
	}

	public PageObject selectTeacherTrainScoreByTeacherId(Map<String, Object> param, int startIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.getTeacherTrainScoreByTeacherCount(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduProjectActivityPojo> list = sysReadDAO.getgetTeacherTrainScoreListByTeacher(param);
		po.setObjects(list);
		return po;
	}

	@Override
	public PageObject questionSurverSummaryList(Map<String, Object> param) {
		PageObject po = new PageObject();
		List<EduQustionSummary> list = sysReadDAO.questionSurverSummaryList(param);
		po.setObjects(list);
		return po;
	}

	@Override
	public Integer updateCertificate(EduDiploma pojo) {
		return sysWriteDAO.updateCertificate(pojo);
	}

	@Override
	public PageObject getTeacherTrainCreditPage(Map<String, Object> param,	int startIndex, int pageSize) {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.getTeacherTrainCreditCount(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduTeacherScoreInfo> list = sysReadDAO.getTeacherTrainCreditListPage(param);
		po.setObjects(list);
		return po;
	}

	@Override
	public List<EduTeacherScoreInfo> getTeacherTrainRemainCredit(
			Map<String, Object> condition, int startIndex, int pageSize) {
		List<EduTeacherScoreInfo> map= sysReadDAO.getTeacherTrainRemainCredit(condition);
		return map;
	}

	@Override
	public List<String> getNeedCredit(Map<String, Object> params) {
		return sysReadDAO.getNeedCredit(params);
	}

	@Override
	public int selectInitYear() {
		return sysReadDAO.selectInitYear();
	}

}
