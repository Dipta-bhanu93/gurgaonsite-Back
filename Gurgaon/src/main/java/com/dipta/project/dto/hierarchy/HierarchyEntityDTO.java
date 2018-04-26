package com.dipta.project.dto.hierarchy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dipta.Kanjilal
 *
 */
@XmlRootElement(name="Hierarchy")
@JsonRootName(value = "Hierarchy")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlSeeAlso({LinkedHashMap.class,ArrayList.class})
public class HierarchyEntityDTO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@JsonProperty(value = "Id")
	@XmlElement(name = "Id")
	private long id;
	
	@Getter
	@Setter
	@JsonProperty(value = "EntityId")
	@XmlElement(name = "EntityId")
	private long entityId;
	
	@Getter
	@Setter
	@JsonProperty(value = "SerialNo")
	@XmlElement(name = "SerialNo")
	private String serialNo;
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectId")
	@XmlElement(name = "ProjectId")
	private long projectId;
	
	@Getter
	@Setter
	@JsonProperty(value = "Cdid")
	@XmlElement(name = "Cdid")
	private long cdid;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "UpCdid")
	@XmlElement(name = "UpCdid")
	private long upCdid;
	
	@Getter
	@Setter
	@JsonProperty(value = "Name")
	@XmlElement(name = "Name")
	private String name;
	
	/*@Getter
	@Setter
	@JsonProperty(value = "HierarchyQuery")
	@XmlElement(name = "HierarchyQuery")
	private String hierarchyQuery;*/
	
	@Getter
	@Setter
	@JsonProperty(value = "RefernceType")
	@XmlElement(name = "RefernceType")
	private String refernceType;
	
//    @Getter
//	@Setter
//	@JsonProperty(value = "HierarchyTreeViewData")
//	@XmlElement(name = "HierarchyTreeViewData")
//	private List<LinkedHashMap<String,Object>> hierarchyTreeViewData;
	
    @Getter
   	@Setter
   	@JsonProperty(value = "HierarchyTreeViewDataLegal")
   	@XmlElement(name = "HierarchyTreeViewDataLegal")
   	private List<LinkedHashMap<String,Object>> hierarchyTreeViewDataLegal;
    
    @Getter
   	@Setter
   	@JsonProperty(value = "HierarchyTreeViewDataBusiness")
   	@XmlElement(name = "HierarchyTreeViewDataBusiness")
   	private List<LinkedHashMap<String,Object>> hierarchyTreeViewDataBusiness;
	
}
