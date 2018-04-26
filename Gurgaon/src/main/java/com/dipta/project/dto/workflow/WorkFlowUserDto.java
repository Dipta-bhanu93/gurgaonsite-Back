/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "WorkFlowUserInformation")
@JsonRootName(value = "WorkFlowUserInformation")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@XmlSeeAlso({HashMap.class})
public class WorkFlowUserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5056917160625183541L;

	@Getter
	@Setter
	@JsonProperty(value = "UserId")
	@XmlElement(name = "UserId")
	private Long id;;
	
	@Getter
	@Setter
	@JsonProperty(value = "UserName")
	@XmlElement(name = "UserName")
	private String userName;
	
	@Getter
	@Setter
	@JsonProperty(value = "UserList")
	@XmlElementWrapper(name = "UserList")
    private List<WorkFlowUserDto> list;
	
	@Getter
	@Setter
	@JsonProperty(value = "Count")
	@XmlElement(name = "Count")
	private Long count;
	
	@Getter
	@Setter
	@JsonProperty(value = "RoleID")
	@XmlElement(name = "RoleID")
	private Long roleID;
	
	@Getter
	@Setter
	@JsonProperty(value = "RoleType")
	@XmlElement(name = "RoleType")
	private String roleType;
	
	
}