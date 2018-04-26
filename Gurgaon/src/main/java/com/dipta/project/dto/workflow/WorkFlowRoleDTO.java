/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.workflowcore.dto.Role;

/**
 * @author Pranav.Aggarwal
 *
 */
public class WorkFlowRoleDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4850600783656395830L;

	@Getter
	@Setter
	private Long workFlowId;
	
	@Getter
	@Setter
	private Long workflowLevel;
		
	@Getter
	@Setter
	private Map<Long,Role> roleMap;

	public boolean equals(WorkFlowRoleDTO obj) {
        return (this.workFlowId == obj.workFlowId);
    }
}
