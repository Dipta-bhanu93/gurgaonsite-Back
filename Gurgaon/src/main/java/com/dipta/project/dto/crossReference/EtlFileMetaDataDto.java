package com.dipta.project.dto.crossReference;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.utility.CharacterAdapter;


/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "EtlFileMetaDataInformation")
@JsonRootName(value = "EtlFileMetaDataInformation")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class EtlFileMetaDataDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "FileMetadataId")
	@JsonProperty(value = "FileMetadataId")
	private long fileMetadataId;
	
	@Getter
	@Setter
	@XmlElement(name = "FileId")
	@JsonProperty(value = "FileId")
	private long fileId; 
	
	@Getter
	@Setter
	@XmlElement(name = "FileName")
	@JsonProperty(value = "FileName")
	private String fileName; 
	
	@Getter
	@Setter
	@XmlElement(name = "FileExtension")
	@JsonProperty(value = "FileExtension")
	private String fileExtension; 
	
	@Getter
	@Setter
	@XmlElement(name = "FileDelimiter")
	@JsonProperty(value = "FileDelimiter")
	private String fileDelimiter; 
	
	@Getter
	@Setter
	@XmlElement(name = "BSkipRows")
	@JsonProperty(value = "BSkipRows")
	private long bSkipRows;
	
	@Getter
	@Setter
	@XmlElement(name = "ESkipRows")
	@JsonProperty(value = "ESkipRows")
	private long eSkipRows;
	
	@Getter
	@Setter
	@XmlElement(name = "GoldDataFlag")
	@JsonProperty(value = "GoldDataFlag")
	@XmlJavaTypeAdapter(CharacterAdapter.class)
	private Character goldDataFlag; 
	
	@Getter
	@Setter
	@XmlElement(name = "CustomerDataFlag")
	@JsonProperty(value = "CustomerDataFlag")
	@XmlJavaTypeAdapter(CharacterAdapter.class)
	private Character customerDataFlag; 
	
	@Getter
	@Setter
	@XmlElement(name = "FileContainsHeaders")
	@JsonProperty(value = "FileContainsHeaders")
	@XmlJavaTypeAdapter(CharacterAdapter.class)
	private Character fileContainsHeaders;

	@Override
	public String toString() {
		return "EtlFileMetaDataDto [fileMetadataId=" + fileMetadataId
				+ ", fileId=" + fileId + ", fileName=" + fileName
				+ ", fileExtension=" + fileExtension + ", fileDelimiter="
				+ fileDelimiter + ", bSkipRows=" + bSkipRows + ", eSkipRows="
				+ eSkipRows + ", goldDataFlag=" + goldDataFlag
				+ ", customerDataFlag=" + customerDataFlag
				+ ", fileContainsHeaders=" + fileContainsHeaders + "]";
	}

	
	
}
