package com.dipta.project.domain.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cascade;

import com.dipta.project.domain.acl.RolesDomain;

/**
 * This class is used to store user information.
 * @author Saurabh.Agarwal
 *
 */
@Entity
@Table(name = "user_info")
public class UserDomain {
	/*
	 USER_ID      NOT NULL NUMBER         
EMAIL_ID     NOT NULL NVARCHAR2(254) 
FIRST_NAME            NVARCHAR2(50)  
LAST_NAME             NVARCHAR2(50)  
COMPANY_NAME          NVARCHAR2(100) 
JOB_TITLE             NVARCHAR2(100) 
PASSWORD              NVARCHAR2(100) 
MOBILE_NO             NVARCHAR2(50) 
	 */
	@Getter
	@Setter
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_USER_ID")
	@SequenceGenerator(name="SEQ_USER_ID", sequenceName="SEQ_USER_ID")
	private long id;
	
	@Getter
	@Setter
	@Column(name="EMAIL_ID")
	private String email;
	
	@Getter
	@Setter
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Getter
	@Setter
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Getter
	@Setter
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Getter
	@Setter
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Getter
	@Setter
	@Column(name="MOBILE_NO")
	private String mobile;
	
	
	@Getter
	@Setter
	@Column(name="WRONGCOUNT")
	private Integer wrongCount=0;
	
	@Getter
	@Setter
	@OneToOne(mappedBy="user" , fetch = FetchType.EAGER)
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private UserStatusDomain status;
	
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	@Getter
	@Setter
	private RolesDomain userRole ;
	

	@Getter
	@Setter
	@OneToOne(fetch = FetchType.EAGER)
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "STATUS_ID")
	private StatusDomain statusMaster;
	
	@Getter
	@Setter
	@Column(name="USER_ID_CREATED")
	private String createdBy;
	
	@Getter
	@Setter
	@Column(name="DATE_CREATED")
	private Date dateCreated;
	
	
	@Getter
	@Setter
	@Column(name="CLIENT_ID")
	private Long companyId;
	
	@Getter
	@Setter
	@Column(name="ACTIVATIONKEY")
	private String activationKey;
}
