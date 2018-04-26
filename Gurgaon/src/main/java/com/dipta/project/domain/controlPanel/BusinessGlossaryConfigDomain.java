package com.dipta.project.domain.controlPanel;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dipta.Kanjilal
 *
 */
@Entity
@Table(name="BUSINESS_GLOSSARY_CONFIG")
public class BusinessGlossaryConfigDomain {

	@Getter
	@Setter
	@Id
	@Column(name="ID")
	private BigDecimal id;
	
	@Getter
	@Setter
	@Column(name="GLOSSARY_REFID")
	private Integer glossaryRefId;
	
	@Getter
	@Setter
	@Column(name="ATTRIBUTE_KEY")
	private String attributeKey;
	
	@Getter
	@Setter
	@Column(name="ATTRIBUTE_VALUE")
	private String attributeValue;
	
}
