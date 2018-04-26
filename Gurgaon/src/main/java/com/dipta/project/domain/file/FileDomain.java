package com.dipta.project.domain.file;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@Entity
@Table(name = "FILES")
public class FileDomain {
	@Getter
	@Setter
	@Id
	@Column(name="FILE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_FILE_ID")
	@SequenceGenerator(name="SEQ_FILE_ID", sequenceName="SEQ_FILE_ID")
	private long id;

	@Getter
	@Setter
	@Column(name="USER_FILE_NAME")
	private String fileName;

	@Getter
	@Setter
	@Column(name="USER_FILE_LOCATION")
	private String fileLocation;
	
	@Getter
	@Setter
	@Column(name="STATUS_ID")
	private Integer statusId;

	@Getter
	@Setter
	@Column(name="DATEMODIFIED")
	private Timestamp dateModified;

	@Getter
	@Setter
	@Column(name="DATECREATED")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name="SOURCE")
	private String source;
	
	@Getter
	@Setter
	@Column(name="FORMAT")
	private String extension;
	
	@Getter
	@Setter
	@Column(name="PROCESSPERCENTAGE")
	private Integer processPercentage;
	
	
	@Getter
	@Setter
	@Column(name="USER_CREATED")
	private Long userCreated;
}
