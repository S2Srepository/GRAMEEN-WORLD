package com.qy.mailservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qy.mailservice.model.SendMailRequest;
import com.qy.mailservice.service.SendMailService;

@RestController
public class MailController {
	
	private static Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Value("${spring.mail.username}")
	private String username;
	@Autowired
	SendMailService sendmailservice;
	
	
	@PostMapping(value="/sendMail")
	public String SendMail(@RequestBody SendMailRequest sendMail) throws javax.mail.MessagingException
	{
		logger.info("Body in sendMail method" +sendMail);
		 
		   sendmailservice.sendMail(username,sendMail.getRecipientMail(),sendMail.getSubject(),sendMail.getMessage(), sendMail.getTemplateCode());
		   
		   
		return "success";
	}




}
