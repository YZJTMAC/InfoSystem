package project.message.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.common.Common;
import project.fileupload.service.IFileUploadService;
import project.message.pojo.EduNotice;
import project.message.pojo.EduNoticeFile;
import project.message.pojo.EduNoticeUser;
import project.message.pojo.NoticeTree;
import project.message.service.INoticeService;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

@Controller
@RequestMapping(value = "/notice/")
public class NoticeController extends AbsController {

	@Autowired
	@Qualifier("noticeService")
	private INoticeService noticeService;

	@Autowired
	@Qualifier("schoolService")
	private ISysSchoolService schoolService;

	@Autowired
	@Qualifier("userService")
	IUserService userService;

	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;

	@Autowired
	@Qualifier("sysService")
	private ISysService sysService;

	@RequestMapping(value = "/noticeList.htm")
	public String noticeListForm() {
		return "notice/noticeList";
	}

	@RequestMapping(value = "/myNoticeList.htm")
	public String myNoticeList() {
		return "notice/myNoticeList";
	}

	@RequestMapping(value = "/noticeList.do")
	@ResponseBody
	public Map<String, Object> noticeList(int pageSize, int startIndex,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		EduUserActivty obj = getSessionUserInfo(request);

		if (obj.getSchoolId() != null) {
			paramMap.put("schoolId", obj.getSchoolId());
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserDistrictId())) {
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserCityId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("cityId", obj.getUserCityId());
		} else if (!StringUtils.isEmpty(obj.getUserProvinceId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
		}

		int roleId = obj.getRoleId();
		if (roleId == 1 || roleId == 2 || roleId == 3 || roleId == 4) {
			paramMap.put("sendType", 1);
		} else if (roleId == 5) {
			paramMap.put("sendType", 3);
		} else {
			paramMap.put("sendType", 2);
		}

		String noticeType = request.getParameter("noticeType");
		System.out.println(noticeType);
		if (noticeType != null) {
			paramMap.put("noticeType", noticeType);
		} else {
			paramMap.put("noticeType", 1);
		}
		paramMap.put("userId", super.getAccountId(request));
		paramMap.put("schoolId", obj.getSchoolId());
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = noticeService.noticeList(paramMap, startIndex,
					pageSize);
			resultMap.put("success", true);
			resultMap.put("total", po.getCount());
			resultMap.put("rows", po.getObjects());
			resultMap.put("pageSize", po.getPagesize());
			resultMap.put("pages", po.getPages());
			resultMap.put("currentPage", po.getCurrentPage());
			resultMap.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}

