package project.util;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import project.fileupload.pojo.FileUpload;
@Component
public class FileUploadListener implements ProgressListener{

	private HttpSession session;

	public void setSession(HttpSession session) {

		this.session = session;

		FileUpload status = new FileUpload();

		session.setAttribute("status", status);
	}


	// 为文件上传进度使用
	public void update(long pBytesRead, long pContentLength, int pItems) {
		// TODO Auto-generated method stub
		FileUpload status = (FileUpload) session.getAttribute("status");

		status.setpBytesRead(pBytesRead);

		status.setpContentLength(pContentLength);

		status.setpItems(pItems);
		
		session.setAttribute("progress", (double)pBytesRead/pContentLength * 100);

		}
	}
