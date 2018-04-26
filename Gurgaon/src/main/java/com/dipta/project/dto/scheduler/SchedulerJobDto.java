package com.dipta.project.dto.scheduler;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.scheduler.ScheduleManager.Repeat;
import com.dipta.project.utility.CommonUtils;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@XmlRootElement(name = "ScheduledJob")
@JsonRootName(value = "ScheduledJob")
@XmlAccessorType(XmlAccessType.NONE)
public class SchedulerJobDto {
	public enum ReInitiateOnServerStartup{
		
		YES("Y"),
		NO("N");
		
		String reinitiateFlag;
		private ReInitiateOnServerStartup(String reinitiateFlag) {
			this.reinitiateFlag=reinitiateFlag;
		}
		public String getReinitiateFlag() {
			return reinitiateFlag;
		}
	}
	public SchedulerJobDto() {
		reInitiateOnServerStartup = ReInitiateOnServerStartup.NO.getReinitiateFlag();
	}
	
	
	public SchedulerJobDto(String id,Date executionDate,String userEmail,Object additionalData,Repeat repeat,ReInitiateOnServerStartup reInitiate) {
		this.jobId = id;
		this.executionDate = executionDate;
		this.userEmail = userEmail;
		this.repeat = repeat;
		this.reInitiateOnServerStartup = reInitiate.getReinitiateFlag();
		setData(additionalData);
	}
	
	public SchedulerJobDto(String id,Date executionDate,String userEmail,Object additionalData,Object moreData,Repeat repeat,ReInitiateOnServerStartup reInitiate) {
		this.jobId = id;
		this.executionDate = executionDate;
		this.userEmail = userEmail;
		this.repeat = repeat;
		this.reInitiateOnServerStartup = reInitiate.getReinitiateFlag();
		setData(additionalData);
		setExtraData(moreData);
	}
	
	@Getter
	@Setter
	@XmlElement(name = "UserEmail")
	@JsonProperty(value = "UserEmail")
	private String userEmail;
	
	@Getter
	@Setter
	@XmlElement(name = "ReInitiateOnServerStartup")
	@JsonProperty(value = "ReInitiateOnServerStartup")
	private String reInitiateOnServerStartup;
	
	@Getter
	@Setter
	@XmlElement(name = "JobID")
	@JsonProperty(value = "JobID")
	private String jobId;
	
	@Getter
	@Setter
	@XmlElement(name = "JobData")
	@JsonProperty(value = "JobData")
	private String jobData;
	
	@Getter
	@Setter
	@XmlElement(name = "AdditionalData")
	@JsonProperty(value = "AdditionalData")
	private String additionalData;
	
	@Getter
	@Setter
	@XmlElement(name = "ExecutionDate")
	@JsonProperty(value = "ExecutionDate")
	private Date executionDate;
	
	@XmlElement(name = "Repeat")
	@JsonProperty(value = "Repeat")
	private Repeat repeat;
	public Repeat getRepeat() {
		if(repeat==null && repeatFrequency!=null){
			return Repeat.getRepeatOf(repeatFrequency);
		}
		return repeat;
	}
	public void setRepeat(Repeat repeat) {
		this.repeat = repeat;
		this.repeatFrequency = repeat.getRepeatFrequency();
	}
	
	
	private Integer repeatFrequency;
	public Integer getRepeatFrequency() {
		if(repeat==null && repeatFrequency!=null){
			return repeatFrequency;
		}else if(repeat!=null){
			return repeat.getRepeatFrequency();
		}else{
			return 0;
		}
	}
	public void setRepeatFrequency(Integer repeatFrequency) {
		this.repeatFrequency = repeatFrequency;
		this.repeat=Repeat.getRepeatOf(repeatFrequency);
	}
	
	
	@Getter
	@Setter
	@XmlElement(name = "StatusId")
	@JsonProperty(value = "StatusId")
	private long statusId;
	
	@Getter
	@Setter
	@XmlElement(name = "LastUpdated")
	@JsonProperty(value = "LastUpdated")
	private Date lastUpdated;
	
	@Getter
	@Setter
	private String category;
	
	@Getter
	@Setter
	private String jobCategory;
	
	@Getter
	@Setter
	private String addtionalCategory;
	
	public void setData(Object dataObject){
		category = dataObject.getClass().getName();
		jobData = CommonUtils.getJsonFromObject(dataObject);
	}
	public Object getData(){
		try {
			return CommonUtils.getObjectFromJSON(jobData, Class.forName(category));
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}
	
	public void setExtraData(Object dataObject){
		addtionalCategory = dataObject.getClass().getName();
		additionalData = CommonUtils.getJsonFromObject(dataObject);
	}
	public Object getExtraData(){
		try {
			return CommonUtils.getObjectFromJSON(additionalData, Class.forName(addtionalCategory));
		} catch (NullPointerException | ClassNotFoundException | IOException e) {
			return null;
		}
	}
}
