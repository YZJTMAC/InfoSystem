package project.organization.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.service.IOrganizationServiceIF;
import project.util.ApplicationProperties;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;

/**
 * 培训材料控制器
 * */
@Controller
public class TrainingMaterialsController extends AbsController {

	private static Log log = LogFactory
			.getLog(TrainingMaterialsController.class);

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	@Qualifier("organizationService")
	IOrganizationServiceIF orgService;

	/**
	 * 实施机构培训材料页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("org/trainingMaterials.htm")
	public String trainingMaterialsUrl() {
		return "organization/trainingMaterials";
	}

	/**
	 * 实施机构培训材料查询
	 * 
	 * @return
	 */
	@RequestMapping("org/trainingMaterialsQuery.do")
	@ResponseBody
	public Map<String, Object> trainingMaterialsQuery(
			@RequestParam(value = "type") Integer type,
			@RequestParam(value = "pid") Integer pid, ModelMap map) {
		log.debug("实施机构提交的培训材料");
		List<EduProjectTrainingMaterials> eptms = Collections.emptyList();
		try {
			eptms = orgService.queryTrainingMaterialsByPid(pid);
			map.put("result", true);
			map.put("info", eptms);
		} catch (Exception e) {
			map.put("result", false);
			map.put("info", null);
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 实施机构培训材料增加
	 * 
	 * @return
	 */
	@RequestMapping("org/trainingMaterialsAdd.do")
	public void trainingMaterialsAdd(HttpServletRequest request,
			HttpServletResponse response, Integer type, Integer projectId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;

		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		// 文件保存路径应该是:总结报告路径/项目id/老师或者机构的id
		String savePath = ApplicationProperties
				.getPropertyValue("upload_train_file")
				+ File.separator
				+ projectId
				+ File.separator
				+ getAccountId(mrequest)
				+ File.separator;// 获取保存文件的路径
		List<MultipartFile> files = mrequest.getFiles("file");
		if (!FileUtils.isFileExists(files)) {
			// 需要上传文件
			resultMap.put("success", false);
			resultMap.put("info", "请上传文件");
			ResponseUtil.renderText(response, JSONObject.fromObject(resultMap)
					.toString());
			return;
		}

		String name = "";
		for (MultipartFile file : files) {
			name = file.getOriginalFilename();
			// 空文件检查
			if (FileUtils.isEmptyFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有空文件");
				ResponseUtil.renderText(response,
						JSONObject.fromObject(resultMap).toString());
				return;
			}
			// 待上传文件有重复文件检查
			if (FileUtils.isTheSameNameFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有重复文件2");
				ResponseUtil.renderText(response,
						JSONObject.fromObject(resultMap).toString());
				return;
			}
			try {
				// 检查待上传的文件在已经上传的文件中是否存在
				List<EduProjectTrainingMaterials> eptms = Collections
						.emptyList();
				eptms = orgService.queryTrainingMaterialsByPid(projectId);
				if(eptms.isEmpty()){
					//第一次，之前没有上传过文件
				}else{
					for (EduProjectTrainingMaterials e : eptms) {
						if (e.getName().equals(name)) {
							resultMap.put("success", false);
							resultMap.put("info", "您已经上传过该文件");
							ResponseUtil.renderText(response, JSONObject
									.fromObject(resultMap).toString());
							return;
						}
					}
				}

				
				EduProjectTrainingMaterials eptm = new EduProjectTrainingMaterials();
				eptm.setType(type);
				eptm.setProjectId(projectId);
				eptm.setCreateBy(this.getRealName(request));
				eptm.setCreateDate(dateFormat.format(new Date()));
				eptm.setUpdateDate(dateFormat.format(new Date()));
				name = file.getOriginalFilename();
				System.out.println("fileName:" + eptm);
				FileUtils.writes(file, projectPath + savePath, name);
				savePath = savePath.replaceAll("\\\\", "/");
				eptm.setUrl(savePath);
				eptm.setName(name);
				orgService.saveTrainingMaterials(eptm);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resultMap.put("success", true);
		resultMap.put("info", "上传成功");
		ResponseUtil.renderText(response, JSONObject.fromObject(resultMap)
				.toString());
		return;

	}

	/**
	 * 实施机构培训材料删除
	 * 
	 * @return
	 */
	@RequestMapping("org/trainingMaterialsDelete.do")
	public void trainingMaterialsDelete(HttpServletRequest request,
			HttpServletResponse response, Integer id, String name,
			Integer type, Integer projectId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		String savePath = ApplicationProperties
				.getPropertyValue("upload_train_file")
				+ File.separator
				+ projectId
				+ File.separator
				+ getAccountId(request)
				+ File.separator;// 获取保存文件的路径
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("projectId", projectId);
		params.put("name", name);
		try {
			boolean isDeleteFile = FileUtils.deleteFile(projectPath + savePath
					+ name);
			boolean isDeleteName = orgService.delteTrainingMaterials(params);
			if (isDeleteFile && isDeleteName) {
				resultMap.put("success", true);
			}

		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}

	}

	/**
	 * 培训材料下载，这个其实可以重用,只是放到这里作为一类
	 * 
	 * @param request
	 * @param filePathName
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("org/downloadFile.do")
	@ResponseBody
	public void downloadFile(HttpServletRequest request, String filePathName,
			HttpServletResponse response) throws IOException {
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		FileUtils.downloadFile(projectPath + filePathName, response);
	}
}
