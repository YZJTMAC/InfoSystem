package project.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class CommonsMultipartResolverExt extends CommonsMultipartResolver {

	@Autowired
	private FileUploadListener progressListener;
	public void setFileUploadProgressListener(
			FileUploadListener progressListener) {

		this.progressListener = progressListener;

	}

	@Override
	@SuppressWarnings("unchecked")
	public MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {

		String encoding = determineEncoding(request);

		FileUpload fileUpload = prepareFileUpload(encoding);

		progressListener.setSession(request.getSession());

		fileUpload.setProgressListener(progressListener);

		try {

			List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);

			return parseFileItems(fileItems, encoding);

		}

		catch (FileUploadBase.SizeLimitExceededException ex) {
			
			throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
		}

		catch (FileUploadException ex) {

			throw new MultipartException("Could not parse multipart servlet request", ex);

		}
		
	}
	
}


//自定义异常拦截器,针对CommonsMultipartResolverExt异常捕获进行处理(Modify by 2016-02-24)
class ExceptionHandler implements HandlerExceptionResolver, Ordered {

	  private Log logger = LogFactory.getLog(this.getClass());

	  public int getOrder() {
	    return Integer.MIN_VALUE;
	  }
	  
	  Map<String, Object> result = new HashMap<String, Object>();

	  public ModelAndView resolveException(HttpServletRequest request,
	      HttpServletResponse response, Object handler, Exception ex) {
	    logger.info("ExceptionHandler#resolveException() start");
	    if(ex instanceof MaxUploadSizeExceededException) {
	    	result.put("msg", "-1");
	    	result.put("uploadSizeExceeded", "上传失败,上传文件大小不能超出30M !");
	    //spring 中对apache common组件中抛出的FileSizeLimitExceededException做了转换
	    } else if(ex instanceof MultipartException){ 
	    	result.put("msg", "-2");
	    	result.put("notParseRequest", "文件上传解析错误 !");
	    }
	    try {
	      ResponseUtil.renderText(response, JSONObject.fromObject(result));
	      return null;
	    } catch(Exception e) {
	      logger.error(e.getMessage(), e);
	    }
	    return null;
	  }
	  
	  
	}

//自定义异常处理(暂时没有处理 Modify by 2016-01-20)
class MyselfSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String viewName = determineViewName(ex, request);
		if (!"".equals(viewName) && viewName != null) {// JSP格式返回
			if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
					.getHeader("X-Requested-With") != null && request
					.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
				// 如果不是异步请求
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				return getModelAndView(viewName, ex, request);
			} else {// JSON格式返回
				try {
					PrintWriter writer = response.getWriter();
					writer.write(ex.getMessage());
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;

			}
		} else {
			return null;
		}
	}
}
