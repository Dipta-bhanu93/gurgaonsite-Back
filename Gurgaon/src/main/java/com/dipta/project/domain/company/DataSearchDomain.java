package com.dipta.project.domain.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DATA_SEARCH")
public class DataSearchDomain {
 
 @Getter @Setter @Column(name="CPTY_ID") @Id private Long id ;
 
 @Getter @Setter @Column(name="CDI_CDID") private String cdid ;
 @Getter @Setter @Column(name="COUNTRY") private String country ;
 @Getter @Setter @Column(name="CUSIP") private String cusip ;
 @Getter @Setter @Column(name="DOMICILECNTRY") private String domicilecntry ;
 @Getter @Setter @Column(name="DOMICILECNTRYDESC") private String domicilecntryDesc ;
 @Getter @Setter @Column(name="ENTITYID") private String entityId ;
 @Getter @Setter @Column(name="ISIN") private String isin ;
 @Getter @Setter @Column(name="KEYDATA") private String identifier ;
 @Getter @Setter @Column(name="KEYVALUE") private String identifierValue ;
 @Getter @Setter @Column(name="LEGALNAME") private String legalname ;
 @Getter @Setter @Column(name="LEINUMBER") private String leiNumber ;
 @Getter @Setter @Column(name="MATCHINGSCORE") private String matchingScore ;
 @Getter @Setter @Column(name="MATCHSTATUS") private String matchStatus ;
 @Getter @Setter @Column(name="MATCHSTATUSDESC") private String matchStatusDesc ;
 @Getter @Setter @Column(name="NAME") private String name ;
 @Getter @Setter @Column(name="PROJECTID") private String projectid ;
 @Getter @Setter @Column(name="PROJECTNAME") private String projectName ;
 @Getter @Setter @Column(name="SEDOL") private String sedol ;
 @Getter @Setter @Column(name="SERIALNO") private String serialNo ;
 @Getter @Setter @Column(name="TEMPLATE_ID") private Long templateId ;
 @Getter @Setter @Column(name="USERID") private String userid ;
 @Getter @Setter @Column(name="USER_CDID") private String userCdid ;
 
 

}