package com.dipta.project.dao.workflow.orm;

import lombok.extern.slf4j.Slf4j;

import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.workflow.WorkflowCoreDao;
import com.dipta.project.dto.workflow.WorkflowCoreDTO;
@Slf4j
public class WorkflowCoreDaoImpl extends AbstractBaseDao implements WorkflowCoreDao{

	public WorkflowCoreDaoImpl(String tenantEmail) {
		super(tenantEmail);
	}

	@Override
	public String updateWorkflow(WorkflowCoreDTO workflowDTO) {
		log.info("Update workflow details in database");
		return null;
	}
}
