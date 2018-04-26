package com.dipta.project.domain.crossReference;

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
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "etl_prestage_stage_map")
public class EtlPrestageMapDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_etl_prestage_stage_map")
	@SequenceGenerator(name="SEQ_etl_prestage_stage_map", sequenceName="SEQ_etl_prestage_stage_map")
	private Long id;
	
	@Getter                   
	@Setter                   
	@Column(name = "PRESTAGE_TAB_NAME")
	private String prestageTabName;
	
	@Getter                   
	@Setter                   
	@Column(name = "PRESTAGE_COL_NAME")
	private String prestageColName;
	
	@Getter                   
	@Setter                   
	@Column(name = "STAGE_COL_NAME")
	private String stageColName;
	
	@Getter                   
	@Setter                   
	@Column(name = "UNIQUE_IDENTIFER")
	private char uniqueIdentifier;
	
	@Getter                   
	@Setter                   
	@Column(name = "TYPE")
	private String type;
	
	@Getter                   
	@Setter                   
	@Column(name = "PRESTAGE_IDENTIFIER_NAME")
	private String prestageIdentifierName;
	
	@Getter                   
	@Setter                   
	@Column(name = "COMMENTS")
	private String comments;
	
	@Getter
	@Setter
	@Column(name = "USERIDCREATED")
	private String userIdCreated;
	
	@Getter                   
	@Setter                   
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;  
	
	@Getter                   
	@Setter                   
	@Column(name = "USERIDMODIFIED")
	private String userIdModified;  
	
	@Getter                   
	@Setter                   
	@Column(name = "DATEMODIFIED")
	private Timestamp dateModified;  
	
	@Getter
	@Setter
	@Column(name = "PRESTAGEMAP_ID")
	private long prestageMapId;

}
