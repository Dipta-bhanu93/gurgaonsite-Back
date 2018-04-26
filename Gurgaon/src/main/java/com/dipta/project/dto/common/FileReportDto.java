/**
 * 
 */
package com.dipta.project.dto.common;

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
 * @author savita.khurana
 *
 */
@XmlRootElement(name = "TableDto")
@JsonRootName(value = "TableDto")
@XmlAccessorType(XmlAccessType.NONE)
public class FileReportDto {
	@Getter	@Setter	@XmlElement(name = "Header")	@JsonProperty(value = "Header")
	private RowDto header;
	@Getter	@Setter	@XmlElement(name = "DataRows")	@JsonProperty(value = "DataRows")
	private List<RowDto> dataRows;
	@Getter	@Setter	@XmlElement(name = "ReportName")	@JsonProperty(value = "ReportName")
	private String reportName;
	@Getter	@Setter	@XmlElement(name = "Position")	@JsonProperty(value = "Position")
	private int position;
	
}
