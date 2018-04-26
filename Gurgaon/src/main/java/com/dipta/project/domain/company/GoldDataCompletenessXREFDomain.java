/**
 * 
 */
package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aditya.julka
 *
 */

@Entity
@Table(name = "XREF_VENN")
public class GoldDataCompletenessXREFDomain {

	
	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private Integer id;
	
/*	@Getter
	@Setter
	@Column(name="FEEDNAME")
	private String feedName;
	
	@Getter
	@Setter
	@Column(name="ATTRIBUTE_NAME")
	private String attributeName;	
	
	@Getter
	@Setter
	@Column(name="ATTRIBUTE_NAME")
	private String  attributeObj;	
	
	@Getter
	@Setter
	@Column(name="CNT")
	private int count;	
*/
	@Getter
	@Setter
	@Column(name="FEED_TYPE")
	private String label;
	
	@Getter
	@Setter
	@Column(name="NO_OF_RECORD")
	private Integer size;	

	
	@Getter
	@Setter
	@Column(name="INDENTIFIER")
	private String identifier;	
	
	
}
