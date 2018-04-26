package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Ashish.Patel
 *
 */

@Entity
@Table(name = "ENTITY_STATUS_MASTER")
public class EntityStatusMasterDomain {

	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private Long id;
	
	@Getter
	@Setter
	@Column(name="DESCRIPTION")
	private String Description;
	
	@Getter
	@Setter
	@Column(name="DISPLAY_DESC")
	private String displayDesc;
	
}
