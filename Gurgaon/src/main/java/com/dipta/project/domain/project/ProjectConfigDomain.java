package com.dipta.project.domain.project;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;


/**
 * 
 * @author Vinay.Kumar1
 * 
 */
@Entity
@Table(name = "PROJECT_CONFIGURATION")
public class ProjectConfigDomain {

/*	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private UserProjectDomain userProjectDomain;*/
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_id_prjct_conf")
	@SequenceGenerator(name="seq_id_prjct_conf", sequenceName="seq_id_prjct_conf")
	@Column(name = "ID")
	private long id;
	
	
	/*@Getter
	@Setter
	@ManyToOne
	private UserProjectDomain userProject;*/
	
	@Getter
	@Setter
	@Column(name = "PROJECT_ID")
	private long projectId;
		
	@Getter
	@Setter
	@Column(name = "ATTRIBUTE_ID")
	private long masterAttribId;
	
	
	@Getter
	@Setter
	@Column(name = "TYPE")
	private String type;
	
	
	@Getter
	@Setter
	@Column(name = "ATTRIBUTE")
	private String attribute;
	
	
	@Getter
	@Setter
	@Column(name = "VALUE")
	@Type(type="yes_no")
	private Boolean attributeValue;
	
	
	/*@Getter
	@Setter
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)  
  //  @org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE})
	public CodAttributesDomain codAttributesDomain;*/

	 @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof ProjectConfigDomain)) {
	            return false;
	        }
	        ProjectConfigDomain configObj = (ProjectConfigDomain) o;
	        return projectId == configObj.projectId &&
	                Objects.equals(type, configObj.type) &&
	                Objects.equals(attribute, configObj.attribute);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(projectId, type, attribute);
	    }
}
