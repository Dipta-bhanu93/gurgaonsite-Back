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
@Table(name = "etl_prestagemaster")
public class EtlPrestageMasterDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_etl_prestagemaster")
	@SequenceGenerator(name="SEQ_etl_prestagemaster", sequenceName="SEQ_etl_prestagemaster")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "PRESTAGEMAP_ID")
	private long prestageMapId;
	
	@Getter                   
	@Setter                   
	@Column(name = "PRESTAGE_TAB_NAME")
	private String prestageTabName;
	
	@Getter                   
	@Setter                   
	@Column(name = "PRESTAGEMAP_NAME")
	private String prestageMapName;
	
	@Getter                   
	@Setter                   
	@Column(name = "FILEID")
	private long fileId;
	
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

}
