package com.dipta.project.user;

import java.io.Serializable;

import javax.persistence.Column;
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
 * This class is used to store user database information.
 * @author Saurabh.Agarwal
 *
 */
@XmlRootElement(name = "User")
@JsonRootName(value = "User")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({UserRolesDto.class, ClientDto.class})
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7013389901424141076L;

	@Getter
	@Setter
	@JsonProperty(value = "UserId")
	@XmlElement(name = "UserId")
	private long id;
	
	@Getter
	@Setter
	@XmlElement(name = "Email")
	@JsonProperty(value = "Email")
	private String email;
	
	@Getter
	@Setter
	@XmlElement(name = "FirstName")
	@JsonProperty(value = "FirstName")
	private String firstName;
	
	@Getter
	@Setter
	@XmlElement(name = "LastName")
	@JsonProperty(value = "LastName")
	private String lastName;
	
	@Getter
	@Setter
	@XmlElement(name = "CompanyName")
	@JsonProperty(value = "CompanyName")
	private String companyName;
	
	@Getter
	@Setter
	@XmlElement(name = "JobTitle")
	@JsonProperty(value = "JobTitle")
	private String jobTitle;
	
	@Getter
	@Setter
	@XmlElement(name = "Mobile")
	@JsonProperty(value = "Mobile")
	private String mobile;
	
	@Getter
	@Setter
	@XmlElement(name = "Status")
	@JsonProperty(value = "Status")
	private UserStatusDto status;
	
	@Getter
	@Setter
	@XmlElement(name = "StatusMaster")
	@JsonProperty(value = "StatusMaster")
	private StatusDto statusMaster;
	
	
	/*@Getter
	@Setter
	//private List<RolesDomain> userRoles = new ArrayList<RolesDomain>();
	private RolesDomain userRole ;*/
	
	@Getter
	@Setter
	@XmlElement(name = "AUTHENTICATIONTOKEN")
	@JsonProperty(value = "AUTHENTICATIONTOKEN")
	private String token;
	
	@Getter
	@Setter
	@XmlElement(name = "UserRole")
	@JsonProperty(value = "UserRole")
	private UserRolesDto userRole ;
	
	@Getter
	@Setter
	@XmlElement(name = "CreatedBy")
	@JsonProperty(value = "CreatedBy")
	private String createdBy;
	
	@Getter
	@Setter
	@XmlElement(name = "Client")
	@JsonProperty(value = "Client")

	private ClientDto client;
	
	
	@Getter
	@Setter
	@XmlElement(name = "RecaptchaResponse")
	@JsonProperty(value = "RecaptchaResponse")
	private String recaptchaResponse;
	
	@Getter
	@Setter
	@XmlElement(name = "ClientId")
	@JsonProperty(value = "ClientId")
	@Column(name="CLIENT_ID")
	private Long companyId;
	
	@Getter
	@Setter
	@XmlElement(name = "ActivationKey")
	@JsonProperty(value = "ActivationKey")
	private String activationKey;
}
