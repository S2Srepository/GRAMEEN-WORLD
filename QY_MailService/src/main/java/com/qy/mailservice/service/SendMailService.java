package com.qy.mailservice.service;

import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.qy.mailservice.controller.MailController;
import com.qy.mailservice.dao.EmailTemplateDao;
import com.qy.mailservice.entity.EmailTemplate;

@Service
public class SendMailService {

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	EmailTemplateDao dao;
	
	
	private static Logger logger = LoggerFactory.getLogger(MailController.class);
	
	public void sendMail(String from, String[] to, String subject, String msg, String tempCode) throws MessagingException {

	    // Creating message 
		MimeMessage mimeMsg = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
	    EmailTemplate emailTemplate = dao.findByTemplateCode(tempCode);
	    helper.setFrom(from);
	    helper.setTo(to);
	    helper.setSubject(emailTemplate.getSubject());
	    
	    Template t = Velocity.getTemplate("src/main/resources/templates/"+emailTemplate.getTemplateName());
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("username", "World");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        
        helper.setText(writer.toString());
        /* show the World */
		/*
		 * Iterator it = attachments.iterator();
		 * 
		 * while (it.hasNext()) { FileSystemResource file = new FileSystemResource(new
		 * File((String) it.next())); helper.addAttachment(file.getFilename(), file); }
		 */
	    // Sending message  
	    sender.send(mimeMsg);
	    logger.info("mail sent successfully");
	}

}

