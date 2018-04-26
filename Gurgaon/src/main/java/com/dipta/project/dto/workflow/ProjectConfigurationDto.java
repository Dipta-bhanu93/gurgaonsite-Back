package com.dipta.project.dto.workflow;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "ProjectConfigurationInfo")
@JsonRootName(value = "ProjectConfigurationInfo")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class ProjectConfigurationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@JsonProperty(value = "ProjectSaved")
	@XmlElement(name = "ProjectSaved")
	private boolean projectSaved;
	
	@Getter
	@Setter
	@JsonProperty(value = "ResultAttributeSaved")
	@XmlElement(name = "ResultAttributeSaved")
	private boolean resultAttributeSaved;
	
	@Getter
    @Setter
    @JsonProperty(value = "AdditionalDataAttributeSaved")
    @XmlElement(name = "AdditionalDataAttributeSaved")
    private boolean additionalDataAttributeSaved;
	
	
}
