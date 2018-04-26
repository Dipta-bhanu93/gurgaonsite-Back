package com.dipta.project.dao.workflow;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dto.workflow.WorkflowCoreDTO;

public interface WorkflowCoreDao extends DaoBaseInterface{
	public String updateWorkflow(WorkflowCoreDTO workflowDTO);

}
