package com.dipta.project.domain.base.orm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.dipta.project.serializers.XmlDateAdapter;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TENANT_DB_LOG")
public class TenantDbLogDomain {

	@Getter
	@Setter
	@Id
	@Column(name="TENANT_ID")
	private long tenantId;
	
	
	@Getter
	@Setter
	@Column(name="ERROR_CODE")
	private String errorCode;
	
	
	@Getter
	@Setter
	@Column(name="STATUS")
	private String status;
	
	
	@Getter
	@Setter
	@Column(name="STATUS_LOG")
	private String statusLog;
	
	
	@Getter
	@Setter
	@Column(name="LAST_UPDATED")
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date lastUpdated;
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenantId+" | "+errorCode+" | "+status+" | "+statusLog;
	}
}