package com.dipta.project.dao.ticketManagement.orm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;

import com.dipta.project.dao.ticketManagement.ITicketMaintenanceDao;
import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.base.orm.TenantWorkflowPool;
import com.dipta.project.dao.workflow.IWorkFlowDao;

import com.dipta.project.dto.workflow.ProjectDTO;

import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.dipta.project.utility.constants.CommonConstants;
import com.dipta.project.utility.constants.GanttConstant;
import com.dipta.project.utility.constants.StatusConstants;

public class TicketMaintenanceDaoImpl extends AbstractBaseDao implements ITicketMaintenanceDao  {

	
	
	public TicketMaintenanceDaoImpl(String tenantEmail) {
		super(tenantEmail);
	}
	
	public TicketMaintenanceDaoImpl(Long clientId) {
		super(clientId);
	}



	
}
