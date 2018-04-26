//package com.dipta.project.utility.queue.jobcategory;
//
//import lombok.extern.slf4j.Slf4j;
//
//import com.lei.dao.base.DaoManager;
//import com.lei.dao.news.orm.INewsDao;
//import com.lei.dto.news.NewsDto;
//import com.lei.exception.common.ObjectNotSupportedException;
//import com.lei.exception.common.ProcessFailedException;
//import com.lei.maintenance.file.FileMaintenanceImpl;
//import com.lei.maintenance.file.IFileMaintenance;
//import com.lei.utility.ContentReader;
//import com.lei.utility.constants.ApplicationConstants;
//import com.lei.utility.constants.FileSourceConstants;
//import com.lei.utility.queue.RunnableQueueJob;
//@Slf4j
//public class SaveFeedDataProcess extends RunnableQueueJob {
//	private NewsDto newsDto;
//
//	public SaveFeedDataProcess(NewsDto newsDto) {
//		this.newsDto = newsDto;
//	}
//
//	@Override
//	public boolean execute(Object[] userData) throws ProcessFailedException {
//		log.info("SaveFeedDataProcess Start" +newsDto.getTitle());
//		String bodyContant="";
//		try {
//			bodyContant =ContentReader.getURIContent(newsDto.getLink());
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			throw new ProcessFailedException("SaveFeedDataProcess getURIContent:"+e1.getMessage());
//		}
//		
//        // Save the file data into the file used file save method
//		log.info("Get Content and move for save into file system and database");
//		IFileMaintenance fileMaintenance =new FileMaintenanceImpl();
//		long fileID= fileMaintenance.saveFile(ApplicationConstants.SUPERUSEREMAIL.getValue(), newsDto.getTitle(), bodyContant.getBytes(), FileSourceConstants.NEWS);
//
//		// Get file id of last process and set to the news DTO
//		newsDto.setFileId(fileID);
//
//		INewsDao newsDao = DaoManager.NEWSDAO.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),INewsDao.class);
//		try {
//			newsDao.saveNewsData(newsDto);
//		} catch (ObjectNotSupportedException e) {
//			e.printStackTrace();
//			throw new ProcessFailedException("SaveFeedDataProcess saveNewsData: "+e.getMessage());
//		}
//		log.info("SaveFeedDataProcess End");
//		return true;
//	}
//}