/**
 * 
 */
package com.dipta.project.utility.queue.jobcategory;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dipta.project.dto.email.EmailInfoDTO;
import com.dipta.project.dto.scheduler.SchedulerJobDto;
import com.dipta.project.dto.scheduler.SchedulerJobDto.ReInitiateOnServerStartup;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.scheduler.SchedulingFailedException;
import com.dipta.project.maintenance.email.EmailMaintainanceImpl;
import com.dipta.project.scheduler.ScheduleManager;
import com.dipta.project.scheduler.ScheduleManager.Repeat;
import com.dipta.project.scheduler.SchedulerJob;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Aditya.Julka
 *
 */
@Slf4j
public class EmailResendProcess extends SchedulerJob {
	
	@Autowired
	EmailMaintainanceImpl emailMaintainanceImpl;
	
	@Setter
	@Getter
	private static  Long intervalInMinutes;
	
	
	
	static{
		String interval = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), ApplicationConstants.EMAIL_RETRY_INTERVAL.getValue(),"");
		intervalInMinutes=Long.parseLong(interval);
	}
	public EmailResendProcess() {
		// TODO Auto-generated constructor stub
	}
	public EmailResendProcess(String userEmail,EmailInfoDTO obj) {
		SchedulerJobDto jobData = new SchedulerJobDto(obj.getId().toString()+"_"+obj.getRetryCount(),getNextExecutionTime(obj.getCreatedDate()),userEmail,obj,Repeat.DO_NO_REPEAT,ReInitiateOnServerStartup.NO);
		setJobData(jobData);
	}
	public EmailResendProcess(SchedulerJobDto obj) {
		setJobData(obj);
	}
	
	@Override
	public boolean execute(SchedulerJobDto jobDto) throws Exception {
		boolean flag=false;
		EmailInfoDTO dtoObj=(EmailInfoDTO) jobDto.getData();
		EmailMaintainanceImpl emailMaintainanceImpl=new EmailMaintainanceImpl();
		try {
//			emailMaintainanceImpl.ResendMail(dtoObj);
			flag=emailMaintainanceImpl.resendMail(dtoObj);
			if(flag){
				dtoObj.setException(null);
				jobDto.setData(dtoObj);
			}else{
				dtoObj.setRetryCount((dtoObj.getRetryCount()+1));
				jobDto.setData(dtoObj);
			}
		} catch (Exception e) {
			log.error("EmailResendProcess::execute "+e.getMessage());
			return flag;
		}
		return flag;
		
	}


	@Override
	public void scheduled(SchedulerJobDto jobDto) throws ProcessFailedException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executionStart(SchedulerJobDto jobDto) throws ProcessFailedException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void executionFinish(SchedulerJobDto jobDto) throws ProcessFailedException {
		EmailInfoDTO dtoObj=(EmailInfoDTO) jobDto.getData();
		
		if((dtoObj.getException()!=null)&&(dtoObj.getRetryCount()<=1)){
			jobDto.setJobId(dtoObj.getId().toString()+"_"+dtoObj.getRetryCount());
			jobDto.setExecutionDate(getNextExecutionTime(jobDto.getExecutionDate()));
			SchedulerJob job = new EmailResendProcess(jobDto);
			try {
				ScheduleManager.schedule(job);
			} catch (SchedulingFailedException e) {
				log.error("EmailResendProcess::executionFinish "+e.getMessage());
			}
		}
		
	}
	private Date getNextExecutionTime(Date date){
		return new Date(date.getTime()+(intervalInMinutes * 60L * 1000L));
	}

	@Override
	public void executionFailed(SchedulerJobDto jobDto, String exceptionMessage) throws ProcessFailedException {
		// TODO Auto-generated method stub
		
	}
	

	
	
	

}
