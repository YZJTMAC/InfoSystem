package framelib.utils.mail;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

public class MailInfo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    // 邮件主题    
    private String subject;    
    // 邮件接收者的地址    
    private String toAddress;    
    // 邮件的文本内容    
    private String content;    
    // 邮件附件的地址
    private List<URL> urls;
    //邮件附件字节流
    private List<byte[]> attachFileListByte;
    
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    public List<byte[]> getAttachFileListByte() {
        return attachFileListByte;
    }
    public void setAttachFileListByte(List<byte[]> attachFileListByte) {
        this.attachFileListByte = attachFileListByte;
    }
    public List<URL> getUrls() {
        return urls;
    }
    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }
    
}
