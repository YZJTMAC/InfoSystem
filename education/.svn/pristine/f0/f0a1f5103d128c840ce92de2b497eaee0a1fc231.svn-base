package framelib.utils.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * Email发送(支持多个附件)
 * 
 * @author jinzhu
 * 
 */
public class SendMail {

	String to = "";// 收件人

	Map toMap = new HashMap();

	String from = "";// 发件人

	String host = "";// smtp主机

	String userName = "";

	String passWord = "";

	String fileName = "";// 附件文件名

	String subject = "";// 邮件主题

	String content = "";// 邮件正文

	boolean contentIsHtml = true;

	Vector file = new Vector();// 附件文件集合

	/**
	 * <br>
	 * 方法说明：设置邮件服务器地址 <br>
	 * 输入参数：String host 邮件服务器地址名称 <br>
	 * 返回类型：
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * <br>
	 * 方法说明：设置登录服务器校验密码 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setPassWord(String password) {
		this.passWord = password;
	}

	/**
	 * <br>
	 * 方法说明：设置登录服务器校验用户 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件发送目的邮箱 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setTo(String to) {
		if (to != null && !"".equals(to)) {
			String toArr[] = to.split(";");
			if (toArr != null && toArr.length > 0) {
				for (int i = 0; i < toArr.length; i++) {
					if (checkMailFormat(toArr[i])) {
						toMap.put(toArr[i], toArr[i]);
					} else if (checkMailFormatWithName(toArr[i])) {
						toMap.put(getMailWithName(toArr[i]), toArr[i]);
					}
				}
			}
		}
		this.to = to;
	}

	// 验证普通邮件格式
	private boolean checkMailFormat(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9_-]+@(\\w+.)+[a-z]{2,3}");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// 验证带姓名邮件格式如：=?UTF-8?B?6YeR56u5?=<jinzhu@liebo.com>或 金竹<jinzhu@liebo.com>
	private boolean checkMailFormatWithName(String email) {
		Pattern pattern = Pattern
				.compile("(.*?)<[a-zA-Z0-9_-]+@(\\w+.)+[a-z]{2,3}>");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// =?UTF-8?B?6YeR56u5?=<jinzhu@liebo.com>返回jinzhu@liebo.com
	private String getMailWithName(String content) {
		Pattern pattern = Pattern.compile("<(.+?)>");
		Matcher m = pattern.matcher(content);
		if (m.find()) {
			return m.group(1).trim();
		} else {
			return "";
		}
	}

	/**
	 * <br>
	 * 方法说明：设置邮件发送源邮箱 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件主题 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件内容 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public void setContentIsHtml(boolean contentIsHtml) {
		this.contentIsHtml = contentIsHtml;
	}

	/**
	 * <br>
	 * 方法说明：把主题转换为中文 <br>
	 * 输入参数：String strText <br>
	 * 返回类型：
	 */
	public String transferChinese(String strText) {
		try {
			strText = MimeUtility.encodeText(new String(strText.getBytes(),
					"GB2312"), "GB2312", "B");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strText;
	}

	/**
	 * <br>
	 * 方法说明：往附件组合中添加附件 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void attachFile(String fname) {
		file.addElement(fname);
	}

	/**
	 * <br>
	 * 方法说明：发送邮件 <br>
	 * 输入参数： <br>
	 * 返回类型：boolean 成功为true，反之为false
	 */
	public boolean send() {
		// 构造mail session
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			Session session = Session.getInstance(props, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});
			// 构造MimeMessage 并设定基本的值
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));

			StringBuffer toStringBuffer = new StringBuffer();
			if (toMap != null) {
				for (Iterator it = toMap.values().iterator(); it.hasNext();) {
					toStringBuffer.append((String) it.next());
					if (it.hasNext()) {
						toStringBuffer.append(",");
					}
				}
			}
			InternetAddress[] address = InternetAddress.parse(toStringBuffer
					.toString());
			msg.setRecipients(Message.RecipientType.TO, address);
			subject = transferChinese(subject);
			msg.setSubject(subject);

			// 构造Multipart
			Multipart mp = new MimeMultipart();

			// 向Multipart添加正文
			MimeBodyPart mbpContent = new MimeBodyPart();
			if (this.contentIsHtml) {
				// 表示为HTML格式
				mbpContent.setDataHandler(new DataHandler(content,
						"text/html;charset=gb2312"));
			} else {
				// 表示为普通文本格式
				mbpContent.setText(content);
			}

			// 向MimeMessage添加（Multipart代表正文）
			mp.addBodyPart(mbpContent);

			// 向Multipart添加附件
			Enumeration efile = file.elements();
			while (efile.hasMoreElements()) {
				MimeBodyPart mbpFile = new MimeBodyPart();
				fileName = efile.nextElement().toString();
				FileDataSource fds = new FileDataSource(fileName);
				mbpFile.setDataHandler(new DataHandler(fds));
				try {
					mbpFile.setFileName(MimeUtility.encodeText(fds.getName(),
							"GBK", null));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				// 向MimeMessage添加（Multipart代表附件）
				mp.addBodyPart(mbpFile);
			}

			// 向Multipart添加MimeMessage
			msg.setContent(mp);
			msg.setSentDate(new Date());
			// 发送邮件
			Transport.send(msg);
		} catch (SendFailedException sfe) {
			Pattern pattern = Pattern.compile("<(.+?)>");
			Matcher m = pattern.matcher(sfe.toString());
			while (m.find()) {
				String e = m.group(1).trim();
				toMap.remove(e);
			}
			if (toMap.size() > 0) {
				return this.send();
			} else {
				return false;
			}
		} catch (MessagingException me) {
			me.printStackTrace();
			return false;
		} finally {
			if (file != null && file.size() > 0) {
				file.removeAllElements();
			}
		}
		return true;
	}
}
