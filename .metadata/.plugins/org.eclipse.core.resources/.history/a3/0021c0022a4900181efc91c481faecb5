package com.dipta.project.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.maintenance.api.IClientRequestMaintenance;
import com.dipta.project.maintenance.user.IUserMaintenance;
import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.constants.HttpStatusCodes;



@RestController
@RequestMapping("v1/api/lei")
public class CodLeiApiService {


	@Autowired
	IUserMaintenance userMaintenance;
	
	@Autowired
	IClientRequestMaintenance clientRequestMaintenance; 
	
	
	
	
	@RequestMapping(value = "/entities",
			method = RequestMethod.POST,
			headers="Accept=application/xml, application/json")
			public ResponseMessageDTO getAllEntitiesInfo(@RequestBody CodApiRequestDto codApiRequestDto) throws Exception {
			codApiRequestDto=clientRequestMaintenance.decodedURLObject(codApiRequestDto, codApiRequestDto.getSessionAccessToken());
		    if(userMaintenance.isAPIuserAuthencated(codApiRequestDto,true) && userMaintenance.isRequestVerified(codApiRequestDto) && !(userMaintenance.isRequestPerDayReached(codApiRequestDto))){
				codApiRequestDto.setMatchingType("NAME");
	    		codApiRequestDto=clientRequestMaintenance.getEnrichRecords(codApiRequestDto);
	    		codApiRequestDto=clientRequestMaintenance.encodedURLObject(codApiRequestDto); 
	    		userMaintenance.createApiRequestsLog(codApiRequestDto); 
		    }
		    return CommonUtils.getSuccessMessage(HttpStatusCodes.SUCCESS.getCode(), "Enriched information fetched successfully!", clientRequestMaintenance.buildResponse(codApiRequestDto));
				
	}
	
	
	@RequestMapping(value = "/entitiesByLei",
			method = RequestMethod.POST,
			headers="Accept=application/xml, application/json")
			public ResponseMessageDTO getAllEntitiesByLEIInfo(@RequestBody CodApiRequestDto codApiRequestDto) throws Exception {
			codApiRequestDto=clientRequestMaintenance.decodedURLObject(codApiRequestDto, codApiRequestDto.getSessionAccessToken());
		    if(userMaintenance.isAPIuserAuthencated(codApiRequestDto,true) && userMaintenance.isRequestVerified(codApiRequestDto) && !(userMaintenance.isRequestPerDayReached(codApiRequestDto))){
		    	codApiRequestDto.setMatchingType("LEI");
				codApiRequestDto=clientRequestMaintenance.getEnrichRecords(codApiRequestDto);
	    		codApiRequestDto=clientRequestMaintenance.encodedURLObject(codApiRequestDto); 
	    		userMaintenance.createApiRequestsLog(codApiRequestDto); 
		    }
		    return CommonUtils.getSuccessMessage(HttpStatusCodes.SUCCESS.getCode(), "Enriched information fetched successfully!", clientRequestMaintenance.buildResponse(codApiRequestDto));
				
	}
	
	@RequestMapping(value = "/entitiesByCDID",
			method = RequestMethod.POST,
			headers="Accept=application/xml, application/json")
			public ResponseMessageDTO getAllEntitiesByCDIDInfo(@RequestBody CodApiRequestDto codApiRequestDto) throws Exception {
		
		codApiRequestDto=clientRequestMaintenance.decodedURLObject(codApiRequestDto, codApiRequestDto.getSessionAccessToken());
	    if(userMaintenance.isAPIuserAuthencated(codApiRequestDto,true) && userMaintenance.isRequestVerified(codApiRequestDto) && !(userMaintenance.isRequestPerDayReached(codApiRequestDto))){
	    	codApiRequestDto.setMatchingType("CDID");
			codApiRequestDto=clientRequestMaintenance.getEnrichRecords(codApiRequestDto);
    		codApiRequestDto=clientRequestMaintenance.encodedURLObject(codApiRequestDto); 
    		userMaintenance.createApiRequestsLog(codApiRequestDto); 
	    }
	    return CommonUtils.getSuccessMessage(HttpStatusCodes.SUCCESS.getCode(), "Enriched information fetched successfully!", clientRequestMaintenance.buildResponse(codApiRequestDto));
		
	}
	
	@RequestMapping(value = "/allMatchedEntities/{secureKey}",
			method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
			public ResponseMessageDTO getAllPotnMatchesData(@PathVariable("secureKey") String secureKey) throws Exception {
			    CodApiRequestDto codApiRequestDto=new CodApiRequestDto();
			    codApiRequestDto=clientRequestMaintenance.decodedURLObject(codApiRequestDto, secureKey);
			    if(userMaintenance.isAPIuserAuthencated(codApiRequestDto,false) && !(userMaintenance.isRequestPerDayReached(codApiRequestDto))){
			    	if(!userMaintenance.isProcessRunning(codApiRequestDto)){
			    		codApiRequestDto=clientRequestMaintenance.getEnrichMatchedRecords(codApiRequestDto);
			    	}else{
			    		return CommonUtils.getSuccessMessage(HttpStatusCodes.SUCCESS.getCode(), "Matching process is running for the requested token. Please try after some time.");
			    	}
			    	codApiRequestDto=clientRequestMaintenance.encodedURLObject(codApiRequestDto); 
		    		userMaintenance.createApiRequestsLog(codApiRequestDto); 
			    }
			    return CommonUtils.getSuccessMessage(HttpStatusCodes.SUCCESS.getCode(), "Enriched information fetched successfully!", clientRequestMaintenance.buildResponse(codApiRequestDto));
			}
	
	
	
	
	
}
