package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.app.config.AppConfig;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		JmsTemplate j=ac.getBean("jt",JmsTemplate.class);
		j.send("my-qu1", s->s.createTextMessage("How Are You?"));
	}
}
