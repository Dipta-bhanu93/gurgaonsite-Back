package com.dipta.project.maintenance.api;

import org.springframework.stereotype.Service;

import com.dipta.project.dao.api.IClientRequestedDao;
import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dto.user.APIResponseDto;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.user.InvalidTokenException;
import com.dipta.project.maintenance.user.IUserMaintenance;
import com.dipta.project.maintenance.user.UserMaintenanceImpl;
import com.dipta.project.utility.AESEncryption;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.dipta.project.utility.threads.MatchingThreadExecutor;

@Service
public class ClientRequestMaintenanceImpl implements IClientRequestMaintenance {
	
	
	
	@Override
	public CodApiRequestDto getEnrichRecords(CodApiRequestDto codApiRequests)  throws ObjectNotSupportedException, ProcessFailedException {
		IClientRequestedDao icDoa=(IClientRequestedDao) DaoManager.CLIENTREQUEST.getDao(codApiRequests.getEmail());
		IUserMaintenance userMaintenance=new UserMaintenanceImpl();
		long accessToken=userMaintenance.createApiUserAccessToken(codApiRequests);
	    codApiRequests.setAccessToken(accessToken);	
	    codApiRequests=icDoa.executeClientRequestedData(codApiRequests);
		MatchingThreadExecutor.executeMatpProcess(codApiRequests);
		return codApiRequests;
	}
	
	@Override
	public CodApiRequestDto getEnrichMatchedRecords(CodApiRequestDto codApiRequests) throws ObjectNotSupportedException, ProcessFailedException {
		IClientRequestedDao icDoa=(IClientRequestedDao) DaoManager.CLIENTREQUEST.getDao(codApiRequests.getEmail());
		codApiRequests=icDoa.matchingRequestedData(codApiRequests);
		return codApiRequests;
	}
	
	@Override
	public APIResponseDto buildResponse(CodApiRequestDto codApiRequests) throws Exception {
		    APIResponseDto apiResponseDto=new APIResponseDto();
		    apiResponseDto.setMatpURL(codApiRequests.getMatpURL()==null ?"":codApiRequests.getMatpURL());
		    apiResponseDto.setOutputData(codApiRequests.getOutputData());
		    return apiResponseDto;
	}
	

	
	@Override
	public CodApiRequestDto encodedURLObject(CodApiRequestDto codApiRequests) throws Exception {
	        String encodedToken=AESEncryption.encryptText(codApiRequests.getEmail()+"@@@@"+codApiRequests.getPassword()+"@@@@"+codApiRequests.getAccessToken());
		    encodedToken=encodedToken.replaceAll("/","~~~");
		    codApiRequests.setRequestedToken(encodedToken);
		    codApiRequests.setMatpURL(PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "BASEURL","http://localhost:8080/CdiOnDemand/")+"/v1/api/lei/allMatchedEntities/"+encodedToken);
		    return codApiRequests;
	}
	
	@Override
	public CodApiRequestDto decodedURLObject(CodApiRequestDto codApiRequests,String secureKey) throws InvalidTokenException {
			secureKey=secureKey.replaceAll("~~~","/");
		    System.out.println("secureKey:"+secureKey);
		    try {
				String cypher=AESEncryption.decryptText(secureKey);
				System.out.println("secureKey:"+cypher);;
				String[] cypherarr= cypher.split("@@@@");
				if(cypherarr.length==2){
					codApiRequests.setEmail(cypherarr[0]); 
				    codApiRequests.setPassword(cypherarr[1]); 
				}else if(cypherarr.length==3){
					codApiRequests.setEmail(cypherarr[0]); 
				    codApiRequests.setPassword(cypherarr[1]); 
				    codApiRequests.setAccessToken(Long.parseLong(cypherarr[2]));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new InvalidTokenException("Error : Requested Token is invalid");
			}
		     
			return codApiRequests;
	}

	

}
