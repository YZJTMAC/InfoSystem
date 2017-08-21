/*package project.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import project.message.service.IMessageServiceIF;
import project.person.pojo.EduUser;
import project.person.service.IUserService;
import project.system.pojo.ZTree;
import project.system.service.ISysService;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;

@Controller
@RequestMapping("/message/messageManagement")
public class SendMessageController extends AbsController {

	private static final Logger log = Logger.getLogger(SendMessageController.class);
	@Autowired
	@Qualifier("messageService")
	IMessageServiceIF messageService;

	@Autowired
	@Qualifier("multipartResolver")
	private CommonsMultipartResolver multipartResolver;

	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	@Autowired
	@Qualifier("sysService")
	private ISysService sysService;
	
	@RequestMapping(value="/ztree.htm")
	public String ztree(){
		return "message/ztree";
	}
	
	@RequestMapping(value="/ztree2.htm")
	public String ztree2(){
		return "message/ztree2";
	}
	
	@RequestMapping(value="/getNode2.htm")
	public @ResponseBody List<ZTree> getNodes2() throws Exception{
		return sysService.getNodes();
	}
	@RequestMapping(value="/getNode.htm")
	public void getNodes() throws Exception{
		String[] params = new String[]{"1","2","3","4"};
		List<EduUser> users = userService.getUserListByParam(params);
		System.out.println("共有管理员："+users.size());
		
		
		
		String[] params2 = new String[]{"7"};
		List<EduUser> users2 = userService.getUserListByParam(params2);
		System.out.println("共有实施机构管理员："+users2.size());
		
		
		String[] params3 = new String[]{"5"};
		List<EduUser> users3 = userService.getUserListByParam(params3);
		System.out.println("共有教师："+users3.size());
	}

	*//**
	 * 发送消息插入
	 * @author liuyiyou 增加上传附件功能
	 * @param content
	 * @param title
	 * @param receiveUserName
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("sendMessageToUser.do")
	public void sendMessage(String projectId, String areaIdName,
			String sendType, String areaId, String roleId, String content,
			String title, String receiveUserName, String receverId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONObject map = new JSONObject();
		boolean isMultipart = multipartResolver.isMultipart(request);
		String imageUrl ="";
		try {
			//检查是审核通知还是非审核通知
			if (isMultipart) {
				MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
				MultipartFile files =  mrequest.getFile("file");
					if(FileUtils.isFileExists(files)){
						resultMap = messageService.fileUpload(request, resultMap, paramMap,files);
						Object result = resultMap.get("success");
						if(result!=null){
							if(Boolean.valueOf(result.toString())){
//								paramMap.put("userImageUrl", resultMap.get("userImageUrl"));
								imageUrl =  resultMap.get("userImageUrl").toString();
							}else{
								
								map.put("success", false);
								map.put("info", resultMap.get("info"));
								ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
								return ;
							}
						}
					}
					
				}
				
			if ("byArea".equals(sendType)) {
				resultMap = sendMessageByArea(projectId, areaIdName, sendType,
						areaId, roleId, content, title, receiveUserName,
						receverId, request, response, paramMap, resultMap,imageUrl);
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
				
			} else if ("byRole".equals(sendType)) {
				resultMap = sendMessageByRole(projectId, areaIdName, sendType,
						areaId, roleId, content, title, receiveUserName,
						receverId, request, response, paramMap, resultMap,imageUrl);
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			} else if ("byProject".equals(sendType)) {
				resultMap = sendMessageByProject(projectId, areaIdName,
						sendType, areaId, roleId, content, title,
						receiveUserName, receverId, request, response,
						paramMap, resultMap,imageUrl);
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			} else {
				resultMap = sendMessageByUser(projectId, areaIdName, sendType,
						areaId, roleId, content, title, receiveUserName,
						receverId, request, response, paramMap, resultMap,imageUrl);
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			}

		} catch (Exception e) {
			log.error("插入消息失败：" + e.getMessage());
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("info", "发送失败");
			ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
			return ;
		}
	}
	
	*//**
	 *  按地区发送消息
	 *//*
	private Map<String, Object> sendMessageByArea(String projectId,
			String areaIdName, String sendType, String areaId, String roleId,
			String content, String title, String receiveUserName,
			String receverId, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> paramMap,
			Map<String, Object> resultMap,String imageUrl) throws Exception {

		String createBy = this.getAccount(request);
		int sendUserId = this.getAccountId(request);
		boolean flag = false;
		if (!StringUtils.isEmpty(areaIdName)
				&& areaIdName.indexOf("provinceId") >= 0) {
			paramMap.put("userProvinceId", areaId);
		} else if (!StringUtils.isEmpty(areaIdName)
				&& areaIdName.indexOf("cityId") >= 0) {
			paramMap.put("userCityId", areaId);
		} else if (!StringUtils.isEmpty(areaIdName)
				&& areaIdName.indexOf("districtId") >= 0) {
			paramMap.put("userDistrictId", areaId);
		} else if (!StringUtils.isEmpty(areaIdName)
				&& areaIdName.indexOf("schoolId") >= 0) {
			paramMap.put("schoolId", areaId);
		}

		List<EduUser> list = userService.queryManagesList(paramMap);

		paramMap.clear();

		paramMap.put("content", content);
		paramMap.put("title", title);
		paramMap.put("createBy", createBy);
		paramMap.put("sendUserId", this.getAccountId(request));
		paramMap.put("sendUserName", createBy);
		paramMap.put("userImageUrl", imageUrl);
		flag = messageService.insertMessageByType(list, paramMap);

		if(flag){
			resultMap.put("success", true);
			resultMap.put("info", "成功发送");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "发送失败-该地区下没有管理员");
		}

		return resultMap;
	}

	*//**
	 *  按用户角色发送消息
	 *//*
	private Map<String, Object> sendMessageByRole(String projectId,
			String areaIdName, String sendType, String areaId, String roleId,
			String content, String title, String receiveUserName,
			String receverId, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> paramMap,
			Map<String, Object> resultMap,String imageUrl) throws Exception {

		paramMap.put("roleId", roleId);
		List<EduUser> list = userService.queryManagesList(paramMap);
		paramMap.clear();
		String createBy = this.getAccount(request);
		boolean flag = false;
		paramMap.put("content", content);
		paramMap.put("title", title);
		paramMap.put("createBy", createBy);
		paramMap.put("sendUserId", this.getAccountId(request));
		paramMap.put("sendUserName", createBy);
		paramMap.put("userImageUrl", imageUrl);

		flag = messageService.insertMessageByType(list, paramMap);
		if(flag){
			resultMap.put("success", true);
			resultMap.put("info", "成功发送");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "发送失败-该角色下没有管理员");
		}
		
		return resultMap;
	}

	*//**
	 *  根据项目发送消息
	 *//*
	private Map<String, Object> sendMessageByProject(String projectId,
			String areaIdName, String sendType, String areaId, String roleId,
			String content, String title, String receiveUserName,
			String receverId, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> paramMap,
			Map<String, Object> resultMap,String imageUrl) throws Exception {

		if (!StringUtils.isEmpty(projectId)) {
			paramMap.put("projectId", projectId);
		}

		List<EduUser> list = userService.queryManagesList(paramMap);
		String createBy = this.getAccount(request);
		boolean flag = false;
		paramMap.clear();

		paramMap.put("content", content);
		paramMap.put("title", title);
		paramMap.put("createBy", createBy);
		paramMap.put("sendUserId", this.getAccountId(request));
		paramMap.put("sendUserName", createBy);
		paramMap.put("userImageUrl", imageUrl);

		flag = messageService.insertMessageByType(list, paramMap);
		if(flag){
			resultMap.put("success", true);
			resultMap.put("info", "成功发送");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "发送失败-该项目下没有管理员");
		}
		
		return resultMap;
	}

	*//**
	 *  根据用户名发送消息
	 *//*
	private Map<String, Object> sendMessageByUser(String projectId,
			String areaIdName, String sendType, String areaId, String roleId,
			String content, String title, String receiveUserName,
			String receverId, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> paramMap,
			Map<String, Object> resultMap,String imageUrl) throws Exception {
		String createBy = this.getAccount(request);
		int sendUserId = this.getAccountId(request);
		boolean flag = false;
		paramMap.put("content", content);
		paramMap.put("title", title);
		paramMap.put("receiveId", receverId);
		paramMap.put("receiveUserName", receiveUserName);
		paramMap.put("createBy", createBy);
		paramMap.put("sendUserId", sendUserId);
		paramMap.put("sendUserName", createBy);
		paramMap.put("status", 3);
		paramMap.put("userImageUrl", imageUrl);
		flag = messageService.insertMessage(paramMap);
		if(flag){
			resultMap.put("success", true);
			resultMap.put("info", "成功发送");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "发送失败");
		}
		return resultMap;
	}
}
*/