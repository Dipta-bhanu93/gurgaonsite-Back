package com.dipta.project.dto.hierarchy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name="HierarchySearchFilters")
@JsonRootName(value = "HierarchySearchFilters")
@XmlAccessorType(XmlAccessType.NONE)
public class HierarchySearchFilterDTO {
	
	

	@Getter
	@Setter
	@JsonProperty(value = "Cdid")
	@XmlElement(name = "Cdid")
	private long cdid;
	
	@Getter
	@Setter
	@JsonProperty(value = "SerialNo")
	@XmlElement(name = "SerialNo")
	private String serialNo;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "Filters")
	@XmlElement(name = "Filters")
	private String filters;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "ViewName")
	@XmlElement(name = "ViewName")
	private String viewName;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectID")
	@XmlElement(name = "ProjectID")
	private long projectID;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "UserID")
	@XmlElement(name = "UserID")
	private long userId;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "UltimateParent")
	@XmlElement(name = "UltimateParent")
	private long ultimateParent;


	@Override
	public String toString() {
		return "HierarchySearchFilterDTO [cdid=" + cdid + ", serialNo="
				+ serialNo + ", filters=" + filters + ", viewName=" + viewName
				+ ", projectID=" + projectID + ", userId=" + userId
				+ ", ultimateParent=" + ultimateParent + "]";
	}
	
	
	
}
