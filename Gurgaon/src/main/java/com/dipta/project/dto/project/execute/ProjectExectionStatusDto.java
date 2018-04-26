package com.dipta.project.dto.project.execute;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProjectExectionStatusDto {

	@Getter
	@Setter
	private Long projectId;
	
	
	
	
	@Getter
	@Setter
	private Date executedOn;
	
	
	
	@Getter
	@Setter
	private String comments;
	
	
	@Getter
	@Setter
	private Date dateCreated;
}
