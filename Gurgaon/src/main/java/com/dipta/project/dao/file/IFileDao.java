package com.dipta.project.dao.file;

import java.util.List;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.domain.file.FileDomain;
import com.dipta.project.dto.file.ClientFeedDto;
import com.dipta.project.dto.file.FileDto;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;

public interface IFileDao extends DaoBaseInterface {
//	public FileDto saveFile(FileDto fileData) throws ObjectNotSupportedException,ProcessFailedException;
	public FileDto getFileDetails(Long fileId) throws ProcessFailedException;
	public boolean updateFileStatus(Long fileId,int statusId) throws ProcessFailedException;
	public boolean updateFilePercentage(Long fileId, int percentage,int status) throws ProcessFailedException;
	
	public FileDomain getFileDomain(Long fileId);
	public void createClientFeedEntry(ClientFeedDto clientDto) throws ProcessFailedException, ObjectNotSupportedException;
	public void createUpdatePrestageTables(String prestageTableName, List<String> columnList, String feedDataType)	throws ProcessFailedException;
	public void updateSeqInPrestage(String tableName) throws ProcessFailedException;
	List<String> getReserveKeyword()	throws ObjectNotSupportedException, ProcessFailedException;
	boolean checkFileAssocaiatedWithXref(Long fileId) throws ProcessFailedException;
	FileDto saveFile(FileDto fileData, Long UserId) throws ObjectNotSupportedException, ProcessFailedException;
	
	
	void updateSeqInPrestage(String tableName, String template, Long projectId)
			throws ProcessFailedException;
	
}
