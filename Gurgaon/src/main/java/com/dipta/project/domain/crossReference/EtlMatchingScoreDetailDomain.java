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
 * This Class will represents domain object matching score information linked to feed type.
 *
 */
@Entity
@Table(name = "CDI_MATCHING_SCORE")
public class EtlMatchingScoreDetailDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_matching_score_detail")
	@SequenceGenerator(name="SEQ_matching_score_detail", sequenceName="SEQ_matching_score_detail")
	private long id;
	
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "RULE_ID")
	private EtlFeedMatchingDetailDomain etlFeedMatchingDetailDomain = new EtlFeedMatchingDetailDomain();
	
	@Getter
	@Setter
	@Column(name = "CRITERIA")
	private long order;
	
	@Getter
	@Setter
	@Column(name = "MATG_STRT_VALUE")
	private long matchStartValue;
	
	@Getter
	@Setter
	@Column(name = "MATG_END_VALUE")
	private long matchEndValue;
	
	@Getter
	@Setter
	@Column(name = "MATE_STRT_VALUE")
	private long noMatchStartValue;
	
	@Getter
	@Setter
	@Column(name = "MATE_END_VALUE")
	private long noMatchEndValue;
	
	@Getter
	@Setter
	@Column(name = "MATP_STRT_VALUE")
	private long partialMatchStartValue;
	
	@Getter
	@Setter
	@Column(name = "MATP_END_VALUE")
	private long partialEndValue;
	
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
	
	@Getter
	@Setter
	@Column(name = "REMARKS")
	private String remarks;
	
	
	

}
