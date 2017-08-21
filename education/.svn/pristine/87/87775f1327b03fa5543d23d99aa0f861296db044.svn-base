package framelib.utils.mail;

import java.util.Locale;

import framelib.utils.PropReader;

/**
 * 
 * @author jinzhu
 * @date 2012-2-04
 */
public class MailConfig {

	private String userName;

	private String password;

	private String from;

	private String host;

	public void init(String configFile) {
		try {
			PropReader pu = new PropReader(configFile,new Locale("zh", "CN"));
			userName = pu.getString("mail.username", "");
			password = pu.getString("mail.password", "");
			from = pu.getString("mail.from", "");
			host = pu.getString("mail.smtp.host", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
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
