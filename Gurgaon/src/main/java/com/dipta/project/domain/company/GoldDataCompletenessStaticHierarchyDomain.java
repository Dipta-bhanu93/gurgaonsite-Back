/**
 * 
 */
package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

//import com.dipta.project.domain.lei.LEIDomain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aditya.julka
 *
 */

@Entity
@Table(name = "HIERARCHY_PIE")
public class GoldDataCompletenessStaticHierarchyDomain {

	
	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private Integer id;
	

	@Getter
	@Setter
	@Column(name="NAME")
	private String name;
	
	@Getter
	@Setter
	@Column(name="ENTITY_COUNT")
	private Integer count;	

	
	@Getter
	@Setter
//	@OneToOne
//	@Cascade(value=org.hibernate.annotations.CascadeType.ALL) 
	@Column(name="UP_CDID")
	private Integer cdid;	
	
	@Getter
	@Setter
	@Column(name="COUNTRY")
	private String country;	
	
	
}
