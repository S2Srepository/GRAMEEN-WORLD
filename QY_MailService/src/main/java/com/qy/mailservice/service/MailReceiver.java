
 package com.qy.mailservice.service;
 
 import javax.mail.MessagingException;
 
   import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
   org.springframework.beans.factory.annotation.Autowired; import
   org.springframework.beans.factory.annotation.Value; import
   org.springframework.kafka.annotation.KafkaListener;
   
   import com.qy.mailservice.constant.Constant; import
   com.qy.mailservice.model.SendMailRequest;
   
   public class MailReceiver {
   
   private static Logger logger = LoggerFactory.getLogger(MailReceiver.class);
   
  
  @Autowired SendMailService sendMailService;
  
  @Value("${spring.mail.username}") private String username;
  
  @KafkaListener(topics = Constant.topic, groupId="MailRequestGroupID") public
  void recieveMessage(SendMailRequest sendMail) {
  logger.info("Body in sendMail method" +sendMail); try {
  sendMailService.sendMail(username,
  sendMail.getRecipientMail(),sendMail.getSubject(),sendMail.getMessage(),
  sendMail.getTemplateCode()); } catch (MessagingException e) {
  
  logger.error("Exception while sending mail", e); } } }
 