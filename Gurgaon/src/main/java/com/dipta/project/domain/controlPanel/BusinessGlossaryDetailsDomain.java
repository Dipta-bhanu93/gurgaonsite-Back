package com.dipta.project.domain.controlPanel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dipta.project.domain.project.CodAttributesDomain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dipta.Kanjilal
 *
 */
@Entity
@Table(name="BUSINESS_GLOSSARY_DETAILS")
public class BusinessGlossaryDetailsDomain {
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name="COD_REF_ID",referencedColumnName ="ID")
	private CodAttributesDomain codAttribute;
	
	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Getter
	@Setter
	@Column(name="DESCRIPTION")
	private String desc;
	
	@Getter
	@Setter
	@Column(name="TEMPLATE_ID")
	private Integer templateId;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name="GLOSSARY_REFID")
	private List<BusinessGlossaryConfigDomain> businessGlossary=new ArrayList<BusinessGlossaryConfigDomain>();
	
}
