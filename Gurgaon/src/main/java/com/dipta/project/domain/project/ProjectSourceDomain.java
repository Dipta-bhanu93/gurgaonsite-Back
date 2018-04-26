package com.dipta.project.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@Entity
@Table(name = "SOURCE_TYPE")
public class ProjectSourceDomain {

	@Getter
	@Setter
	@Id
	@Column(name = "SOURCE_ID")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "SOURCE_NAME")
	private String name;
}