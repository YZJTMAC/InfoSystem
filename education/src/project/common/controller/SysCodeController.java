package project.common.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.common.Common;

import framelib.controller.AbsController;

/**
 * 前端获取静态常量控制器
 * @author dengguo
 *
 */
@Controller
@RequestMapping("/sys/config")
public class SysCodeController extends AbsController {



	/**
	 * 查询代码值列表
	 * 
	 * @param codeId : 代码标识
	 */
	@RequestMapping("/qryCodes.do")
	public void qryCodes(HttpServletRequest request,
			HttpServletResponse response, String codeId) {
		try {
			objectToJsonForResponse(response, Common.sysCodeMap.get(codeId));
			Map temp = Common.sysCodeMap;
			System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){ 
		//System.out.println(sysCodeMap.get("BAOZHUANG"));
	}
}
