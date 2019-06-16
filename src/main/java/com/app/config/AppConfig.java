package com.app.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan("com.app")
@EnableJms
public class AppConfig {
	@Bean
	public ActiveMQConnectionFactory cf() {
		ActiveMQConnectionFactory c= new ActiveMQConnectionFactory();
		c.setBrokerURL("tcp://localhost:61616");
		return c;
	}
	@Bean
	public JmsTemplate jt() {
		JmsTemplate j=new JmsTemplate();
		j.setConnectionFactory(cf());
		
		/* If you broadcast message to multiple consumer then setPubSubDomain(true)*/
		//j.setPubSubDomain(true);
		return j;
	}
}
