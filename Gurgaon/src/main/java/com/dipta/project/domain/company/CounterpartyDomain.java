package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "COUNTERPARTY")
public class CounterpartyDomain {
	
	@Getter @Setter @Column(name="CDID") @Id private String cdid ;
	@Getter @Setter @Column(name="LEGALNAME") private String legalname ;
	@Getter @Setter @Column(name="SHORTNAME") private String shortname ;
	@Getter @Setter @Column(name="CTRPRTYURL") private String ctrprtyurl ;
	@Getter @Setter @Column(name="TRADINGSTATUS") private String tradingStatus ;
	@Getter @Setter @Column(name="STOCKEXCHANGE") private String stockExchange ;
	@Getter @Setter @Column(name="LEGALFORM") private String legalform ;
	@Getter @Setter @Column(name="NUMEMPLOYEES") private Long numEmployees ;
	@Getter @Setter @Column(name="NUMSUBSIDIARIES") private Long numSubsidiaries ;
	@Getter @Setter @Column(name="NUMBRANCHES") private Long numBranches ;
	@Getter @Setter @Column(name="NUMOWNERSHIPS") private Long numOwnerships ;
	@Getter @Setter @Column(name="DATEINCORPORATED") private String dateincorporated ;
	@Getter @Setter @Column(name="DOMICILECNTRY") private String domicilecntry ;
	@Getter @Setter @Column(name="LEGALCNTRY") private String legalcntry ;
	@Getter @Setter @Column(name="RISKCTRY") private String riskcntry ;
	@Getter @Setter @Column(name="ABBRNAME") private String abbrname ;
	@Getter @Setter @Column(name="RANK") private Long rank ;
	@Getter @Setter @Column(name="STATUS") private String status ;
	@Getter @Setter @Column(name="FILEID") private Long fileId ;
	@Getter @Setter @Column(name="JURISDICTION") private String jurisdiction ;
	@Getter @Setter @Column(name="PARTYTYPE") private String partytype ;
	@Getter @Setter @Column(name="OBSOLETE_FLAG") private String obsoleteFlag ;
	@Getter @Setter @Column(name="NORMALIZED_LEGALNAME") private String normalizedLegalname ;
	@Getter @Setter @Column(name="DATEINCFORMAT") private String dateincFormat ;

}
