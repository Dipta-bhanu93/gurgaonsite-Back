package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "FEEDMASTER")
public class FeedMasterDomain {
	
	
	@Getter
	@Setter
	@Id
	@Column(name = "FEEDID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_FEEDMASTER")
	@SequenceGenerator(name="SEQ_FEEDMASTER", sequenceName="SEQ_FEEDMASTER")
	private long feedid;
	
	@Getter                   
	@Setter                   
	@Column(name = "FEEDTYPE")
	private String feedType;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "FEEDNAME")
	private String feedName;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "FEEDTYPE_DUP")
	private String feedType_Dup;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "FEEDNAME_DUP")
	private String feedName_Dup;  
	
	
	@Getter
	@Setter
	@Column(name = "CONTROL_PARSER")
	private String control_Parser;
	
	@Getter                   
	@Setter                   
	@Column(name = "SOURCETYPE")
	private String sourceType;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "DISABLE")
	private char disable;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "FEED_DATA_TYPE")
	private String feedDataType;  
	
	
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
	@Column(name = "PROVIDERNAME")
	private String providerName;  
	
	
	@Getter
	@Setter
	@Column(name = "DATABASE_ID")
	private long databaseId;
	
	@Getter                   
	@Setter                   
	@Column(name = "SOURCE_ID")
	private long sourceId;  
	
	
	@Getter                   
	@Setter                   
	@Column(name = "CLIENTID")
	private long clientId; 
	
	@Getter
	@Setter
	@OneToOne(mappedBy="feedMasterDomain")
	//@JoinColumn(name="FEED_ID") 
	private EtlFileMetaDataDomain etlFileMetaDataDomain;

	@Override
	public String toString() {
		return "FeedMasterDomain [feedid=" + feedid + ", feedType=" + feedType
				+ ", feedName=" + feedName + ", feedType_Dup=" + feedType_Dup
				+ ", feedName_Dup=" + feedName_Dup + ", control_Parser="
				+ control_Parser + ", sourceType=" + sourceType + ", disable="
				+ disable + ", feedDataType=" + feedDataType + ", comments="
				+ comments + ", userIdCreated=" + userIdCreated
				+ ", dateCreated=" + dateCreated + ", userIdModified="
				+ userIdModified + ", dateModified=" + dateModified
				+ ", providerName=" + providerName + ", databaseId="
				+ databaseId + ", sourceId=" + sourceId + ", clientId="
				+ clientId + ", etlFileMetaDataDomain=" + etlFileMetaDataDomain
				+ "]";
	}

	

	
	
	/*@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feedMasterDomain")
	private Set<ProjectFeedDomain> projectFeedDomainSet = new HashSet<ProjectFeedDomain>();*/

}