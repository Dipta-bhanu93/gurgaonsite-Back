package com.dipta.project.domain.api;

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
@Table(name = "CLIENT_DATA")
public class ClientDataDomain {
	@Getter
	@Setter
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ENTITYID")
	@SequenceGenerator(name="SEQ_ENTITYID", sequenceName="SEQ_ENTITYID")
	private Long id;

	@Column(name = "NAME")
	@Getter
	@Setter
	private String name;

	
	

	@Column(name = "COUNTRY")
	@Getter
	@Setter
	private String country;
	
	@Column(name = "SERIAL_NO")
	@Getter
	@Setter
	private String uniqueId;
	
	/*
	@Column(name = "PARTYTYPE")
	@Getter
	@Setter
	private String partyType;

	@Column(name = "PARTYSUBTYPE")
	@Getter
	@Setter
	private String partySubType;
*/	
	@Getter
	@Setter
	@Column(name="USERID")
	Long userID;

	
}
