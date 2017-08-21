package framelib.utils.mail;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import framelib.common.Common;
import framelib.utils.StringUtil;

//import com.sun.istack.ByteArrayDataSource;



/**
 * 简单邮件（不带附件的邮件）发送器
 *
 */
public class SimpleMailSender {
	
	    /**   
	      * 以HTML格式发送邮件   
	      * @param mailInfo 待发送的邮件信息   
	      */    
	    public static boolean sendHtmlMail(MailInfo mailInfo){    
	      // 判断是否需要身份认证    
	     /* MyAuthenticator authenticator = null;   
	      Properties pro = Common.EMAIL_SENDER_INFO.getProperties();   
	      //如果需要身份认证，则创建一个密码验证器     
	      if (Common.EMAIL_SENDER_INFO.isValidate()) {    
	        authenticator = new MyAuthenticator(Common.EMAIL_SENDER_INFO.getUserName(), Common.EMAIL_SENDER_INFO.getPassword());   
	      }    
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session    
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
	      try {    
	      // 根据session创建一个邮件消息    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // 创建邮件发送者地址    
	      Address from = new InternetAddress(Common.EMAIL_SENDER_INFO.getFromAddress());    
	      // 设置邮件消息的发送者    
	        String nick=StringUtil.BLANK;  
            try {  
                nick=javax.mail.internet.MimeUtility.encodeText(MailSenderInfo.NICK_NAME);  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }   
            mailMessage.setFrom(new InternetAddress(nick+"<"+from+">"));    
	      
	      /*************   可变内容    ******************/
	      // 创建邮件的接收者地址，并设置到邮件消息中    
	   /*   Address to = new InternetAddress(mailInfo.getToAddress());    
	      // Message.RecipientType.TO属性表示接收者的类型为TO    
	      mailMessage.setRecipient(Message.RecipientType.TO,to);    
	      // 设置邮件消息的主题    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      // 设置邮件消息发送的时间    
	      mailMessage.setSentDate(new Date());    
	      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
	      MimeMultipart mainPart = new MimeMultipart();    
	      // 创建一个包含HTML内容的MimeBodyPart    
	      BodyPart mbp = new MimeBodyPart();    
	      // 设置HTML内容    
	      mbp.setContent(mailInfo.getContent(), "text/html; charset=utf-8");    
	      //to do find
	      mainPart.setSubType("related");
	      mainPart.addBodyPart(mbp);    
	      // 将MiniMultipart对象设置为邮件内容 
	      mailMessage.setContent(mainPart); 
	      //添加附件
	      List<byte[]> fileList = mailInfo.getAttachFileListByte();
	      List<URL> urls = mailInfo.getUrls();
	      if(fileList!=null){
	          for(int i=0; i<fileList.size(); i++){
	              MimeBodyPart mimeBodyPart = new MimeBodyPart();
	              DataSource ds = new ByteArrayDataSource(fileList.get(i), "application/octet-stream");
	              DataHandler dataHandler = new DataHandler(ds);
	              mimeBodyPart.setDataHandler(dataHandler);
	              mimeBodyPart.setHeader("Content-ID", "FILE" + i);
	              mainPart.addBodyPart(mimeBodyPart);
	          }
	      }else if(urls!=null){
	          for(int i=0; i<urls.size(); i++){
                  MimeBodyPart mimeBodyPart = new MimeBodyPart();
                  DataSource ds = new URLDataSource(urls.get(i));
                  DataHandler dataHandler = new DataHandler(ds);
                  mimeBodyPart.setDataHandler(dataHandler);
                  mimeBodyPart.setHeader("Content-ID", "FILE" + i);
                  mainPart.addBodyPart(mimeBodyPart);
              }
	      }
	      //保存
	      mailMessage.saveChanges();
	      // 发送邮件    
	      Transport.send(mailMessage);   */ 
	      return true;    
	      /*} catch (Exception ex) {    
	          ex.printStackTrace();    
	          return false;    
	      }    */
	    }    
}
