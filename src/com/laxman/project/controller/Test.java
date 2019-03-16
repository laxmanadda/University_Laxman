package com.laxman.project.controller;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;


public class Test {	
	public void send_mail() {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		MailMail m= (MailMail) context.getBean("mailMail");
		
		String sender="addalaxman@gmail.com";//write here your id
		String receiver="laxmanadda26@gmail.com";//write here receiver id
		m.sendMail(sender,receiver,"hi","welcome");
		
		System.out.println("success");
	}
}
