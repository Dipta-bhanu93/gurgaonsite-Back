//package com.dipta.project.utility.queue.jobcategory;
//
//import com.lei.dao.base.DaoManager;
//import com.lei.dao.file.IFileDao;
//import com.lei.exception.common.ProcessFailedException;
//import com.lei.utility.queue.RunnableQueueJob;
//import com.lei.utility.queue.QueueManager;
//
///**
// * 
// * @author saurabh.agarwal
// *
// */
//public class UpdateFilePercentage extends RunnableQueueJob{
//	private IFileDao fileDao = null;
//	private int previousFilePercentage = 0;
//	public UpdateFilePercentage(String userEmail,Long fileId,Integer percentage,Integer status) {
//		super(userEmail,fileId,percentage,status);
//		fileDao = DaoManager.FILEDAO.getDao(userEmail,IFileDao.class);
////		System.out.println("-------------------------------("+percentage+") UFP Request---->"+ ++count);
//	}
//	
//	
//	@Override
//	public boolean execute(Object[] userData) throws ProcessFailedException {
//		String userEmail = (String)userData[0];
//		Long fileId = (Long)userData[1];
//		Integer percentage = (Integer)userData[2];
//		Integer status = (Integer)userData[3];
//		
//		if(percentage>previousFilePercentage || percentage==100){
//			fileDao.updateFilePercentage(fileId, percentage,status);
//			if(percentage==100&&userData.length==5){
//				QueueManager manager = (QueueManager)userData[4];
//				manager.forceStop();
//			}
//		}
//		previousFilePercentage=percentage;
//		return true;
//	}
//}