/**
 * 
 */
package com.dipta.project.dao.workflow;

import java.util.List;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dao.workflow.orm.WorkFlowDaoImpl;
import com.dipta.project.domain.workflow.WorkFlowBatchDomain;
import com.dipta.project.domain.workflow.WorkFlowMasterDomain;
import com.dipta.project.dto.project.template.TemplateServiceMasterDto;
import com.dipta.project.dto.user.ClientDto;
import com.dipta.project.dto.workflow.WorkFlowMasterDto;
import com.dipta.project.dto.workflow.WorkFlowRecordsCountDto;
import com.dipta.project.dto.workflow.WorkFlowSearchGridDto;
import com.dipta.project.dto.workflow.WorkflowRecordsMappingCollection;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.workflow.DuplicateWorkFlowNameException;

/**
 * @author Ashish.Patel
 *
 */
public interface IWorkFlowDao extends DaoBaseInterface {

	boolean isUserAssociatedWithWorkflow(long id);

	List<WorkFlowMasterDomain> getWorkFlowMaster();
}