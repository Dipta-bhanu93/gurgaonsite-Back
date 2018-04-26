package com.dipta.project.dto.project.template;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ashish.Patel
 *
 */

@XmlRootElement(name = "ProjectTemplateSearchGridInformation")
@JsonRootName(value = "ProjectTemplateSearchGridInformation")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ProjectTemplateGridData.class, ProjectTemplateGridHeader.class})
public class ProjectTemplateSearchGridDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectTemplateGridHeaderLst")
	@JsonProperty(value = "ProjectTemplateGridHeaderLst")
	private List<ProjectTemplateGridHeader> projectTemplateGridHeaderLst;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectTemplateGridDataLst")
	@JsonProperty(value = "ProjectTemplateGridDataLst")
	private List<ProjectTemplateGridData> projectTemplateGridDataLst;
	
	@Getter
	@Setter
	@XmlElement(name = "TotalCountSum")
	@JsonProperty(value = "TotalCountSum")
	private Long totalCountSum;
	
	@Getter
	@Setter
	@XmlElement(name = "MatchCountSum")
	@JsonProperty(value = "MatchCountSum")
	private Long matchCountSum;
	
	@Getter
	@Setter
	@XmlElement(name = "PotentialMatchCountSum")
	@JsonProperty(value = "PotentialMatchCountSum")
	private Long potentialMatchCountSum;
	
	@Getter
	@Setter
	@XmlElement(name = "NoMatchCountSum")
	@JsonProperty(value = "NoMatchCountSum")
	private Long noMatchCountSum;
	
	
	
	@Getter
	@Setter
	@XmlElement(name = "ActiveCount")
	@JsonProperty(value = "ActiveCount")
	private Long activeCount= 0l;
	
	@Getter
	@Setter
	@XmlElement(name = "NewCount")
	@JsonProperty(value = "NewCount")
	private Long newCount = 0l;
	
	/*@Getter
	@Setter
	@XmlElement(name = "ExceptionsCountSum")
	@JsonProperty(value = "ExceptionsCountSum")
	private Long exceptionsCountSum;*/

}
