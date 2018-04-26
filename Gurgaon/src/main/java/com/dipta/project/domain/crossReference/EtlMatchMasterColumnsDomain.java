/**
 * 
 */
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
 * @author santosh.panigrahi
 * 
 * This Class will represent Domain Object for master column list required for matching service.
 *
 */
@Entity
@Table(name = "CDI_MATCH_COLUMNS")
public class EtlMatchMasterColumnsDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_matching_master_column")
	@SequenceGenerator(name="SEQ_matching_master_column", sequenceName="SEQ_matching_master_column")
	private long id;
	
	
	@Getter
	@Setter
	@Column(name = "SOURCE_TABLE_NAME")
	private String sourceTableName;
	
	@Getter
	@Setter
	@Column(name = "SOURCE_COLUMN_NAME")
	private String sourceColumnName;
	
	@Getter
	@Setter
	@Column(name = "TARGET_TABLE_NAME")
	private String targetTableName;
	
	@Getter
	@Setter
	@Column(name = "TARGET_COLUMN_NAME")
	private String targetColumnName;
	
	@Getter
	@Setter
	@Column(name = "FEEDTYPE")
	private String feedType;
	
	

}
