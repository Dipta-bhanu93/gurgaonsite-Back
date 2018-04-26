package com.dipta.project.domain.acl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "MODULE_MASTER")
public class ModuleMasterDomain {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULE_ID")
	@Getter
	@Setter
	private Long moduleId;
	
	
	@Column(name = "MODULE_TXT")
	@Getter
	@Setter
	private String moduleTextValue;
	
	
	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	private String description;
	
}
