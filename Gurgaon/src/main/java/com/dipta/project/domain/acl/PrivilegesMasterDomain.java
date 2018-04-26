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
@Table(name = "PRIVILEGES_MASTER")
public class PrivilegesMasterDomain {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRIVILEGE_ID")
	@Getter
	@Setter
	private Long privilegeId;

	@Column(name = "PRIVILEGE_STRING")
	@Getter
	@Setter
	private String privilegeString ;
}
