package com.dipta.project.maintenance.api;

import com.dipta.project.dto.user.APIResponseDto;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;

public interface IClientRequestMaintenance {
	public CodApiRequestDto getEnrichRecords(CodApiRequestDto apiRequestDto) throws ObjectNotSupportedException, ProcessFailedException;
	
	public CodApiRequestDto getEnrichMatchedRecords(CodApiRequestDto apiRequestDto) throws ObjectNotSupportedException, ProcessFailedException;

	public CodApiRequestDto encodedURLObject(CodApiRequestDto codApiRequests)	throws Exception;

	public CodApiRequestDto decodedURLObject(CodApiRequestDto codApiRequests,	String secureKey) throws Exception;

	APIResponseDto buildResponse(CodApiRequestDto codApiRequests)	throws Exception;

}
