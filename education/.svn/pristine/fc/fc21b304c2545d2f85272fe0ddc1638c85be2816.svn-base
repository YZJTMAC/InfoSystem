package project.system.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.service.IEduProjectService;
import project.util.ApplicationProperties;
import framelib.controller.AbsController;

/**
 * 系统管理
 * @author 
 *	@version 
 */

@Controller
@RequestMapping("/dowload")
public class DowloadController extends AbsController{
	private static final Logger log = Logger.getLogger(DowloadController.class);
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	@RequestMapping(value = "/download.do")  
	 public void down(HttpServletRequest request,HttpServletResponse response,int proId,int index) throws IOException { 
	     response.setContentType("application/vnd.ms-excel"); 
	 	try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			if(dto.getProjectAttchement() != null && dto.getProjectAttchement().length()>0){
				String[] list=dto.getProjectAttchement().split(",");
				String[] list2=dto.getFileName().split(",");
					for (int i = 0; i < list.length; i++) {
		                if(index ==i){
		                	String fileName = list[i];
		                	String nowPath = ApplicationProperties.getPropertyValue("project_attchement_path") + fileName;
//		       			 String nowPath = request.getSession().getServletContext().getRealPath("/")+"\\"+"static"+"\\"+"projectAttchement"+"\\"+fileName;
		       			    String contextPath = request.getContextPath();// /BJSWT
		       			      File file = new File(nowPath); 
		       			     // 清空response 
		       			        response.reset(); 
		       			        // 设置response的Header 
		       			        response.addHeader("Content-Disposition", "attachment;filename="+new String(list2[i].getBytes("gbk"),"iso-8859-1"));  //转码之后下载的文件不会出现中文乱码
		       			        response.addHeader("Content-Length", "" + file.length()); 
		       			         
		       			     try{ 
		       			         //以流的形式下载文件 
		       			         InputStream fis = new BufferedInputStream(new FileInputStream(nowPath)); 
		       			         byte[] buffer = new byte[fis.available()]; 
		       			         fis.read(buffer); 
		       			         fis.close(); 
		       			          
		       			         OutputStream toClient = new BufferedOutputStream(response.getOutputStream()); 
		       			         toClient.write(buffer); 
		       			         toClient.flush(); 
		       			         toClient.close(); 
		       			     }catch(Exception e){ 
		       			         e.printStackTrace(); 
		       			     } 
		                	
		                }
		            
		            }
					 
					}else{
						String fileName =null;
					}
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	    
	 
	 } 
	
	
	@RequestMapping("error/500.htm")
	public String toLoginPage() {
		return "error/500";
	}
}
