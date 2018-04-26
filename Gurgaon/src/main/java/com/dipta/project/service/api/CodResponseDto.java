package com.dipta.project.service.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "CodResponseDto")
@JsonRootName(value = "CodResponseDto")
@XmlAccessorType(XmlAccessType.NONE)
public class CodResponseDto {

	@Getter @Setter @XmlElement(name = "InputRequest") @JsonProperty(value = "InputRequest")  private CodApiRequest codApiRequest ;
	
	
	@Getter @Setter @XmlElement(name = "ExactMatchFound") @JsonProperty(value = "ExactMatchFound")  private String exactMatchFound ;
	
	@Getter @Setter @XmlElement(name = "CDID") @JsonProperty(value = "CDID")  private String CDID ;
	@Getter @Setter @XmlElement(name = "CDIDSentDate") @JsonProperty(value = "CDIDSentDate")  private String CDIDSentDate ;
	@Getter @Setter @XmlElement(name = "CountryofIncorporation") @JsonProperty(value = "CountryofIncorporation")  private String CountryofIncorporation ;
	@Getter @Setter @XmlElement(name = "CountryofRisk") @JsonProperty(value = "CountryofRisk")  private String CountryofRisk ;
	@Getter @Setter @XmlElement(name = "LegalName") @JsonProperty(value = "LegalName")  private String LegalName ;
	@Getter @Setter @XmlElement(name = "LEI") @JsonProperty(value = "LEI")  private String LEI ;
	@Getter @Setter @XmlElement(name = "NACE") @JsonProperty(value = "NACE")  private String NACE ;
	@Getter @Setter @XmlElement(name = "OutofScope") @JsonProperty(value = "OutofScope")  private String OutofScope ;
	@Getter @Setter @XmlElement(name = "SecurityReceiveddate") @JsonProperty(value = "SecurityReceiveddate")  private String SecurityReceiveddate ;
	@Getter @Setter @XmlElement(name = "SecuritySentdate") @JsonProperty(value = "SecuritySentdate")  private String SecuritySentdate ;
	@Getter @Setter @XmlElement(name = "UltimateParentCDID") @JsonProperty(value = "UltimateParentCDID")  private String UltimateParentCDID ;
	@Getter @Setter @XmlElement(name = "UltimateParentLEI") @JsonProperty(value = "UltimateParentLEI")  private String UltimateParentLEI ;
	@Getter @Setter @XmlElement(name = "UltimateParentName") @JsonProperty(value = "UltimateParentName")  private String UltimateParentName ;
	@Getter @Setter @XmlElement(name = "Alias") @JsonProperty(value = "Alias")  private String Alias ;
	@Getter @Setter @XmlElement(name = "BusinessAddress") @JsonProperty(value = "BusinessAddress")  private String BusinessAddress ;
	@Getter @Setter @XmlElement(name = "CompanyNumber") @JsonProperty(value = "CompanyNumber")  private String CompanyNumber ;
	@Getter @Setter @XmlElement(name = "CountryofReportingCurrency") @JsonProperty(value = "CountryofReportingCurrency")  private String CountryofReportingCurrency ;
	@Getter @Setter @XmlElement(name = "CUSIP") @JsonProperty(value = "CUSIP")  private String CUSIP ;
	@Getter @Setter @XmlElement(name = "DateofEstablishment") @JsonProperty(value = "DateofEstablishment")  private String DateofEstablishment ;
	@Getter @Setter @XmlElement(name = "EconomicParentCDID") @JsonProperty(value = "EconomicParentCDID")  private String EconomicParentCDID ;
	
	
	@Getter @Setter @XmlElement(name = "EconomicParentName") @JsonProperty(value = "EconomicParentName")  private String EconomicParentName ;
	@Getter @Setter @XmlElement(name = "EntityStatus") @JsonProperty(value = "EntityStatus")  private String EntityStatus ;
	@Getter @Setter @XmlElement(name = "FormerName") @JsonProperty(value = "FormerName")  private String FormerName ;
	@Getter @Setter @XmlElement(name = "ImmediateParentCDID") @JsonProperty(value = "ImmediateParentCDID")  private String ImmediateParentCDID ;
	@Getter @Setter @XmlElement(name = "ImmediateParentHolding") @JsonProperty(value = "ImmediateParentHolding")  private String ImmediateParentHolding ;
	@Getter @Setter @XmlElement(name = "ImmediateParentName") @JsonProperty(value = "ImmediateParentName")  private String ImmediateParentName ;
	@Getter @Setter @XmlElement(name = "IncorporationAuthority") @JsonProperty(value = "IncorporationAuthority")  private String IncorporationAuthority ;
	@Getter @Setter @XmlElement(name = "ISICCode") @JsonProperty(value = "ISICCode")  private String ISICCode ;
	@Getter @Setter @XmlElement(name = "ISICDescription") @JsonProperty(value = "ISICDescription")  private String ISICDescription ;
	@Getter @Setter @XmlElement(name = "LegalDescription") @JsonProperty(value = "LegalDescription")  private String LegalDescription ;
	@Getter @Setter @XmlElement(name = "LEIName") @JsonProperty(value = "LEIName")  private String LEIName ;
	@Getter @Setter @XmlElement(name = "LEIStatus") @JsonProperty(value = "LEIStatus")  private String LEIStatus ;
	@Getter @Setter @XmlElement(name = "ListedCounterpartyName") @JsonProperty(value = "ListedCounterpartyName")  private String ListedCounterpartyName ;
	@Getter @Setter @XmlElement(name = "LocationofResidence") @JsonProperty(value = "LocationofResidence")  private String LocationofResidence ;
	@Getter @Setter @XmlElement(name = "ModifiedDate") @JsonProperty(value = "ModifiedDate")  private String ModifiedDate ;
	@Getter @Setter @XmlElement(name = "NACEDescription") @JsonProperty(value = "NACEDescription")  private String NACEDescription ;
	@Getter @Setter @XmlElement(name = "NAICSCode") @JsonProperty(value = "NAICSCode")  private String NAICSCode ;
	@Getter @Setter @XmlElement(name = "NAICSDescription") @JsonProperty(value = "NAICSDescription")  private String NAICSDescription ;
	@Getter @Setter @XmlElement(name = "PartySubtype") @JsonProperty(value = "PartySubtype")  private String PartySubtype ;
	@Getter @Setter @XmlElement(name = "PartyType") @JsonProperty(value = "PartyType")  private String PartyType ;
	
	
	@Getter @Setter @XmlElement(name = "PrimarylistingExchange") @JsonProperty(value = "PrimarylistingExchange")  private String PrimarylistingExchange ;
	@Getter @Setter @XmlElement(name = "PrimaryRegulator") @JsonProperty(value = "PrimaryRegulator")  private String PrimaryRegulator ;
	@Getter @Setter @XmlElement(name = "PrimaryRegulatorID") @JsonProperty(value = "PrimaryRegulatorID")  private String PrimaryRegulatorID ;
	@Getter @Setter @XmlElement(name = "RegisteredAddress") @JsonProperty(value = "RegisteredAddress")  private String RegisteredAddress ;
	@Getter @Setter @XmlElement(name = "SICCode") @JsonProperty(value = "SICCode")  private String SICCode ;
	@Getter @Setter @XmlElement(name = "SICDescription") @JsonProperty(value = "SICDescription")  private String SICDescription ;
	@Getter @Setter @XmlElement(name = "Sourceurl") @JsonProperty(value = "Sourceurl")  private String Sourceurl ;
	@Getter @Setter @XmlElement(name = "StatusDate") @JsonProperty(value = "StatusDate")  private String StatusDate ;
	@Getter @Setter @XmlElement(name = "Statususer") @JsonProperty(value = "Statususer")  private String Statususer;
	@Getter @Setter @XmlElement(name = "SuccessorCDID") @JsonProperty(value = "SuccessorCDID")  private String SuccessorCDID ;
	@Getter @Setter @XmlElement(name = "SuccessorName") @JsonProperty(value = "SuccessorName")  private String SuccessorName ;
	@Getter @Setter @XmlElement(name = "SwiftCode") @JsonProperty(value = "SwiftCode")  private String SwiftCode ;
	@Getter @Setter @XmlElement(name = "TaxAuthorityType") @JsonProperty(value = "TaxAuthorityType")  private String TaxAuthorityType ;
	@Getter @Setter @XmlElement(name = "TaxFileId") @JsonProperty(value = "TaxFileId")  private String TaxFileId ;
	@Getter @Setter @XmlElement(name = "Ticker") @JsonProperty(value = "Ticker")  private String Ticker ;
	@Getter @Setter @XmlElement(name = "UserModified ") @JsonProperty(value = "UserModified ")  private String UserModified;
	@Getter @Setter @XmlElement(name = "ValidationFlag") @JsonProperty(value = "ValidationFlag")  private String ValidationFlag ;
	@Getter @Setter @XmlElement(name = "WebUrl") @JsonProperty(value = "WebUrl")  private String WebUrl ;
	@Getter @Setter @XmlElement(name = "Wefstatus  ") @JsonProperty(value = "Wefstatus")  private String Wefstatus;
	@Getter @Setter @XmlElement(name = "ISIN") @JsonProperty(value = "ISIN")  private String ISIN ;
	@Getter @Setter @XmlElement(name = "LEIEntityStatus") @JsonProperty(value = "LEIEntityStatus")  private String LEIEntityStatus ;
	
	

	

	
}
