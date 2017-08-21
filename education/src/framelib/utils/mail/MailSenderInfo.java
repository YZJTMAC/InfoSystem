package framelib.utils.mail;

import java.util.Properties;

/**
 * 发送邮件需要使用的基本信息
 * @author kfq
 *
 */
public class MailSenderInfo {
	// 发送邮件的服务器的IP和端口    
    private String mailServerHost;    
    private String mailServerPort;    
    // 邮件发送者的地址    
    private String fromAddress;    
    // 登陆邮件发送服务器的用户名和密码    
    private String userName;    
    private String password;    
    // 是否需要身份验证    
    private boolean validate;
    
    public static final String NICK_NAME = "包谷网";
    
   
    /**   
     * 获得邮件会话属性   
     */    
   public Properties getProperties(){    
     Properties p = new Properties();    
     p.put("mail.smtp.host", this.mailServerHost);    
     p.put("mail.smtp.port", this.mailServerPort);    
     p.put("mail.smtp.auth", validate ? "true" : "false");    
     return p;    
   }    
   public String getMailServerHost() {    
     return mailServerHost;    
   }    
   public void setMailServerHost(String mailServerHost) {    
     this.mailServerHost = mailServerHost;    
   }   
   public String getMailServerPort() {    
     return mailServerPort;    
   }   
   public void setMailServerPort(String mailServerPort) {    
     this.mailServerPort = mailServerPort;    
   }   
   public boolean isValidate() {    
     return validate;    
   }   
   public void setValidate(boolean validate) {    
     this.validate = validate;    
   }   

   public String getFromAddress() {    
     return fromAddress;    
   }    
   public void setFromAddress(String fromAddress) {    
     this.fromAddress = fromAddress;    
   }   
   public String getPassword() {    
     return password;    
   }   
   public void setPassword(String password) {    
     this.password = password;    
   }   
 
   public String getUserName() {    
     return userName;    
   }   
   public void setUserName(String userName) {    
     this.userName = userName;    
   }   
   
}
