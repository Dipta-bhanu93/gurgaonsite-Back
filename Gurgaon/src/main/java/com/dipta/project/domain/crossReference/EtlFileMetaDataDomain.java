package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ETL_FILEMETADATA")
public class EtlFileMetaDataDomain {

	@Getter
	@Setter
	@Id
	@Column(name = "FILE_METADATA_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ETL_FILEMETADATA")
	@SequenceGenerator(name="SEQ_ETL_FILEMETADATA", sequenceName="SEQ_ETL_FILEMETADATA")
	private long fileMetadataId;
	
	@Getter                   
	@Setter                   
	@Column(name = "FILE_NAME")
	private String fileName; 
	
	@Getter                   
	@Setter                   
	@Column(name = "FILE_EXTENSION")
	private String fileExtension; 
	
	@Getter                   
	@Setter                   
	@Column(name = "FILE_DELIMITER")
	private String fileDelimiter; 
	
	@Getter                   
	@Setter                   
	@Column(name = "USERIDCREATED")
	private String userIdCreated; 
	
	@Getter                   
	@Setter                   
	@Column(name = "DATE_CREATED")
	private Timestamp dateCreated;
	
	@Getter                   
	@Setter                   
	@Column(name = "USERIDMODIFIED")
	private String userIdModified; 
	
	@Getter                   
	@Setter                   
	@Column(name = "DATE_MODIFIED")
	private Timestamp dateModified;
	
	@Getter                   
	@Setter                   
	@Column(name = "FILE_ID")
	private long fileId;
	
	@Getter                   
	@Setter                   
	@Column(name = "TO_DATE")
	private String toDate; 
	
	@Getter                   
	@Setter                   
	@Column(name = "FROM_DATE")
	private String fromDate; 
	
	@Getter                   
	@Setter                   
	@Column(name = "B_SKIP_ROWS")
	private long bSkipRows; 
	
	@Getter                   
	@Setter                   
	@Column(name = "E_SKIP_ROWS")
	private long eSkipRows; 
	
	@Getter                   
	@Setter                   
	@Column(name = "BAD_RECORDS")
	private long badRecords; 
	
	@Getter                   
	@Setter                   
	@Column(name = "TOTAL_NO_BADRECORDS")
	private long totalNoBadRecords; 
	
	@Getter                   
	@Setter                   
	@Column(name = "TOTAL_NO_RECORDS")
	private long totalNoRecords; 
	
	@Getter                   
	@Setter                   
	@Column(name = "GOLD_DATA_FLAG")
	private char goldDataFlag;

	@Getter                   
	@Setter                   
	@Column(name = "CUSTOMER_DATA_FLAG")
	private char customerDataFlag;
	
	@Getter                   
	@Setter                   
	@Column(name = "FILE_CONTAINS_HEADERS")
	private char fileContainsHeaders;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="FEED_ID") 
	private FeedMasterDomain feedMasterDomain;

	@Override
	public String toString() {
		return "EtlFileMetaDataDomain [fileMetadataId=" + fileMetadataId
				+ ", fileName=" + fileName + ", fileExtension=" + fileExtension
				+ ", fileDelimiter=" + fileDelimiter + ", userIdCreated="
				+ userIdCreated + ", dateCreated=" + dateCreated
				+ ", userIdModified=" + userIdModified + ", dateModified="
				+ dateModified + ", fileId=" + fileId + ", toDate=" + toDate
				+ ", fromDate=" + fromDate + ", bSkipRows=" + bSkipRows
				+ ", eSkipRows=" + eSkipRows + ", badRecords=" + badRecords
				+ ", totalNoBadRecords=" + totalNoBadRecords
				+ ", totalNoRecords=" + totalNoRecords + ", goldDataFlag="
				+ goldDataFlag + ", customerDataFlag=" + customerDataFlag
				+ ", fileContainsHeaders=" + fileContainsHeaders + "]";
	}

	
	
}
