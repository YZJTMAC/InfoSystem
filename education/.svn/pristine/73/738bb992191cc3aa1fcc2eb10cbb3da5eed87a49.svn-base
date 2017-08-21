package framelib.mq;

import org.springframework.jms.core.JmsTemplate;


/**
 * Title:SpringJmsConsumer
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class SpringJmsConsumer {
	
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {

		return jmsTemplate;

	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {

		this.jmsTemplate = jmsTemplate;

	}

	public Object receive() {

		return jmsTemplate.receiveAndConvert();

	}

}
