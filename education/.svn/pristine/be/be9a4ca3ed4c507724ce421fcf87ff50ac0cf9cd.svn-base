package project.util.certificate;

import java.awt.Dimension;
import java.awt.Insets;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

public class ConverterPDF {
	protected static Dimension format = PD4Constants.A4;

	protected static boolean landscapeValue = false;

	protected static int topValue = 0;//生成文件的边距  初始值设置为10

	protected static int leftValue = 0;

	protected static int rightValue = 0;

	protected static int bottomValue = 0;

	protected static String unitsValue = "mm";

	protected static int userSpaceWidth = 920;//调整证书宽度

	public static void runConverter(List<URL> urls, String fileName,String projectId,
			HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		if (urls.size() > 0) {
			PD4ML pd4ml = new PD4ML();
			pd4ml.setPageSize(new java.awt.Dimension(920,690));
			pd4ml.enableImgSplit(true);
			//必须设置字体
			pd4ml.useTTF("java:fonts", true);//处理字体
			pd4ml.clearCache();
			pd4ml.enableDebugInfo();
			/*try {
				pd4ml.setPageSize(landscapeValue ? pd4ml.changePageOrientation(format) : format);
			} catch (Exception e) {
				e.printStackTrace();
			}*/

			if (unitsValue.equals("mm")) {
				pd4ml.setPageInsetsMM(new Insets(topValue, leftValue,bottomValue, rightValue));
			} else {
				pd4ml.setPageInsets(new Insets(topValue, leftValue,bottomValue, rightValue));
			}

			pd4ml.setHtmlWidth(userSpaceWidth);

			//URL[] printUrls = new URL[urls.size()];
			/*for (int i=0;i<urls.size();i++) {
				printUrls[i] = (URL) urls.get(i);	
				pd4ml.render(printUrls[i], ba);
			}*/
			URL url = (URL)urls.get(0);
			pd4ml.render(url, ba);
		}
			//pd4ml.render(printUrls, ba);
			
			if(fileName.lastIndexOf(".pdf")==-1)
				fileName = fileName + ".pdf";
			try {
				response.setHeader("Content-disposition","attachment; filename="+ new String(fileName.getBytes("gb2312"),"iso8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/pdf;charset=UTF-8");
			response.setContentLength(ba.size());
			try {
				OutputStream out = response.getOutputStream();
				ba.writeTo(out);
				out.flush();
				out.close();
				ba.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}