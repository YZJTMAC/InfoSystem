package framelib.utils.mail;

public class SendMailThread implements Runnable {
	private SendMail sendMail;

	public SendMailThread(SendMail sendMail) {
		this.sendMail = sendMail;
	}

	public void run() {
		sendMail.send();
	}
}
