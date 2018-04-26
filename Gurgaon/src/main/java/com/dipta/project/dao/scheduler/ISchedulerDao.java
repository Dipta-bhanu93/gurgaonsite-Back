package com.dipta.project.dao.scheduler;

import java.util.List;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dto.scheduler.SchedulerJobDto;
import com.dipta.project.exception.common.ProcessFailedException;

/**
 * 
 * @author saurabh.agarwal
 *
 */
public interface ISchedulerDao extends DaoBaseInterface {
	public Boolean saveUpdateJobInfo(SchedulerJobDto jobData) throws ProcessFailedException;
	public List<SchedulerJobDto> getAllScheduledJobs() throws ProcessFailedException;
}
