package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CDI_INFO_WIDG_TENANT")
public class GoldDataCoverageDomain {
	
	@Getter @Setter @Column(name="ID") @Id private Long id ;
	@Getter @Setter @Column(name="TYPE")  private String type ;
	@Getter @Setter @Column(name="VALUE") private String label ;
	@Getter @Setter @Column(name="COUNT") private long value ;
	@Getter @Setter @Column(name="DISPLAY_LABEL") private String displayLabel ;

}
