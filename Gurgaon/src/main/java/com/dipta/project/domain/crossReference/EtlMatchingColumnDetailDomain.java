package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author santosh.panigrahi
 * 
 * This Class will represent Domain Object information list of columns mapped in matching rule for the feed type.
 *
 */
@Entity
@Table(name = "CDI_MATCHING_MAPPING")
public class EtlMatchingColumnDetailDomain {
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_matching_column_detail")
	@SequenceGenerator(name="SEQ_matching_column_detail", sequenceName="SEQ_matching_column_detail")
	private long id;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "RULE_ID")
	private EtlFeedMatchingDetailDomain etlFeedMatchingDetailDomain = new EtlFeedMatchingDetailDomain();
	
	@Getter
	@Setter
	@Column(name = "SOURCE_TABLE_NAME")
	private String sourceTableName;
	
	@Getter
	@Setter
	@Column(name = "SOURCE_COLUMN_NAME")
	private String sourceColumnName;
	
	@Getter
	@Setter
	@Column(name = "TARGET_TABLE_NAME")
	private String targetTableName;
	
	@Getter
	@Setter
	@Column(name = "TARGET_COLUMN_NAME")
	private String targetColumnName;
	
	@Getter
	@Setter
	@Column(name = "REMARKS")
	private String remarks;
	
	@Getter
	@Setter
	@Column(name = "CRITERIA")
	private long order;
	
	@Getter
	@Setter
	@Column(name = "MATCHING_TYPE")
	private String matchingType;
	
	@Getter
	@Setter
	@Column(name = "USERCREATED")
	private long userCreated;
	
	@Getter                   
	@Setter                   
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;  
	
	@Getter                   
	@Setter                   
	@Column(name = "USERMODIFIED")
	private String userModified;  
	
	@Getter                   
	@Setter                   
	@Column(name = "DATEMODIFIED")
	private Timestamp dateModified;

}
