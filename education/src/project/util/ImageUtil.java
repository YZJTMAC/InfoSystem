package project.util;

import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;



public class ImageUtil {

public static void main(String arg[])
{
     String filePath = "C:/Users/Administrator/Desktop/backgrounrd.jpg"; // 图片的位置

     int height=690;
     int width=920;
     Icon icon = null;
     try
     {
    	 //getFixedIcon(filePath,width,height);
     }
     catch(Exception e)
     {
      System.out.println("exception : " +e);
     }
     System.out.println(" ### " +icon); //生成新图片的位置；
}

/**
 * 按宽的比例更改图片的大小
 * @param filePath 图片路径
 * @param width 需要改变图片的宽度
 * @return
 * @throws Exception
 */
public static Icon getRatioWidth(String filePath, int width) throws Exception{
	
	File f = new File(filePath); 
	
	BufferedImage bi = ImageIO.read(f);
	
	double wRatio = (new Integer(width)).doubleValue() / bi.getWidth(); //宽度的比例
	
	int height = (int)(wRatio * bi.getHeight());  //图片转换后的高度
	
	Image image = bi.getScaledInstance(width,height,Image.SCALE_SMOOTH); //设置图像的缩放大小
	
	AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(wRatio,wRatio),null);   //设置图像的缩放比例
	
	image = op.filter(bi,null);
	
	int lastLength = filePath.lastIndexOf(".");   
	String subFilePath = filePath.substring(0,lastLength);  //得到图片输出路径
    String fileType = filePath.substring(lastLength);  //图片类型
    File zoomFile = new File(subFilePath +"_"+ width +"_" + height + fileType);
    
    Icon ret = null;
	try
    {
     ImageIO.write((BufferedImage)image, "jpg", zoomFile); 
     ret = new ImageIcon(zoomFile.getPath()); 
    }
    catch (Exception e) 
    {
     e.printStackTrace();
    } 
    
   return ret;
}
/**
 * 按高的比例更改图片大小
 * @param filePath 图片路径
 * @param height 需要改变图片的高度
 * @return
 * @throws Exception
 */
public static Icon getRatioHeight(String filePath, int height) throws Exception{
	File f = new File(filePath); 
	
	BufferedImage bi = ImageIO.read(f);
	
	double hRatio = (new Integer(height)).doubleValue() / bi.getHeight(); //高度的比例
	
	int width = (int)(hRatio * bi.getWidth());  //图片转换后的高度
	
	Image image = bi.getScaledInstance(width,height,Image.SCALE_SMOOTH); //设置图像的缩放大小
	
	AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(hRatio,hRatio),null);   //设置图像的缩放比例
	
	image = op.filter(bi,null);
	
	int lastLength = filePath.lastIndexOf(".");   
	String subFilePath = filePath.substring(0,lastLength);  //得到图片输出路径
    String fileType = filePath.substring(lastLength);  //图片类型
    File zoomFile = new File(subFilePath +"_"+ width +"_" + height + fileType);
    
    Icon ret = null;
	try
    {
     ImageIO.write((BufferedImage)image, "jpg", zoomFile); 
     ret = new ImageIcon(zoomFile.getPath()); 
    }
    catch (Exception e) 
    {
     e.printStackTrace();
    } 
    
   return ret;
}

/**
 * 按输入的任意宽高改变图片的大小
 * @param filePath
 * @param width
 * @param height
 * @return
 * @throws Exception
 */
public static String getFixedIcon(String projectPath,String filePath, String newFileName,int width, int height) throws Exception{
	
	String fullPath = projectPath+filePath;
	File f = new File(fullPath); 
	
	BufferedImage bi = ImageIO.read(f);
	
	double wRatio = (new Integer(width)).doubleValue() / bi.getWidth(); //宽度的比例
	
	double hRatio = (new Integer(height)).doubleValue() / bi.getHeight(); //高度的比例
	
	Image image = bi.getScaledInstance(width,height,Image.SCALE_SMOOTH); //设置图像的缩放大小
	
	AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(wRatio,hRatio),null);   //设置图像的缩放比例
	
	image = op.filter(bi,null);
	
	int lastLength = filePath.lastIndexOf(".");   
	String subFilePath = filePath.substring(0,lastLength);  //得到图片输出路径
    String fileType = filePath.substring(lastLength);  //图片类型
    String  productFileName = newFileName +"_"+ width +"_" + height;
    File zoomFile = new File(projectPath + subFilePath +"_"+ width +"_" + height + fileType);
    
    Icon ret = null;
	try
    {
     ImageIO.write((BufferedImage)image, "jpg", zoomFile); 
     ret = new ImageIcon(zoomFile.getPath()); 
    }
    catch (Exception e) 
    {
     e.printStackTrace();
    } 
    
   return productFileName;
}

}
