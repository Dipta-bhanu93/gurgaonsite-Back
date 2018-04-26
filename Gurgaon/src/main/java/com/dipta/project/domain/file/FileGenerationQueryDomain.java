package com.dipta.project.domain.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FILE_GENERATION_QUERY")
public class FileGenerationQueryDomain {

	@Getter
	@Setter
	@Id
	@Column(name="PROJECT_ID")
	private Long projectId;
	
	
	@Getter
	@Setter
	@Lob
	@Column(name="QUERY_TEXT")
	private String queryText;
	
	
}
