/**
 * 
 */
package com.dipta.project.domain.acl;

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

/**
 * @author Ashish.Patel
 *
 */

@Entity
@Table(name = "MODULE_PRIVILEGES_RELATION")
public class ModulePrivilegesRelationDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_MODULE_PRIVS_ID")
	@SequenceGenerator(name="SEQ_MODULE_PRIVS_ID", sequenceName="SEQ_MODULE_PRIVS_ID")
	@Column(name = "MODULE_PRIVS_ID")
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="MODULE_ID") 
	private ModuleMasterDomain module;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="PRIVILEGE_ID") 
	private PrivilegesMasterDomain privilege;
	
	@Getter
	@Setter
	@Column(name="ACTIVE")
	private char active;
	
	@Getter
	@Setter
	@Column(name="ACCESS_DESC")
	private String accessDesc;
}