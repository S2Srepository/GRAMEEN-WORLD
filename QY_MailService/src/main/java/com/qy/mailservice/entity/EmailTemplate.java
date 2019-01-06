package com.qy.mailservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmailTemplate {

	@Id
	private String templateCode;
	@Column
	private String templateName;
	@Column
	private String langId;
	@Column
	private String subject;
	@Column
	private String maskingRegex;
	
	
	public EmailTemplate() {
		super();
	}
	public EmailTemplate(String templateCode, String templateName, String langId, String subject, String maskingRegex) {
		super();
		this.templateCode = templateCode;
		this.templateName = templateName;
		this.langId = langId;
		this.subject = subject;
		this.maskingRegex = maskingRegex;
	}
	@Override
	public String toString() {
		return "EmailTemplate [templateCode=" + templateCode + ", templateName=" + templateName + ", langId=" + langId
				+ ", subject=" + subject + ", maskingRegex=" + maskingRegex + "]";
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getLangId() {
		return langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMaskingRegex() {
		return maskingRegex;
	}
	public void setMaskingRegex(String maskingRegex) {
		this.maskingRegex = maskingRegex;
	}
	
	
}
