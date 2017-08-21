package project.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 系统管理
 * @author zhangBo
 *	@version 1.0
 *@Create_Date 2014年3月27日
 */

@Controller
@RequestMapping("/page")
public class PageController extends AbsController{
	private static final Logger log = Logger.getLogger(PageController.class);
	
	@RequestMapping("error/500.htm")
	public String toLoginPage() {
		return "error/500";
	}
}