		return resultMap;
	}

	@RequestMapping(value = "/myNoticeList.do")
	@ResponseBody
	public Map<String, Object> myNoticeList(int pageSize, int startIndex,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		EduUserActivty obj = getSessionUserInfo(request);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			paramMap.put("createBy", obj.getLoginAccount());
			PageObject po = noticeService.myNoticeList(paramMap, startIndex,
					pageSize);
			resultMap.put("success", true);
			resultMap.put("total", po.getCount());
			resultMap.put("rows", po.getObjects());
			resultMap.put("pageSize", po.getPagesize());
			resultMap.put("pages", po.getPages());
			resultMap.put("currentPage", po.getCurrentPage());
			resultMap.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}

		return resultMap;
	}

	@RequestMapping(value = "getNoticeCounts.do")
	@ResponseBody
	public Map<String, Object> getNoticeCounts(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		EduUserActivty obj = getSessionUserInfo(request);
		if (obj.getSchoolId() != null) {
			paramMap.put("schoolId", obj.getSchoolId());
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserDistrictId())) {
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserCityId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("cityId", obj.getUserCityId());
		} else if (!StringUtils.isEmpty(obj.getUserProvinceId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
		}

		int roleId = obj.getRoleId();
		if (roleId == 1 || roleId == 2 || roleId == 3 || roleId == 4) {
			paramMap.put("sendType", 1);
		} else if (roleId == 5) {
			paramMap.put("sendType", 3);
		} else {
			paramMap.put("sendType", 2);
		}
		paramMap.put("userId", super.getAccountId(request));
		// 总的通知，不需要noticeType参数
		try {
			int allNotice = noticeService.selectNoticeCount(paramMap);
			paramMap.clear();
			paramMap.put("userId", super.getAccountId(request));
			int userReadNoticeCount = noticeService.readNoticeCount(paramMap);
			resultMap.put("allNoticeCount", allNotice);
			resultMap.put("noticeCount", allNotice - userReadNoticeCount);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}

		return resultMap;

	}

	// 各级通知未读条数
	@RequestMapping(value = "getNoticeCountsByNoticeType.do")
	@ResponseBody
	public Map<String, Object> getNoticeCountsByNoticeType(
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		EduUserActivty obj = getSessionUserInfo(request);
		if (obj.getSchoolId() != null) {
			paramMap.put("schoolId", obj.getSchoolId());
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserDistrictId())) {
			paramMap.put("cityId", obj.getUserCityId());
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("districtId", obj.getUserDistrictId());
		} else if (!StringUtils.isEmpty(obj.getUserCityId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
			paramMap.put("cityId", obj.getUserCityId());
		} else if (!StringUtils.isEmpty(obj.getUserProvinceId())) {
			paramMap.put("provinceId", obj.getUserProvinceId());
		}

		int roleId = obj.getRoleId();
		if (roleId == 1 || roleId == 2 || roleId == 3 || roleId == 4) {
			paramMap.put("sendType", 1);
		} else if (roleId == 5) {
			paramMap.put("sendType", 3);
		} else {
			paramMap.put("sendType", 2);
		}

		paramMap.put("userId", super.getAccountId(request));

		try {
			// 分类通知数量，需要noticeType参数
			paramMap.put("noticeType", 1);
			int allProveNotice = noticeService.selectNoticeCount(paramMap);
			System.out.println("allProveNotice:" + allProveNotice);
			paramMap.put("noticeType", 2);
			int allCityeNotice = noticeService.selectNoticeCount(paramMap);
			paramMap.put("noticeType", 3);
			int allDistrictNotice = noticeService.selectNoticeCount(paramMap);
			paramMap.put("noticeType", 4);
			int allSchoolNotice = noticeService.selectNoticeCount(paramMap);

			paramMap.clear();
			paramMap.put("userId", super.getAccountId(request));
			paramMap.put("noticeType", 1);
			int userProviceReadNoticeCount = noticeService
					.readNoticeCount(paramMap);
			paramMap.put("noticeType", 2);
			int userCityProviceReadNoticeCount = noticeService
					.readNoticeCount(paramMap);
			paramMap.put("noticeType", 3);
			int userDistrictProviceReadNoticeCount = noticeService
					.readNoticeCount(paramMap);
			paramMap.put("noticeType", 4);
			int userSchoolProviceReadNoticeCount = noticeService
					.readNoticeCount(paramMap);
			int proviceNoReadCount = allProveNotice
					- userProviceReadNoticeCount;
			if (proviceNoReadCount < 0)
				proviceNoReadCount = 0;
			int districtNoReadCount = allDistrictNotice
					- userDistrictProviceReadNoticeCount;
			if (districtNoReadCount < 0)
				districtNoReadCount = 0;
			int cityNoReadCount = allCityeNotice
					- userCityProviceReadNoticeCount;
			if (cityNoReadCount < 0)
				cityNoReadCount = 0;
			int schoolNoReadCount = allSchoolNotice
					- userSchoolProviceReadNoticeCount;
			if (schoolNoReadCount < 0)
				schoolNoReadCount = 0;
			resultMap.put("proviceNoReadCount", proviceNoReadCount);
			resultMap.put("districtNoReadCount", districtNoReadCount);
			resultMap.put("cityNoReadCount", cityNoReadCount);
			resultMap.put("schoolNoReadCount", schoolNoReadCount);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}

		return resultMap;

	}

	@RequestMapping(value = "/getNode.do")
	public @ResponseBody
	List<NoticeTree> getNode(HttpServletRequest request) throws Exception {
		EduUserActivty obj = getSessionUserInfo(request);
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId = obj.getRoleId();
		if (roleId == 4 || roleId == 10) {// 校管理员/校实施机构管理员
			params.put("districtId", obj.getUserDistrictId());
			params.put("schoolId", obj.getSchoolId());
			return schoolService.schoolTree(params);
		} else {
			if (!StringUtils.isEmpty(obj.getUserDistrictId())) {
				return sysService.getNodes(obj.getUserDistrictId());
			} else if (!StringUtils.isEmpty(obj.getUserCityId())) {
				return sysService.getNodes(obj.getUserCityId());
			} else if (!StringUtils.isEmpty(obj.getUserProvinceId())) {
				return sysService.getNodes(obj.getUserProvinceId());
			}
		}
		return null;
	}

	@RequestMapping(value = "sendNotice.htm")
	public String sendNoticeForm(HttpServletRequest request, ModelMap map) {
		Integer roleId = super.getRoleId(request);
		switch (roleId) {
		case 1:
			// 省管理员
			map.put("noticeType", "1");
			map.put("typeName", "省级通知");
			break;
		case 2:
			map.put("noticeType", "2");
			map.put("typeName", "市级通知");
			break;
		case 3:
			map.put("noticeType", "3");
			map.put("typeName", "区县通知");
			break;
		case 4:
			map.put("noticeType", "4");
			map.put("typeName", "学校通知");
			break;
		default:
			break;
		}
		return "notice/sendNotice";
	}

	/**
	 * 
	 * @param notice
	 * @param request
	 * @param map
	 * @param area
	 *            :地区id
	 * @return
	 */
	@RequestMapping(value = "sendNotice.do")
	public void sendNotice(EduNotice notice, HttpServletRequest request,
			HttpServletResponse response, ModelMap map, String area) {
		JSONObject resultMap = new JSONObject();
		try {
			EduUserActivty obj = getSessionUserInfo(request);
			int roleId = obj.getRoleId();

			// 1：插入通知
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put("content", notice.getContent());
			paramMap.put("title", notice.getTitle());
			paramMap.put("roleType", notice.getRoleType());
			paramMap.put("sendType", notice.getSendType());
			paramMap.put("noticeType", notice.getNoticeType());
			paramMap.put("createBy", super.getAccount(request));
			paramMap.put("sendUserId", this.getAccountId(request));
			paramMap.put("status", 1);
			paramMap.put("sendUserName", this.getAccount(request));

			int noticeId = noticeService.sendNotice(paramMap);
			
			String[] fileUrls = request.getParameterValues("fileUrls");
			if (fileUrls == null) {
				paramMap.put("fileUrls", "");
			} else {
				for (String fileUrl : fileUrls) {
					String[] nameAndUrl = fileUrl.split("\\|");
					paramMap.clear();
					paramMap.put("noticeId", noticeId);
					paramMap.put("fileUrl", nameAndUrl[0]);
					paramMap.put("fileName", nameAndUrl[1]);
					noticeService.addNoticeFile(paramMap);
				}
			}

			// 插入通知范围
			paramMap.clear();
			paramMap.put("noticeId", noticeId);
			if (area == null) {
				area = "1";
			}
			if (roleId == 4 || roleId == 10) {// 校管理员/校实施机构管理员
				paramMap.put("schoolId", obj.getSchoolId());
				noticeService.addArea(paramMap);
			} else {
				String[] areaCodes = area.split(",");
				for (String areaCode : areaCodes) {
					paramMap.put("areaId", areaCode);
					noticeService.addArea(paramMap);
				}
			}

			resultMap.put("success", true);
			ResponseUtil.renderText(response, resultMap.toString());
			return;

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			ResponseUtil.renderText(response, resultMap.toString());
		}
		resultMap.put("success", false);
		ResponseUtil.renderText(response, resultMap.toString());
		return;
	}

	// 查看通知列表--而不是查看我的通知
	@RequestMapping(value = "noticeDetail.htm")
	public String noticeDetail(@RequestParam("id") Integer id,
			ModelMap modelMap, HttpServletRequest request) {
		EduNotice notice = noticeService.noticeDetail(id);
		modelMap.put("notice", notice);
		List<EduNoticeFile> noticeFiles = noticeService.selectNoticeFilesByNoticeId(id);
		modelMap.put("noticeFiles", noticeFiles);
		// 这里需要在中间表中进行插入
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {

			paramMap.put("noticeId", notice.getId());
			paramMap.put("userId", super.getAccountId(request));
			List<EduNoticeUser> noticeUsers = noticeService
					.getNoticeUser(paramMap);
			if (noticeUsers == null || noticeUsers.isEmpty()) {
				paramMap.put("noticeType", notice.getNoticeType());
				paramMap.put("noticeId", notice.getId());
				paramMap.put("userId", super.getAccountId(request));
				paramMap.put("hasRead", 1);
				paramMap.put("hasDelete", 0);
				noticeService.readNotice(paramMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "notice/noticeDetail";
	}

	// 查看自己发送的通知
	@RequestMapping(value = "myNoticeDetail.htm")
	public String myNoticeDetail(@RequestParam("id") Integer id,
			ModelMap modelMap, HttpServletRequest request) {
		EduNotice notice = noticeService.noticeDetail(id);
		modelMap.put("notice", notice);
//		String urls = notice.getFileUrls();
//		if (urls != null) {
//			String[] urlArray = urls.split(",");
//			modelMap.put("urlArray", urlArray);
//		}
		List<EduNoticeFile> noticeFiles = noticeService.selectNoticeFilesByNoticeId(id);
		modelMap.put("noticeFiles", noticeFiles);
		return "notice/noticeDetail";
	}

	// 删除自己发送的通知
	@RequestMapping(value = "noticeDelete.htm")
	public String noticeDelete(@RequestParam("id") Integer id,
			ModelMap modelMap, HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			paramMap.put("noticeId", id);
			paramMap.put("createBy", super.getAccount(request));
			noticeService.deleteNotice(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:myNoticeList.htm?click=4";
	}

	// 删除别人发送的通知
	@RequestMapping(value = "noticeDeleteFromOther.htm")
	public String noticeDeleteFromOther(@RequestParam("id") Integer id,
			ModelMap modelMap, HttpServletRequest request) {
		EduNotice notice = noticeService.noticeDetail(id);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("noticeId", notice.getId());
		paramMap.put("userId", super.getAccountId(request));
		try {
			List<EduNoticeUser> noticeUsers = noticeService
					.getNoticeUser(paramMap);
			// 如果之前没有阅读，则直接插入
			if (noticeUsers == null || noticeUsers.isEmpty()) {
				paramMap.put("noticeType", notice.getNoticeType());
				paramMap.put("noticeId", notice.getId());
				paramMap.put("userId", super.getAccountId(request));
				paramMap.put("hasRead", 1);
				paramMap.put("hasDelete", 1);
				noticeService.readNotice(paramMap);
			} else {
				// 如果之前已经阅读，直接更新
				paramMap.put("noticeId", id);
				paramMap.put("userId", super.getAccountId(request));
				noticeService.noticeDeleteFromOther(paramMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:noticeList.htm?click=3";
	}

	@RequestMapping(value = "/readNoticeIds.do")
	public @ResponseBody
	List<String> readNoticeIds(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", super.getAccountId(request));
		List<String> noticeids = noticeService.readNoticeIds(paramMap);
		return noticeids;
	}

	/**
	 * 保存发送通知附件 
	 */
	@RequestMapping("/uploadFile.do")
	public void saveSingleFile(HttpServletRequest request,
			HttpServletResponse response, Integer projectId,
			String projectName, String type) throws Exception {
		String accountName = getAccount(request);
		Integer roleType = getRoleId(request);
		Integer userId = getAccountId(request);
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mrequest.getFile("noticeFile");
		JSONObject reseult = fileUploadService.fileUploadSingleFile(file,
				request, response, type, projectId, projectName, userId,
				accountName, roleType,null);
//		String succcess = String.valueOf(reseult.get("success"));
//		if (!StringUtils.isEmpty(succcess) && Boolean.valueOf(succcess)) {
//			Map<String,Object> paramMap = new HashMap<String,Object>();
//			noticeService.addNoticeFile(paramMap);
//		}
		ResponseUtil.renderText(response, reseult.toString());
		return;
	}

	public static void main(String[] args) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("noticeType", 1);
		paramMap.put("noticeType", 2);
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}

		String str = null;
		String str2 = "";
		System.out.println(StringUtils.isEmpty(str));
		System.out.println(StringUtils.isEmpty(str2));
		System.out.println(String.valueOf(str));
//		System.out.println(str.toString());

		String succcess = "";
		if (!StringUtils.isEmpty(succcess) && Boolean.valueOf(succcess)) {
			System.out.println("x");
		}else{
			System.out.println("y");
		}
		
		
		String nameAndUrl = "uploadFile/1425868782268.png|1.png";
		String[] names = nameAndUrl.split("\\|");
		System.out.println(names[0]);
		System.out.println(names[1]);
	}

}
