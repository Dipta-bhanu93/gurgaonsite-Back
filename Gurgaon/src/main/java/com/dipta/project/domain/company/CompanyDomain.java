package com.dipta.project.domain.company;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMPANY_REGISTRATION")
public class CompanyDomain {

	@Getter
	@Setter
	@Id
	@Column(name="CO_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Seq_client")
	@SequenceGenerator(name="Seq_client", sequenceName="Seq_client")
	private long id;
	
	@Getter
	@Setter
	@Column(name="NAME")
	private String name;
	
	@Getter
	@Setter
	@Column(name="ADDRESS")
	private String address;
	
	@Getter
	@Setter
	@Column(name="CITY")
	private String city;
	
	@Getter
	@Setter
	@Column(name="STATE")
	private String state;
	
	@Getter
	@Setter
	@Column(name="COUNTRY")
	private String country;
	
	@Getter
	@Setter
	@Column(name="ZIP")
	private String zip;
	
	@Getter
	@Setter
	@Column(name="PHONE")
	private String phone;
	
	@Getter
	@Setter
	@Column(name="CORPORATE_EMAIL")
	private String corporateEmail;
	
	@Getter
	@Setter
	@Column(name="USER_ID_CREATED")
	private Long userCreated;
	
	@Getter
	@Setter
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name="STATUS")
	private int statusId;
	
	
	@Getter
	@Setter
	@Column(name="NDA_FILE_ID")
	private Integer fileId;
	
	@Getter
	@Setter
	@Column(name = "NDA_FLAG")
	private String ndaFlag;
}
