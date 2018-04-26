package com.dipta.project.domain.workflow;

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
@Table(name = "WORKFLOW_BATCH")
public class WorkFlowBatchDomain {

	
	
	@Getter
	@Setter
	@Id
	@Column(name = "WF_BATCH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_WF_BATCH_ID")
	@SequenceGenerator(name="SEQ_WF_BATCH_ID", sequenceName="SEQ_WF_BATCH_ID")
	private long wfBatchID;
	
	@Getter
	@Setter
	@Column(name = "WF_ID")
	private Long workFlowId;
	
	@Getter
	@Setter
	@Column(name = "CURRENT_BATCH_ID")
	private Long currentBatchID;
	
}
