package com.dipta.project.utility.queue;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dipta.project.dao.base.DaoManager;
//import com.dipta.project.dao.company.CompanyDao;
import com.dipta.project.dao.project.IProjectDao;
//import com.dipta.project.dto.company.CompanyDto;
import com.dipta.project.dto.project.execute.ProjectExecutionDto;
import com.dipta.project.dto.workflow.ProjectDTO;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.scheduler.ScheduleManager;
import com.dipta.project.scheduler.SchedulerJob;
import com.dipta.project.scheduler.jobs.ProjectExecutionJob;
import com.dipta.project.utility.constants.ApplicationConstants;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Saurabh Agarwal
 *
 */
@Slf4j
public class ProjectExecutionQueueManager extends QueueManager {
	
	private static final Map<Long, QueueManager> clientsQueueMap = new ConcurrentHashMap<>();
	
	@Getter
	private long projectUnderExecution = 0;
	
	
	public static QueueManager getClientsQueue(Long clientId){
		if(clientsQueueMap.get(clientId)!=null){
			return clientsQueueMap.get(clientId);
		}else{
			QueueManager clientQueue = new ProjectExecutionQueueManager();
			clientsQueueMap.put(clientId, clientQueue);
			return clientQueue;
		}
	}
	public static void setProjectUnderExecution(Long clientId,Long projectId){
		ProjectExecutionQueueManager qm = (ProjectExecutionQueueManager)getClientsQueue(clientId);
		qm.projectUnderExecution = projectId;
	}
	
//	public static void serverStartupProcess() throws ProcessFailedException{
//		CompanyDao companyDao = DaoManager.COMPANYREGISTRATIONDAO.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),CompanyDao.class);
//
//		List<CompanyDto> companies= companyDao.getAllCompanies();
//
//		for(CompanyDto company : companies){
//			try{
//				long companyID = company.getId();
//				System.out.println("-----------------------------------------------------------------");
//				System.out.println("Jobs Queuing process for Tenant ID: "+companyID);
//				
//				IProjectDao projectDao = DaoManager.PROJECTDAO.getDao(companyID,IProjectDao.class);
//				
//				List<ProjectExecutionDto> queuedJobs = projectDao.getAllQueuedJobs();
//				
//				for(ProjectExecutionDto job : queuedJobs){
//					
//					job.setNextExecution(new Date());
//					ProjectDTO projectDto = new ProjectDTO();
//					projectDto.setId(job.getProjectId());
//					projectDto.setExecutionDetails(job);
//					SchedulerJob schedulerJob = new ProjectExecutionJob(job.getUserExecuted(),projectDto);
//					ScheduleManager.schedule(schedulerJob);
//					
//				}
//				
//				
//				System.out.println(projectDao);
//				
//			}catch(Exception e){
//				e.printStackTrace();
//				log.error("Queuing failed to start for Tenant Id = "+company.getId()+"  . Due to exception : "+e);
//			}
//			System.out.println("-----------------------------------------------------------------\n\n");
//		}
//	}
}
