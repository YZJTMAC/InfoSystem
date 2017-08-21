package framelib.mq;

import org.springframework.jms.core.JmsTemplate;

/**
 * Title:SpringJmsProducer
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class SpringJmsProducer {
	
	private JmsTemplate jmsTemplate;

	public void send(String message) {

		jmsTemplate.convertAndSend(message);

	}


	public void send(Object obj) {
		jmsTemplate.convertAndSend(obj);
	}

	public JmsTemplate getJmsTemplate() {
		
		return jmsTemplate;
		
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		
		this.jmsTemplate = jmsTemplate;
		
	}
}
