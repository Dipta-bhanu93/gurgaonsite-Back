package com.dipta.project.domain.file;

/**
 * 
 * @author pranav.aggarwal
 *
 */

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

@Entity
@Table(name = "CLIENTFEED")
public class ClientFeedDomain {
	
		@Getter
		@Setter
		@Id
		@Column(name="ID")
		@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_Client_Feed")
		@SequenceGenerator(name="SEQ_Client_Feed", sequenceName="SEQ_Client_Feed")
		private long id;
		
		@Getter
		@Setter
		@Column(name="CLIENTID")
		private Long clientId;
		
		@Getter
		@Setter
		@Column(name="DATEMODIFIED")
		private Timestamp dateModified;
		
		@Getter
		@Setter
		@Column(name="USERIDMODIFIED")
		private String userIdModified;
		
		@Getter
		@Setter
		@Column(name="DATECREATED")
		private Timestamp dateCreated;
		
		@Getter
		@Setter
		@Column(name="USERIDCREATED")
		private String userIdCreated;
		
		@Getter
		@Setter
		@Column(name="COMMENTS")
		private String comments;
		
		@Getter
		@Setter
		@Column(name="STATUSUSER")
		private String statusUser;
		
		@Getter
		@Setter
		@Column(name="STATUSDATE")
		private Timestamp statusDate;
		
		@Getter
		@Setter
		@Column(name="STATUS")
		private String status;

		@Getter
		@Setter
		@Column(name="FILEID")
		private Long fileId;
		
		@Getter
		@Setter
		@Column(name="FILENAME")
		private String fileName;

		@Getter
		@Setter
		@Column(name="DIRECTORYNAME")
		private String directoryName;
		

		@Getter
		@Setter
		@Column(name="FEEDTYPE")
		private String feedType;
		
		@Getter
		@Setter
		@Column(name="ORIGINALFILENAME")
		private String originalFileName;
		
		@Getter
		@Setter
		@Column(name="DATAFEEDID")
		private Long dataFeedId;

		@Getter
		@Setter
		@Column(name="FILE_TYPE")
		private String fileType;
		
		@Getter
		@Setter
		@Column(name="PROJECT_ID")
		private Long projectId;
		
		
}
