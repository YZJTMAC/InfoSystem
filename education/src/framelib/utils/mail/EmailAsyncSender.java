package framelib.utils.mail;

import java.util.List;

/**
 * ÏûÏ¢·â×°Àà(Òì²½·¢ËÍ)
 * 
 * @author jinzhu
 */
public class EmailAsyncSender {
	private MailConfig mailConfig;

	/**
	 * ·¢ËÍÓÊ¼þ
	 * 
	 * @param mailAddress
	 *            ÊÕ¼þÈË
	 * @param subject
	 *            ÓÊ¼þÖ÷Ìâ
	 * @param content
	 *            ÓÊ¼þÄÚÈÝ
	 */
	public void sendMail(String mailAddress, String subject, String content) {
		sendMail(mailAddress, subject, content, null);
	}

	/**
	 * ¸øÁÐ±íÖÐµÄÊÕ¼þÈËÈº·¢ËÍÓÊ¼þ
	 * 
	 * @param mailAddressList
	 *            ÊÕ¼þÈË
	 * @param subject
	 *            ÓÊ¼þÖ÷Ìâ
	 * @param content
	 *            ÓÊ¼þÄÚÈÝ
	 */
	public void sendMail(List mailAddressList, String subject, String content) {
		if (mailAddressList != null && mailAddressList.size() > 0) {
			for (int i = 0; i < mailAddressList.size(); i++) {
				if (mailAddressList.get(i) instanceof String) {
					sendMail((String) mailAddressList.get(i), subject, content,
							null);
				}
			}
		}
	}

	/**
	 * ¸øÁÐ±íÖÐµÄÊÕ¼þÈËÈº·¢ËÍÓÊ¼þ
	 * 
	 * @param mailAddressList
	 *            ÊÕ¼þÈË
	 * @param subject
	 *            ÓÊ¼þÖ÷Ìâ
	 * @param content
	 *            ÓÊ¼þÄÚÈÝ
	 * @param fileList
	 *            ÓÊ¼þ¸½¼þÁÐ±í
	 */
	public void sendMail(List mailAddressList, String subject, String content,
			List fileList) {
		if (mailAddressList != null && mailAddressList.size() > 0) {
			if (mailAddressList != null && mailAddressList.size() > 0) {
				for (int i = 0; i < mailAddressList.size(); i++) {
					if (mailAddressList.get(i) instanceof String) {
						sendMail((String) mailAddressList.get(i), subject,
								content, fileList);
					}
				}
			}
		}
	}

	/**
	 * ·¢ËÍÓÊ¼þ
	 * 
	 * @param mailAddress
	 *            ÊÕ¼þÈË
	 * @param subject
	 *            ÓÊ¼þÖ÷Ìâ
	 * @param content
	 *            ÓÊ¼þÄÚÈÝ
	 * @param fileList
	 *            ÓÊ¼þ¸½¼þÁÐ±í
	 */
	public void sendMail(String mailAddress, String subject, String content,
			List fileList) {
		// »ñÈ¡Ïà¹ØÓÊ¼þ²ÎÊý
		if (!"".equals(mailConfig.getFrom())
				&& !"".equals(mailConfig.getHost())
				&& !"".equals(mailConfig.getUserName())
				&& !"".equals(mailConfig.getPassword())
				&& !"".equals(mailAddress) && !"".equals(subject)
				&& !"".equals(content)) {
			SendMail sendMail = new SendMail();
			sendMail.setTo(mailAddress);
			sendMail.setSubject(subject);
			sendMail.setContent(content);
			sendMail.setFrom(mailConfig.getFrom());
			sendMail.setHost(mailConfig.getHost());
			sendMail.setUserName(mailConfig.getUserName());
			sendMail.setPassWord(mailConfig.getPassword());
			if (fileList != null && fileList.size() > 0) {
				for (int i = 0; i < fileList.size(); i++) {
					if (fileList.get(i) instanceof String) {
						sendMail.attachFile((String) fileList.get(i));
					}
				}
			}
			sendMail.setContentIsHtml(true);
			// µ÷ÓÃÏß³Ì£¬Òì²½·¢ËÍ
			new SendMailThread(sendMail).run();
		}
	}

	public EmailAsyncSender(MailConfig mailConfig) {
		this.mailConfig = mailConfig;
	}
}
