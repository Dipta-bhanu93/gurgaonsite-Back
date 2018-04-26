/**
 * 
 */
package com.dipta.project.domain.workflow;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "WORKFLOW_DETAILS")
public class WorkFlowDetailsDomain {

	@Getter
	@Setter
	@Id
	@Column(name = "WF_DTL_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_WF_DTL_ID")
	@SequenceGenerator(name="SEQ_WF_DTL_ID", sequenceName="SEQ_WF_DTL_ID")
	private long workFlowDetailId;
	
	/*@Getter
	@Setter
	@Column(name = "WF_ID")
	private Long workFlowId;*/
	
	

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_ID", nullable=false)
	private WorkFlowMasterDomain workFlowMaster = new WorkFlowMasterDomain();
	
	@Getter
	@Setter
	@Column(name="USERID")
	private Long associateUserId;
	
	@Getter
	@Setter
	@Column(name="DATECREATED")
	private Timestamp dateCreated;

	@Override
	public String toString() {
		return "WorkFlowDetailsDomain [workFlowDetailId=" + workFlowDetailId
				+ ", workFlowMaster=" + workFlowMaster + ", associateUserId=" + associateUserId
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (workFlowDetailId ^ (workFlowDetailId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkFlowDetailsDomain other = (WorkFlowDetailsDomain) obj;
		if (workFlowDetailId != other.workFlowDetailId)
			return false;
		return true;
	}
	
	
}
