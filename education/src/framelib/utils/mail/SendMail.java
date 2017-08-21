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
 * Email����(֧�ֶ������)
 * 
 * @author jinzhu
 * 
 */
public class SendMail {

	String to = "";// �ռ���

	Map toMap = new HashMap();

	String from = "";// ������

	String host = "";// smtp����

	String userName = "";

	String passWord = "";

	String fileName = "";// �����ļ���

	String subject = "";// �ʼ�����

	String content = "";// �ʼ�����

	boolean contentIsHtml = true;

	Vector file = new Vector();// �����ļ�����

	/**
	 * <br>
	 * ����˵���������ʼ���������ַ <br>
	 * ���������String host �ʼ���������ַ���� <br>
	 * �������ͣ�
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * <br>
	 * ����˵�������õ�¼������У������ <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setPassWord(String password) {
		this.passWord = password;
	}

	/**
	 * <br>
	 * ����˵�������õ�¼������У���û� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * <br>
	 * ����˵���������ʼ�����Ŀ������ <br>
	 * ��������� <br>
	 * �������ͣ�
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

	// ��֤��ͨ�ʼ���ʽ
	private boolean checkMailFormat(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9_-]+@(\\w+.)+[a-z]{2,3}");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// ��֤�������ʼ���ʽ�磺=?UTF-8?B?6YeR56u5?=<jinzhu@liebo.com>�� ����<jinzhu@liebo.com>
	private boolean checkMailFormatWithName(String email) {
		Pattern pattern = Pattern
				.compile("(.*?)<[a-zA-Z0-9_-]+@(\\w+.)+[a-z]{2,3}>");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// =?UTF-8?B?6YeR56u5?=<jinzhu@liebo.com>����jinzhu@liebo.com
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
	 * ����˵���������ʼ�����Դ���� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * <br>
	 * ����˵���������ʼ����� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <br>
	 * ����˵���������ʼ����� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public void setContentIsHtml(boolean contentIsHtml) {
		this.contentIsHtml = contentIsHtml;
	}

	/**
	 * <br>
	 * ����˵����������ת��Ϊ���� <br>
	 * ���������String strText <br>
	 * �������ͣ�
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
	 * ����˵�����������������Ӹ��� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void attachFile(String fname) {
		file.addElement(fname);
	}

	/**
	 * <br>
	 * ����˵���������ʼ� <br>
	 * ��������� <br>
	 * �������ͣ�boolean �ɹ�Ϊtrue����֮Ϊfalse
	 */
	public boolean send() {
		// ����mail session
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			Session session = Session.getInstance(props, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});
			// ����MimeMessage ���趨������ֵ
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

			// ����Multipart
			Multipart mp = new MimeMultipart();

			// ��Multipart�������
			MimeBodyPart mbpContent = new MimeBodyPart();
			if (this.contentIsHtml) {
				// ��ʾΪHTML��ʽ
				mbpContent.setDataHandler(new DataHandler(content,
						"text/html;charset=gb2312"));
			} else {
				// ��ʾΪ��ͨ�ı���ʽ
				mbpContent.setText(content);
			}

			// ��MimeMessage��ӣ�Multipart�������ģ�
			mp.addBodyPart(mbpContent);

			// ��Multipart��Ӹ���
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
				// ��MimeMessage��ӣ�Multipart��������
				mp.addBodyPart(mbpFile);
			}

			// ��Multipart���MimeMessage
			msg.setContent(mp);
			msg.setSentDate(new Date());
			// �����ʼ�
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
