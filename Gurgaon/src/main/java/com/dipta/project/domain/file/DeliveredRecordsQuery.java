package com.dipta.project.domain.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DELIVERED_RECORDS_QUERY")
public class DeliveredRecordsQuery {
	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private Long Id;
	
	@Getter
	@Setter

	@Column(name="TEMPLATE_ID")
	private Long templateId;

	@Getter
	@Setter
	@Column(name="MATCH_STATUS")
	private String matchStatus;

	@Getter
	@Setter
	@Column(name="PROJECT_ID")
	private Long projectId;
	
	
	@Getter
	@Setter
	@Lob
	@Column(name="QUERY")
	private String queryText;
	
	
}
