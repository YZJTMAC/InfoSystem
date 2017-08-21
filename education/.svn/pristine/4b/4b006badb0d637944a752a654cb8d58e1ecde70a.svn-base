package project.util;

import java.util.Date;
import javax.activation.DataSource;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

public class MailSender
{
    private static Logger log = Logger.getLogger(MailSender.class);
    
    private final static boolean DEBUG = false;
    
    private String from = "Teacheredu";
    
    private String[] to;
    
    private String[] cc;
    
    private String subject;
    
    private String msg;
    
    private DataSource[] dataSources;
    
    
    private String smtpHost = ApplicationProperties.getPropertyValue("smtpHost");
    /*  "smtp.163.com";*/
    
    private String smtpUser = ApplicationProperties.getPropertyValue("smtpUser");
    /*"jiabo957@163.com";*/
    
    private String smtpPwd =ApplicationProperties.getPropertyValue("smtpPwd");
    /*"";*/
    
    public MailSender(String from, String[] to, String[] cc, String subject, String msg, DataSource[] dataSources)
    {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.msg = msg;
        this.dataSources = dataSources;
    }
    
    public boolean send()
    {
        try
        {
            if(to == null || to.length == 0 || msg == null)
            {
                return false;
            }
            HtmlEmail email = new HtmlEmail();
            
            email.addHeader("X-mailer", "Ltmis 6, 10, 201, 20 [cn]");
            
            email.setHostName(smtpHost);
            email.setAuthentication(smtpUser, smtpPwd);
            email.setDebug(DEBUG);
            email.setCharset("gb2312");
            
            email.setFrom(smtpUser, NullUtil.null2Blank(this.from, smtpUser));
            
            for(int i = 0; i < to.length; i++)
            {
                if(to[i] != null && !"".equals(to[i].trim()))
                {
                    email.addTo(to[i].trim());
                }
            }
            
            for(int i = 0; cc != null && i < cc.length; i++)
            {
                if(cc[i] != null && !"".equals(cc[i].trim()))
                {
                    email.addCc(cc[i].trim());
                }
            }
            email.setSubject(subject);
            email.setHtmlMsg(this.msg);
            
            if(dataSources != null)
            {
                for(int i = 0; i < dataSources.length; i++)
                {
                    email.attach(dataSources[i], new String(dataSources[i].getName().getBytes("gbk"), "ISO-8859-1"), null);
                }
            }
            // email.setCharset("");
            email.setSentDate(new Date());
            
            email.setSocketConnectionTimeout(1000*60);
            email.setSocketTimeout(1000*60);
            
            email.send();
            log.info("发送邮件给：" + to[0] + "成功");
            return true;
        }
        catch(Throwable e)
        {
            log.error("邮件发送出错", e);
            return false;
        }
    }
    
    /**
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String[] aa = new String[]{"sss", "ss1"};
        HtmlEmail email = new HtmlEmail();
        String[] to={"441258671@qq.com"};
        String[] cc=null;
        MailSender ms=new MailSender("jiabo", to, cc, "aaaaaa", "fdfd", null);
        ms.send();
        System.out.println(aa);
        
    }
    
    public String getSmtpPwd()
    {
        return smtpPwd;
    }
    
    public void setSmtpPwd(String password)
    {
        this.smtpPwd = password;
    }
    
    public String getSmtpUser()
    {
        return smtpUser;
    }
    
    public void setSmtpUser(String userName)
    {
        this.smtpUser = userName;
    }
    
    public String getSmtpHost()
    {
        return smtpHost;
    }
    
    public void setSmtpHost(String hostName)
    {
        this.smtpHost = hostName;
    }
    
}
