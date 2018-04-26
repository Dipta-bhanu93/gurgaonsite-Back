package com.dipta.project.dao.base.orm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dao.workflow.IWorkFlowDao;
import com.dipta.project.domain.workflow.WorkFlowMasterDomain;
import com.dipta.project.dto.workflow.WorkFlowRoleDTO;
import com.dipta.project.exception.common.InvalidFileException;
import com.dipta.project.exception.common.InvalidKeyException;
import com.dipta.project.security.configuration.RolesEnum;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.workflowcore.dto.Role;

public final class TenantWorkflowPool {
	
	private static final Map<Long, Map<Long,WorkFlowRoleDTO>> clientWorkflowMap = new ConcurrentHashMap<>();
	private static final String WF_LEVEL_ = "WF_LEVEL_";
	
	public static void createPoolforTenant(Long tenantId){
		if (null != tenantId && null == clientWorkflowMap.get(tenantId)) {
			Map<Long, WorkFlowRoleDTO> wfRoleMap = new ConcurrentHashMap<Long, WorkFlowRoleDTO>();
			IWorkFlowDao iWorkFlowDao = DaoManager.WORKFLOWDAO.getDao(tenantId, IWorkFlowDao.class);
			List<WorkFlowMasterDomain> masterList = iWorkFlowDao.getWorkFlowMaster();
			if(null != masterList && !masterList.isEmpty()){
				for (WorkFlowMasterDomain workFlowMasterDomain : masterList) {
					wfRoleMap.put(workFlowMasterDomain.getWorkFlowId(), createWorkFlowRoleDTO(workFlowMasterDomain.getWorkFlowId(), workFlowMasterDomain.getWorkFlowLevel()));
				}
				clientWorkflowMap.put(tenantId, wfRoleMap);
			}
		}
	}
	
	public static WorkFlowRoleDTO getWorkflowRoleObj(Long tenantId, Long wfId){
		if (tenantId == null && null == clientWorkflowMap.get(tenantId)) {
			return null;
		}else{
			return clientWorkflowMap.get(tenantId).get(wfId);
		}
	}

	public static void updateWorkflowRoleObj(Long tenantId, Long wfId, Long wfLevel){
		if(null != tenantId && null != wfId && null != wfLevel){
			WorkFlowRoleDTO wfDto = clientWorkflowMap.get(tenantId).get(wfId);
			wfDto.setWorkflowLevel(wfLevel);
			wfDto.setRoleMap(createRoleMap(wfLevel));
		}
	}
	
	public static void deleteWorkflowRoleObj(Long tenantId, Long wfId)throws NullPointerException{
		if(null != tenantId && null != wfId && null != clientWorkflowMap.get(tenantId)){
			Map<Long, WorkFlowRoleDTO> wfRoleMap = clientWorkflowMap.get(tenantId);
			wfRoleMap.remove(wfId);
		}
	}
	
	public static void addWorkflowRoleObj(Long tenantId, Long wfId, Long wfLevel){
		if(null != tenantId && null != wfId && null != wfLevel){
			if(null != clientWorkflowMap.get(tenantId)){
				Map<Long, WorkFlowRoleDTO> wfRoleMap = clientWorkflowMap.get(tenantId);
				wfRoleMap.put(wfId, createWorkFlowRoleDTO(wfId, wfLevel));
			}else{
				Map<Long, WorkFlowRoleDTO> wfRoleMap = new ConcurrentHashMap<Long, WorkFlowRoleDTO>();
				wfRoleMap.put(wfId, createWorkFlowRoleDTO(wfId, wfLevel));
				clientWorkflowMap.put(tenantId, wfRoleMap);
			}
		}
	}
	
	private static WorkFlowRoleDTO createWorkFlowRoleDTO(Long wfId,Long wfLevel){
		WorkFlowRoleDTO wfDto = new WorkFlowRoleDTO();
		wfDto.setWorkFlowId(wfId);
		wfDto.setWorkflowLevel(wfLevel);
		wfDto.setRoleMap(createRoleMap(wfLevel));
		return wfDto;
	}
	
	private static Map<Long,Role> createRoleMap(Long level){
		Map<Long,Role> roleMap =  new HashMap<Long,Role>();
		for (int i = 1; i <= level; i++) {
			try {
				Role role = new Role();
				Long roleId = PropertyUtility.getValueLong(ApplicationConstants.APPLICATION_BUNDLE.getValue(), WF_LEVEL_+i);
				role.setRoleType(RolesEnum.getRoleEnumById(roleId).getRoleTypeString());
				role.setRoleDescription(RolesEnum.getRoleEnumById(roleId).getRoleDescription());
				role.setRoleId(roleId);
				roleMap.put((long) i, role);
			} catch (InvalidFileException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
		return roleMap;
	}
	
}
