package com.qy.mailservice.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class SendMailRequest {

	private String senderMail;
	private String[] recipientMail;
	private Timestamp timeStampRequest;
	private String subject;
	private String maxRetryCount;
	private String langId;
	private String message;
	private String templateCode;
	private String TemplateDataModel;
	public SendMailRequest(String senderMail, String[] recipientMail, Timestamp timeStampRequest, String subject,
			String maxRetryCount, String langId, String message, String templateCode, String templateDataModel) {
		super();
		this.senderMail = senderMail;
		this.recipientMail = recipientMail;
		this.timeStampRequest = timeStampRequest;
		this.subject = subject;
		this.maxRetryCount = maxRetryCount;
		this.langId = langId;
		this.message = message;
		this.templateCode = templateCode;
		TemplateDataModel = templateDataModel;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String[] getRecipientMail() {
		return recipientMail;
	}
	public void setRecipientMail(String[] recipientMail) {
		this.recipientMail = recipientMail;
	}
	public Timestamp getTimeStampRequest() {
		return timeStampRequest;
	}
	public void setTimeStampRequest(Timestamp timeStampRequest) {
		this.timeStampRequest = timeStampRequest;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMaxRetryCount() {
		return maxRetryCount;
	}
	public void setMaxRetryCount(String maxRetryCount) {
		this.maxRetryCount = maxRetryCount;
	}
	public String getLangId() {
		return langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getTemplateDataModel() {
		return TemplateDataModel;
	}
	public void setTemplateDataModel(String templateDataModel) {
		TemplateDataModel = templateDataModel;
	}
	@Override
	public String toString() {
		return "SendMailRequest [senderMail=" + senderMail + ", recipientMail=" + Arrays.toString(recipientMail)
				+ ", timeStampRequest=" + timeStampRequest + ", subject=" + subject + ", maxRetryCount=" + maxRetryCount
				+ ", langId=" + langId + ", message=" + message + ", templateCode=" + templateCode
				+ ", TemplateDataModel=" + TemplateDataModel + "]";
	}
	
	
}