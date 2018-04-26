package com.dipta.project.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.caucho.quercus.lib.spl.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vinay.Kumar1
 *
 */
@Entity
@Table(name = "COD_ATTRIBUTES")
public class CodAttributesDomain implements java.io.Serializable {

	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	private long id;
	
	
	@Getter
	@Setter
	@Column(name = "CATEGORY_TYPE")
	private String type;
	
	@Getter
	@Setter
	@Column(name = "CATEGORY_DISPLAY_NAME")
	private String typeDisplayName;
	
	@Getter
	@Setter
	@Column(name = "ATTRIBUTE")
	private String attribute;
	
	@Getter
	@Setter
	@Column(name = "ATTRIBUTE_DISPLAY_NAME")
	private String attributeText;
	
	
	@Getter
	@Setter
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Getter
	@Setter
	@Column(name = "DEFAULT_FLAG")
	private String defaultFlag;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodAttributesDomain other = (CodAttributesDomain) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
