package project.util.certificate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import project.furtheredu.certificate.pojo.EduDiploma;
import project.util.FileUtil;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CertificateImageBuild {

	//根据模板生成对应学员的证书图片,暂时定义为jpg格式
	public static String loadCertificateImage(String resouceImage, String desImage,EduDiploma pojo, String teacherId) {
		String path = "";
		try {			
			//resouceImage使用模板原始图片
			URL url = new URL(resouceImage);

			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[10240];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			File file = new File(desImage+"/certificate"+"/project_"+pojo.getProjectId());
			//File file =new File(destPath);    
			if (!file.exists() && !file.isDirectory()) {
				file.mkdirs();
			}
			if(teacherId != null){
				if("2".equals(pojo.getType())){
					path = file.getPath() + "/" +pojo.getProjectId()+"_"+teacherId +"_project.jpg";	
				}else if(("3".equals(pojo.getType()))){
					path = file.getPath() + "/" +pojo.getProjectId()+"_"+teacherId +"_period.jpg";	
				}
						
			}else{
				if("2".equals(pojo.getType())){
					path = file.getPath() + "/" +pojo.getProjectId()+"_"+ "projectCertificate.jpg";	
				}else if(("3".equals(pojo.getType()))){
					path = file.getPath() + "/" +pojo.getProjectId()+"_"+ "periodCertificate.jpg";	
				}
						
			}
			OutputStream os = new FileOutputStream(path);

			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	//绘制图像(学员姓名,证书编号,证书二维码)
	public static void pressText(String pressText, String newImg,String targetImg, EduDiploma pojo) {
		try {
			File file = new File(targetImg);
			Image src = ImageIO.read(file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			Color color = new Color(0,0,0);
			g.setColor(color);
			g.setFont(new Font(pojo.getTeacherFontStyle(), Font.BOLD, pojo.getTeacherFontSize()));
			System.out.println(pressText);
			if(pressText.length()==2)
			{
				pressText="    "+pressText;
			}
			if(pressText.length()==3)
			{
				pressText="  "+pressText;
			}
			g.drawString(pressText, pojo.getTeacherRight(), pojo.getTeacherTop());
			//绘制证书编号字体
			g.setFont(new Font(pojo.getCertificateCodeFontStyle(), Font.BOLD, pojo.getCertificateCodeFontSize()));
			String filePath = "";
			//设置绘制二维码的路径(学时证书和项目证书)
				if("2".equals(pojo.getType())){
					if(pojo.getProjectCertificateUrl() != null){
						//使用实时生成的学员二维码路径
						g.drawString(pojo.getProjectCertificateCode(), pojo.getCertificateCodeRight(), pojo.getCertificateCodeTop());
						filePath = targetImg.substring(0,targetImg.indexOf(pojo.getProjectCertificateUrl()))+pojo.getQrcodeUrl();
					}else{
						//如果是设置证书,使用默认生成的二维码
						g.drawString(pojo.getProjectCode(), pojo.getCertificateCodeRight(), pojo.getCertificateCodeTop());
						filePath = newImg.substring(0, targetImg.indexOf(pojo.getProjectId()+"_"+ "projectCertificate.jpg")) +"/"+pojo.getProjectId() + "_QRCode.jpg";
					}
				}else if(("3".equals(pojo.getType()))){
					if(pojo.getPeriodCertificateUrl() != null){
						g.drawString(pojo.getPeriodCertificateCode(), pojo.getCertificateCodeRight(), pojo.getCertificateCodeTop());
						filePath = targetImg.substring(0,targetImg.indexOf(pojo.getPeriodCertificateUrl()))+pojo.getQrcodeUrl();
					}else{
						g.drawString(pojo.getProjectCode(), pojo.getCertificateCodeRight(), pojo.getCertificateCodeTop());
						filePath = newImg.substring(0, targetImg.indexOf(pojo.getProjectId()+"_"+ "periodCertificate.jpg")) +"/"+pojo.getProjectId() + "_QRCode.jpg";
					}
				}
			
			BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath)); 
			//是否绘制二维码图片
			if("1".equals(pojo.getQrcode())){
				g.drawImage(bufferedImage, pojo.getQrcodeRight(), pojo.getQrcodeTop(), null); 
			}
			
			g.dispose();
			FileOutputStream out = new FileOutputStream(newImg);
			ImageIO.write(image, "jpg", out);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
			System.out.println("image press success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
