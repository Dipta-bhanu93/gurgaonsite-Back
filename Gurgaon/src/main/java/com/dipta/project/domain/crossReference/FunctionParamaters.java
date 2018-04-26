package com.dipta.project.domain.crossReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "CDI_FUNC_PARAMETERS")
public class FunctionParamaters {

	@Getter                   
	@Setter                   
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_etl_func_parameters")
	@SequenceGenerator(name="SEQ_etl_func_parameters", sequenceName="SEQ_etl_func_parameters")
	private long id;
	
	@Getter                   
	@Setter                   
	@Column(name = "SRC_TRGT_ID")
	private long sourceTargetId;
	
	@Getter                   
	@Setter                   
	@Column(name = "RULE_ID")
	private long ruleId;
	
	@Getter                   
	@Setter                   
	@Column(name = "SEPARATOR")
	private String separator;
	
	@Getter                   
	@Setter                   
	@Column(name = "TABLENAME")
	private String tableName;
	
	@Getter                   
	@Setter                   
	@Column(name = "TARGETCOLUMN")
	private String targetColumn;
	
	@Getter                   
	@Setter                   
	@Column(name = "SOURCECOLUMN")
	private String sourceColumn;
	
	@Getter                   
	@Setter                   
	@Column(name = "UPDATEVALUE")
	private String updateValue;
}
