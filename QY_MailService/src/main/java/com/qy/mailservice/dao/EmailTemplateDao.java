package com.qy.mailservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qy.mailservice.entity.EmailTemplate;

public interface EmailTemplateDao extends JpaRepository<EmailTemplate, String > {
	
	@Query("select et from EmailTemplate et where et.templateCode=:templateCode")
	public EmailTemplate findByTemplateCode(@Param("templateCode") String templateCode);

	
}
