package com.dipta.project.dao.api;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;

public interface IClientRequestedDao extends DaoBaseInterface{

	CodApiRequestDto executeClientRequestedData(CodApiRequestDto codApiRequests) throws ProcessFailedException;

	boolean executePostMATGProcess(long accessToken, String matchingType)throws ObjectNotSupportedException;

	CodApiRequestDto matchingRequestedData(CodApiRequestDto codApiRequests)	throws ProcessFailedException;

}
