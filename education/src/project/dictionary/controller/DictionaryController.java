package project.dictionary.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.dictionary.service.IDictionaryService;
import project.system.controller.SysSchoolController;
import project.system.pojo.SysDictionary;

import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

@Controller
@RequestMapping("/dictionary/dictionaryManages")
public class DictionaryController extends AbsController {
	private static final Logger log = Logger
			.getLogger(SysSchoolController.class);
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;

	/**
	 * 字典表系统管理页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "dictionaryList.htm")
	public String toDictionaryListPage() {
		return "system/dictionaryManagePage";
	}

	/**
	 * 字典表系统管理列表
	 * 
	 * @author yinxiaolong
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/dictionaryList.do")
	public @ResponseBody
	Map<String, Object> queryDictionaryList(String status, int pageIndex,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		if (!StringUtils.isEmpty(request.getParameter("dictionaryTypeId"))) {
			paramMap.put("dictionaryTypeId", request.getParameter("dictionaryTypeId"));
		}
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionary(paramMap, pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	// 数据字典增加
	@RequestMapping("saveDictionaryInfo.do")
	public @ResponseBody
	Map<String, Object> createArea(String dictionaryType,
			String dictionaryCode, String dictionaryName,
			String dictionaryTypeName, HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dictionaryType", dictionaryType);
		paramMap.put("dictionaryCode", dictionaryCode);
		paramMap.put("dictionaryName", dictionaryName);
		paramMap.put("dictionaryTypeName", dictionaryTypeName);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (dictionaryService.saveDictionaryInfo(paramMap)) {
				Common.initByHand();
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("数据字典增加失败:" + e);
			e.printStackTrace();
		}
		return result;
	}

	// 数据字典 修改
	@RequestMapping("editDictionary.do")
	public @ResponseBody
	Map<String, Object> updateDictionary(Integer id, String dictionName,
			String dictionCode, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("dictionName", dictionName);
		paramMap.put("dictionCode", dictionCode);
		try {
			if (dictionaryService.updateDictionaryInfoById(paramMap)) {
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("数据字典修改失败" + e);
			e.printStackTrace();
		}
		return result;
	}

	// 数据字典 删除
	@RequestMapping("deleteDictionary.do")
	public @ResponseBody
	Map<String, Object> deleteDictionary(String enableFlag, Integer id, String dictionaryCode, String dictionaryType,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("dictionaryType", dictionaryType);
		paramMap.put("dictionaryCode", dictionaryCode);
		if("1".equals(enableFlag)) {
			paramMap.put("status", 1);
		} else {
			paramMap.put("status", 0);
		}
		try {
			if (dictionaryService.deleteDictionaryInfoById(paramMap)) {
				Common.initByHand();
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("数据字典删除失败:" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author yinxiaolong 数据字典 验证重复
	 */
	@RequestMapping("getAllDictionaryInfo.do")
	public @ResponseBody
	Map<String, Object> getAllDictionaryInfo(String dictionaryType,
			String dictionaryCode, String dictionaryName,
			String dictionaryTypeName, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {/*
			List<SysDictionary> list = dictionaryService
					.selectAllSysDictionaryList(paramMap);
			if (list.size() > 0) {
				resultMap.put("success", true);
				for (int i = 0; i < list.size(); i++) {
					if (dictionaryType.equals(list.get(i).getDictionaryType())) {
						resultMap.put("no", true);
						paramMap.put("dictionaryType", dictionaryType);
						List<SysDictionary> listS = dictionaryService
								.selectAllSysDictionaryList(paramMap);

						for (int j = 0; j < listS.size(); j++) {
							if (dictionaryCode.equals(listS.get(j)
									.getDictionaryCode())) {
								throw new Exception("-1");
							}
						}
						for (int s = 0; s < listS.size(); s++) {
							if (dictionaryName.equals(listS.get(s)
									.getDictionaryName())) {
								throw new Exception("-2");
							}
						}
						break;
					} else {
						resultMap.put("no", false);
					}
				}
				resultMap.put("list", list);
			}
		*/
			//根据类型查询字典
			paramMap.put("dictionaryType", dictionaryType);
			List<SysDictionary> sysDictionaryList = dictionaryService.selectAllSysDictionaryList(paramMap);
			if(sysDictionaryList.size() <= 0){
				resultMap.put("success", false);
				return resultMap;			
			}
			for(int i = 0; i < sysDictionaryList.size(); i ++){
				//如果字典编码相同，抛异常不允许添加。
				if(sysDictionaryList.get(i).getDictionaryCode().equals(dictionaryCode)){
					throw new Exception("-1");
				}
				//如果字典名称相同并且状态为0禁用的，抛异常不允许添加。
				else if(sysDictionaryList.get(i).getDictionaryName().equals(dictionaryName)&&						
						(sysDictionaryList.get(i).getStatus().equals(0)||sysDictionaryList.get(i).getStatus()==null)){
					throw new Exception("-2");
				}
				else if(sysDictionaryList.get(i).getDictionaryName().equals(dictionaryName)){
					//如果字典名称相同，抛异常不允许添加。
					throw new Exception("-3");
				}				
			}
			resultMap.put("success", true);		
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);	
			if (e.getMessage().equals("-1")) {
				resultMap.put("errorCode", true);
			} else if (e.getMessage().equals("-2")) {
				resultMap.put("errorStatus", true);
			} 
			else if(e.getMessage().equals("-3")){
				resultMap.put("errorName", true);
			}
			else {
				log.error("数据字典信息查询失败-----:" + e);
			}
		}
		return resultMap;
	}

	/**
	 * 编辑前验证是否重复
	 * 
	 * @author yinxiaolong
	 * @param dictionnaryTypeName
	 * @param dictionName
	 * @param dictionCode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("verifyDictionary.do")
	public @ResponseBody
	Map<String, Object> verifyDictionaryInfo(String dictionnaryTypeName,
			String dictionName, String dictionCode, String oldName,
			String oldCode, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {/*
			List<SysDictionary> list = dictionaryService
					.selectAllSysDictionaryList(paramMap);
			if (list.size() > 0) {
				resultMap.put("success", true);
				for (int i = 0; i < list.size(); i++) {
					if (dictionnaryTypeName.equals(list.get(i)
							.getDictionaryType())) {

						paramMap.put("dictionaryType", dictionnaryTypeName);
						List<SysDictionary> listS = dictionaryService
								.selectAllSysDictionaryList(paramMap);

						if (!dictionCode.equals(oldCode)) {

							for (int j = 0; j < listS.size(); j++) {
								if (dictionCode.equals(listS.get(j)
										.getDictionaryCode())) {
									throw new Exception("-1");

								}
							}
						}
						if(!dictionName.equals(oldName)){
							for (int s = 0; s < listS.size(); s++) {
								if (dictionName.equals(listS.get(s)
										.getDictionaryName())) {
									throw new Exception("-2");

								}
							}
						}

						break;
					} else {
						resultMap.put("ok", false);
					}
				}
			}
		*/
			paramMap.put("dictionaryType", dictionnaryTypeName);
			List<SysDictionary> sysDictionaryList = dictionaryService.selectAllSysDictionaryList(paramMap);
			if(sysDictionaryList.size() <= 0){
				resultMap.put("success", false);
				return resultMap;			
			}
			for(int i = 0; i < sysDictionaryList.size(); i ++){
				if(!dictionCode.equals(oldCode)){
					//如果字典编码相同，抛异常不允许添加。
					if(sysDictionaryList.get(i).getDictionaryCode().equals(dictionCode)){
						throw new Exception("-1");
					}
				}
				if(!dictionName.equals(oldName)){
					//如果字典名称相同并且状态为0禁用的，抛异常不允许添加。
					if(sysDictionaryList.get(i).getDictionaryName().equals(dictionName)&&
							(sysDictionaryList.get(i).getStatus() == null||sysDictionaryList.get(i).getStatus().equals(0))){
						throw new Exception("-2");
					}
					else if(sysDictionaryList.get(i).getDictionaryName().equals(dictionName)){
						throw new Exception("-3");
					}
				}
			}
			resultMap.put("success", true);
		} catch (Exception e) {
			log.error("数据字典信息查询失败-----:" + e);
			//e.printStackTrace();
			resultMap.put("success", false);
			if (e.getMessage().equals("-1")) {
				resultMap.put("codeOk", true);
			}
			else if (e.getMessage().equals("-2")) {
				resultMap.put("statusOk", true);
			}
			else if (e.getMessage().equals("-3")) {
				resultMap.put("nameOk", true);
			}
		}
		return resultMap;
	}
}
