package com.kunj.kunjapp.utility;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Mailsender {
	
	@Autowired
	JavaMailSenderImpl mailSenderImpl ;
	
	public void sendEmail(){
		
		String []bccs= {"sahanak.xworkz@gmail.com","manasap.xworkz@gmail.com","ajjuhospet96@gmail.com","unstoppabledk2d@gmail.com","veeresh.xworkz@gmail.com"};
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xworkzodc01@gmail.com");
		message.setTo("varalakshmi.xworkz@gmail.com");
		message.setCc("manojkumarv39@gmail.com");
		message.setBcc(bccs);
		message.setSubject("demo java mailsender");
		message.setText("Hello all \n Nikunj this side \n This is demo mail for java mailsender \n thanks and regaeds \n Xworkz");
				
		mailSenderImpl.send(message);
		
	}
}