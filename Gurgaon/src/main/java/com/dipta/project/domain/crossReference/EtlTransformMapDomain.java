package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "CDI_ETL_TRANSFORM_MAP")
public class EtlTransformMapDomain {
	
	@Getter                   
	@Setter     
	@Id
	@Column(name = "TRANS_DEF_SET_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_etl_transform_map")
	@SequenceGenerator(name="SEQ_etl_transform_map", sequenceName="SEQ_etl_transform_map")
	private long transformMapId;
	
	@Getter                   
	@Setter                   
	@Column(name = "FEEDID")
	private long feedId;
	
	@Getter                   
	@Setter                   
	@Column(name = "FILEID")
	private long fileId ;
	
	@Getter                   
	@Setter                   
	@Column(name = "REMARKS")
	private String remarks;
	
	@Getter                   
	@Setter                   
	@Column(name = "EXECUTE_STATUS_FLAG")
	private String executeStatusFlag;
	
	@Getter                   
	@Setter                   
	@Column(name = "EXECUTE_INSTANCE")
	private String executeInstance;
	
	@Getter                   
	@Setter                   
	@Column(name = "TRANS_DEF_SET_NAME")
	private String transformSetName;
	
	@Getter                   
	@Setter                   
	@Column(name = "DEF_STATUS")
	private String transformStatus;
	
	@Getter
	@Setter
	@Column(name = "USERCREATED")
	private String userIdCreated;
	
	@Getter                   
	@Setter                   
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;  
	
	@Getter                   
	@Setter                   
	@Column(name = "USERMODIFIED")
	private String userIdModified;  

	@Getter                   
	@Setter                   
	@Column(name = "DATEMODIFIED")
	private Timestamp dateModified; 
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etlTransformMapDomain")
	private Set<SourceTargetInfoDomain> sourceTargetInfoDomainSet = new HashSet<SourceTargetInfoDomain>();
	
	
	
	

}
