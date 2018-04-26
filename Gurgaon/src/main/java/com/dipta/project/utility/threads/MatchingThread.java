package com.dipta.project.utility.threads;

import com.dipta.project.dao.api.IClientRequestedDao;
import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;


public class MatchingThread implements Runnable {

	private CodApiRequestDto codApiRequestDto; 
    public MatchingThread(CodApiRequestDto codApiRequestDto){
        this.codApiRequestDto=codApiRequestDto;
    }

    @Override
    public void run() {
    	IClientRequestedDao icDoa=(IClientRequestedDao) DaoManager.CLIENTREQUEST.getDao( this.codApiRequestDto.getEmail());
		try {
			icDoa.executePostMATGProcess(this.codApiRequestDto.getAccessToken(),this.codApiRequestDto.getMatchingType());
		} catch (ObjectNotSupportedException e) {
			e.printStackTrace();
		}
    }

    @Override
    public String toString(){
        return this.codApiRequestDto.getSessionAccessToken();
    }
    
}