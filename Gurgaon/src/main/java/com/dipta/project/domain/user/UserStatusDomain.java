package com.dipta.project.domain.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@Entity
@Table(name = "User_status")
public class UserStatusDomain {
	private static int seq=0;
/*
	USER_ID         NOT NULL NUMBER        
	STATUS_ID                NUMBER        
	PASSWORD        NOT NULL NVARCHAR2(20) 
	PASSWORD_EXPIRY NOT NULL DATE          
	LAST_LOGIN      NOT NULL DATE*/
	
	@Id
    @Column(name="USER_ID", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="user")})
	private long id;
	
	@Getter
	@Setter
	@OneToOne
    @PrimaryKeyJoinColumn 
    private UserDomain user;
//    private User user;
	
	@Getter
	@Setter
	@Column(name="PASSWORD")
	private String password;
	
	@Getter
	@Setter
	@Column(name="PASSWORD_EXPIRY")
	private Timestamp passwordExpiry;
	
	@Getter
	@Setter
	@Column(name="LAST_LOGIN")
	private Timestamp lastLogin;
	
	@Getter
	@Setter
	@Column(name="STATUS_ID")
	private Integer statusId;
	
	
	@Getter
	@Setter
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
//	@Getter
//	@Setter
//	@OneToOne(cascade = CascadeType.ALL)
//	private StatusDomain status;
	
//	public void setStatusId(int id){
//		StatusDomain statusDomain = new StatusDomain();
//		statusDomain.setId(id);
//		setStatus(statusDomain);
////		setId(seq++);
//	}
}
