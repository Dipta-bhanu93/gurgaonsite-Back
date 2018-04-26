package com.dipta.project.dao.scheduler.orm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.scheduler.ISchedulerDao;
import com.dipta.project.dao.scheduler.orm.domain.SchedulerDomain;
import com.dipta.project.dao.scheduler.orm.domain.SchedulerHistoryDomain;
import com.dipta.project.domain.project.ProjectExecutionDomain;
import com.dipta.project.dto.scheduler.SchedulerJobDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.constants.StatusConstants;
/**
 * 
 * @author saurabh.agarwal
 *
 */
public class SchedulerDaoImpl extends AbstractBaseDao implements ISchedulerDao{
	public SchedulerDaoImpl(String userEmail) {
		super(userEmail);
	}
	public SchedulerDaoImpl(Long companyID) {
		super(companyID);
	}
	@Override
	public Boolean saveUpdateJobInfo(SchedulerJobDto jobData) throws ProcessFailedException {
		boolean result = false;
		try {
			SchedulerDomain previousJobState = getProjectExecutionDomain(jobData.getJobId());
			
			
			hibernatePersistenceManager.beginTransaction();
			if(previousJobState!=null){
				SchedulerHistoryDomain historyObject = CommonUtils.convertObject(previousJobState, SchedulerHistoryDomain.class);
				hibernatePersistenceManager.saveOrUpdate(historyObject);
			}
			
			jobData.setLastUpdated(new Date());
			SchedulerDomain jobDomain = CommonUtils.convertObject(jobData, SchedulerDomain.class);
			hibernatePersistenceManager.saveOrUpdate(jobDomain);
			result = true;
			hibernatePersistenceManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			hibernatePersistenceManager.rollback();
			throw new ProcessFailedException("Scheduler job updated.");
		}
		return result;
	}


	public List<SchedulerJobDto> getAllScheduledJobs() throws ProcessFailedException{
		List<SchedulerJobDto> response = new ArrayList<>();
		beginTransaction();

		try{
			Criteria schedulerCriteria = createCriteria(SchedulerDomain.class);
			schedulerCriteria.add(Restrictions.eq("statusId", StatusConstants.SCHEDULED.getID()));
			schedulerCriteria.add(Restrictions.eq("reInitiateOnServerStartup", "Y"));
			
			List<SchedulerDomain> scheduledJobs =  schedulerCriteria.list();
			for(SchedulerDomain scheduledJob : scheduledJobs){
				SchedulerJobDto scheduledJobDto = CommonUtils.convertObject(scheduledJob, SchedulerJobDto.class);
				response.add(scheduledJobDto);
			}
		}catch(ObjectNotSupportedException e){
			throw new ProcessFailedException(e.getMessage());
		}

		endTransaction();
		return response;
	}
	
	public SchedulerDomain getProjectExecutionDomain(String jobId) throws ProcessFailedException {
		beginTransaction();
		SchedulerDomain jobDetails = hibernatePersistenceManager.getPersistentObject(SchedulerDomain.class, jobId);
		if (jobDetails != null) {
			hibernatePersistenceManager.refresh(jobDetails);
		}
		endTransaction();
		return jobDetails;
	}
}
