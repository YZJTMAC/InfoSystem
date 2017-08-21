package project.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.message.pojo.NoticeTree;
import project.system.dao.ISysReadDAO;
import project.system.dao.ISysWriteDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysSchoolService;
import project.util.DataUtil;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

public class SysSchoolServiceImpl implements ISysSchoolService {
	private static final Logger log = Logger
			.getLogger(SysSchoolServiceImpl.class);
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO;

	@Autowired
	@Qualifier("sysWriteDAO")
	ISysWriteDAO sysWriteDAO;

	@Override
	public List<EduSchool> querySchoolList(String schoolName,
			Integer schoolTypeId, Integer schoolProvinceId,
			Integer schoolCityId, Integer schoolDistrictId, Integer schoolId)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("schoolId", schoolId);
		params.put("schoolName", schoolName);
		params.put("schoolTypeId", schoolTypeId);
		params.put("schoolProvinceId", schoolProvinceId);
		params.put("schoolCityId", schoolCityId);
		params.put("schoolDistrictId", schoolDistrictId);
		return sysReadDAO.selectSchoolList(params);
	}

	/**
	 * 学校管理列表
	 * 
	 * @author cl create date 2014-4-10
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject querySysSchool(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(sysReadDAO.selectSysSchoolCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduSchool> list = sysReadDAO.selectSysSchoolList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	public List<EduSchool> exportSysSchoolToExcel(Map<String, Object> paramMap) throws Exception{
		List<EduSchool> list = sysReadDAO.selectSysSchoolList(paramMap);
		return list;
	}


	/**
	 * 新增学校记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addSchool(EduSchool pojo) throws Exception {

		// 验证学校编码
		if (!DataUtil.validateNum2(pojo.getSchoolCode())) {
			throw new Exception("-1");
		}

		if (pojo.getSchoolCode().length() < 4
				|| pojo.getSchoolCode().length() > 16) {
			throw new Exception("-2");
		}

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("schoolCode", pojo.getSchoolCode());

		// 检查学校Code是否已经存在
		int m = sysReadDAO.selectSysSchoolCountForImport(param);
		if (m > 0) {
			throw new Exception("-3");
		}
		return sysWriteDAO.insertSchool(pojo);
	}

	/**
	 * 查询学校详细
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduSchool searchSchoolInfo(Integer id) throws Exception {
		return sysReadDAO.selectSysSchoolInfo(id);
	}

	/**
	 * 删除学校详细
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteSchool(EduSchool pojo) throws Exception {
		
		try {
			//检查学校是否已经被引用
			if(sysReadDAO.selectSchoolBelongCount(pojo.getSchoolId())>0){
				throw new Exception("-1");
			}
			return sysWriteDAO.deleteSchool(pojo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	/**
	 * 更新学校详细
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer updateSchool(EduSchool pojo) throws Exception {

		// 验证学校编码
		if (!DataUtil.validateNum2(pojo.getSchoolCode())) {
			throw new Exception("-1");
		}

		if (pojo.getSchoolCode().length() < 4
				|| pojo.getSchoolCode().length() > 16) {
			throw new Exception("-2");
		}

		if (!pojo.getOldSchoolCode().equals(pojo.getSchoolCode())) {
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("schoolCode", pojo.getSchoolCode());

			// 检查学校Code是否已经存在
			int m = sysReadDAO.selectSysSchoolCountForImport(param);
			if (m > 0) {
				throw new Exception("-3");
			}
		}

		return sysWriteDAO.updateSchool(pojo);
	}

	/**
	 * 学校导入，验证数据
	 */
	public Map<String, Object> searchSchoolExcel(InputStream is, String fileType)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		// 地区数据
		List<SysArea> areas = sysReadDAO.selectAllAreas();

		// 正确的数据
		List<EduSchool> ids = new ArrayList<EduSchool>();
		List<Row> dbRows = new ArrayList<Row>();
		// 数据不合格的row
		List<Row> rows = new ArrayList<Row>();

		List<String> arrSchoolCode = new ArrayList<String>();
		Workbook wb = null;
		if (fileType.equalsIgnoreCase("xls")) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		int max = sheet.getLastRowNum();

		//学校类型
		List<SysDictionary> arr_schoolType = sysReadDAO
				.selectDicByDicType("school_type");

		String[] arrSchoolType = new String[arr_schoolType.size()];
		String[] arrSchoolTypeId = new String[arr_schoolType.size()];
		int mm = 0;
		for (SysDictionary dis : arr_schoolType) {
			arrSchoolType[mm] = dis.getDictionaryName();
			arrSchoolTypeId[mm]=dis.getDictionaryId().toString();
			mm++;
		}

       //标题行
		Row titleRow = sheet.getRow(0);
		
		for (int i = 1; i < max + 1; i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				// 错误信息行
				if (row.getCell(11) == null) {
					row.createCell(11);
				}
				String schoolName = DataUtil.getCellValue(row.getCell(4));
				String province = DataUtil.getCellValue(row.getCell(0));
				String provinceId = "";
				String city = DataUtil.getCellValue(row.getCell(1));
				String cityId = "";
				String district = DataUtil.getCellValue(row.getCell(2));
				String districtId = "";
				String schoolCode = DataUtil.getCellValue(row.getCell(3));// 学校编码

				// 如果必填项全部为空视为这条数据为无效数据(过滤导入数据表里的空数据)
				if (schoolName.length() == 0 && province.length() == 0
						&& city.length() == 0 && district.length() == 0
						&& schoolCode.length() == 0) {
					log
							.info("导入学校：学校名称、编码以及地区全部为空，系统视为无效数据，不做任何处理，继续下一条导入.....");
					continue;
				}

				// 判断必填项是否为空
				if ((schoolName.length() != 0 && (province.length() == 0
						|| city.length() == 0 || district.length() == 0))
						|| (schoolName.length() == 0 && (province.length() != 0
								&& city.length() != 0 && district.length() != 0))) {
					row.getCell(11).setCellValue("学校名称、编码以及一、二、三级别地区不能为空！");
					rows.add(row);
					log.info("导入学校：必填项为空.....");
					continue;
				}

				if (schoolCode.length() == 0) {
					row.getCell(11).setCellValue("学校名称、编码以及一、二、三级别地区不能为空！");
					rows.add(row);
					log.info("导入学校：必填项为空.....");
					continue;
				}

				// 验证省份是否有效

				if (DataUtil.validateArea(areas, province, "0")) {
					provinceId = DataUtil.getAreaCodeByName(areas, province,
							"0");
				} else {
					log.info("导入学校：省份无效，province：" + province);
					row.getCell(11).setCellValue("一级地区无效！");
					rows.add(row);
					continue;
				}

				// 验证城市是否有效

				if (DataUtil.validateArea(areas, city, provinceId)) {
					cityId = DataUtil.getAreaCodeByName(areas, city, provinceId);
				} else {
					log.info("导入学校：城市无效，city：" + city);
					row.getCell(11).setCellValue("二级地区无效！");
					rows.add(row);
					continue;
				}

				// 验证区县是否有效 

				if (DataUtil.validateArea(areas, district, cityId)) {
					districtId = DataUtil.getAreaCodeByName(areas, district, cityId);
				} else {
					log.info("导入学校：区县无效，district：" + district);
					row.getCell(11).setCellValue("三级地区无效！");
					rows.add(row);
					continue;
				}

				String schoolType = DataUtil.getCellValue(row.getCell(5));// 学校类型

				// 检查学校类型是否为指定的值
	
				if (!DataUtil.ArrayExist(arrSchoolType, schoolType)) {
					log.info("导入学校：学校类型无效，schoolType：" + schoolType);
					row.getCell(11).setCellValue("学校类型无效！");
					rows.add(row);
					continue;
				}

				// String schoolNature =
				// DataUtil.getCellValue(row.getCell(1));// 学校性质
				// String[] arrSchoolNature = { "公办", "民办" };
				//
				// // 检查学校性质是否为指定的指
				// if (!DataUtil.ArrayExist(arrSchoolNature, schoolNature)) {
				// log.info("导入学校：学校性质无效，schoolNature："+schoolNature);
				// rows.add(row);
				// continue;
				// }

				// 验证学校编码
//				if (!DataUtil.validateNum2(schoolCode)) {
//					log.info("导入学校：学校编码无效，包含无效字符，schoolCode：" + schoolCode);
//					row.getCell(11).setCellValue("学校编码无效，应为4-16位的数字！");
//					rows.add(row);
//					continue;
//				}
				
//				if (schoolCode.length() < 4 || schoolCode.length() > 16) {
//					log.info("导入学校：学校编码无效，位数超出有效范围，schoolCode：" + schoolCode);
//					row.getCell(11).setCellValue("学校编码无效，应为4-16位的数字！");
//					rows.add(row);
//					continue;
//				}

//				if (arrSchoolCode.contains(schoolCode)) {
//					log.info("导入学校：Excel已经存在该学校编码，详情：" + schoolCode);
//					row.getCell(11).setCellValue("Excel源数据已经存在该学校编码！");
//					rows.add(row);
//					continue;
//
//				} else {
//					arrSchoolCode.add(schoolCode);
//				}

				Map<String, Object> param = new HashMap<String, Object>();
				param.put("schoolName", schoolName.length() > 0 ? schoolName
						: null);
				param.put("schoolProvinceId",
						provinceId.length() > 0 ? provinceId : null);
				param.put("schoolCityId", cityId.length() > 0 ? cityId : null);
				param.put("schoolDistrictId",
						districtId.length() > 0 ? districtId : null);

				// 检查区域对应的学校是否已经存在
				int n = sysReadDAO.selectSysSchoolCountForImport(param);

				param.clear();
				param.put("schoolCode", schoolCode);

				// 检查学校Code是否已经存在
				int m = sysReadDAO.selectSysSchoolCountForImport(param);
				if (m > 0) {
					log.info("导入学校：数据库已经存在该学校编码，详情：" + schoolCode);
					row.getCell(11).setCellValue("数据库已经存在该学校编码！");
					rows.add(row);
					continue;
				} else if (n > 0) {
					log.info("导入学校：已经存在该学校，详情：" + province + city + district
							+ schoolName);
					row.getCell(11).setCellValue("已经存在该学校！");
					rows.add(row);
					continue;
				} else {
					dbRows.add(row);

					EduSchool pojo = new EduSchool();

					pojo.setSchoolName(schoolName);

					//学校类型
					for(int k=0;k<arrSchoolType.length;k++){
						if(schoolType.equals(arrSchoolType[k].toString())){
							pojo.setSchoolTypeId(Integer.parseInt(arrSchoolTypeId[k]));
							pojo.setSchoolTypeName(schoolType);
						}
					}

					pojo.setSchoolProvinceId(Integer.parseInt(provinceId));
					pojo.setSchoolProvinceName(province);
					pojo.setSchoolCityId(Integer.parseInt(cityId));
					pojo.setSchoolCityName(city);
					pojo.setSchoolDistrictId(Integer.parseInt(districtId));
					pojo.setSchoolDistrictName(district);

					String schoolContacts = DataUtil.getCellValue(row
							.getCell(6));// 联系人
					if (schoolContacts.length() > 0) {
						pojo.setSchoolContacts(schoolContacts);
					}
					String schoolContactsType = DataUtil.getCellValue(row
							.getCell(7));// 联系方式
					if (schoolContactsType.length() > 0) {
						pojo.setSchoolContactsType(schoolContactsType);
					}
					String schoolContactsAddress = DataUtil.getCellValue(row
							.getCell(8));// 联系地址
					if (schoolContactsAddress.length() > 0) {
						pojo.setSchoolContactsAddress(schoolContactsAddress);
					}
					String schoolMemo = DataUtil.getCellValue(row.getCell(9));// 备注
					if (schoolMemo.length() > 0) {
						pojo.setSchoolMemo(schoolMemo);
					}
					pojo.setStatus(1);
					pojo.setSchoolCode(schoolCode);
					
					String schoolEstablish = DataUtil.getCellValue(row.getCell(DataUtil.getIndex("学校办别", titleRow)));
					if(schoolEstablish.equals("公办")) {
						pojo.setEstablishTypeId(1);
						pojo.setEstablishTypeName("公办");
					}else {
						pojo.setEstablishTypeId(2);
						pojo.setEstablishTypeName("民办");
					}

					ids.add(pojo);
				}
			}
		}
		// 去重
		Set<EduSchool> set = new HashSet<EduSchool>();
		for (EduSchool id : ids) {
			set.add(id);
		}
		ids.clear();
		for (EduSchool id : set) {
			ids.add(id);
		}
		// 存数据库的数据
		result.put("toDB", ids);
		result.put("toDBRow", dbRows);
		// 错误的数据
		result.put("toExl", rows);
		return result;
	}

	/**
	 * 学校导入 提交数据
	 * 
	 * @param toDBpath
	 *            数据正确的excel路径
	 * @param account
	 *            登录人，用于creat_by update_by
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> intoDB(String toDBpath, String account)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		// 导入总数
		int total = 0;
		File file = new File(toDBpath);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				InputStream is = new FileInputStream(f);
				Map<String, Object> map = this.searchSchoolExcel(is, "xls");
				List<EduSchool> ids = (List<EduSchool>) map.get("toDB");
				total += ids.size();
				if (ids.size() > 0) {
					sysWriteDAO.insertSchool(ids, account);
				}
			}
		}
		result.put("total", total);
		return result;
	}
	
	/**
	 * liuyiyou
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<NoticeTree> schoolTree(Map<String,Object> params)
			throws Exception {
		return sysReadDAO.schoolTree(params);
	}

	public EduSchool selectSchoolByName(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		return sysReadDAO.selectSchoolByName(params);
	}
}
