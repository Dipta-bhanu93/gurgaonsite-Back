package com.dipta.project.domain.acl;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "ROLE_MODULE_PRIVILEGES")
public class RolePrivilegesDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ROLE_MOD_PRIVIL")
	@SequenceGenerator(name="SEQ_ROLE_MOD_PRIVIL", sequenceName="SEQ_ROLE_MOD_PRIVIL")
	@Column(name = "ROLE_PRIVS_ID")
	@Getter
	@Setter
	private Long id;

	@Column(name = "ROLE_ID")
	@Getter
	@Setter
	private Long roleId;
	
	/*@ManyToOne
	@Getter
	@Setter
	private RolesDomain role;
	 */
	
	//@Column(name = "MODULE_ID")
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="MODULE_ID") 
	private ModuleMasterDomain module;
	
	
	//@Column(name = "PRIVILEGE_ID")
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="PRIVILEGE_ID") 
	private PrivilegesMasterDomain privilege;
	
	
	
	@Getter
	@Setter
	@Column(name="USER_ID_CREATED")
	private Long userCreated;
	
	@Getter
	@Setter
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name="ACTIVE")
	private char active;
}
