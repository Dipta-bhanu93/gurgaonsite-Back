//package com.dipta.project.utility.queue.jobcategory;
//
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//
//import com.lei.dao.base.DaoManager;
//import com.lei.dao.report.IReportDao;
//import com.lei.exception.common.ObjectNotSupportedException;
//import com.lei.exception.common.ProcessFailedException;
//import com.lei.exception.project.ProjectConfigNotFoundException;
//import com.lei.utility.queue.CallableQueueJob;
//
//public class ReportDataChunkFetchingProcess <T extends Object> extends CallableQueueJob<List<LinkedHashMap<String,Object>>> {
//
//	private String tenantEmailId;
//	private int startingRow;
//	private int chunkNumber;
//	private int chunkSize;
//	private String projectId; 
//	
//	
//	
//	public ReportDataChunkFetchingProcess( String tenantEmailId,int startingRow, int chunkNumber, int chunkSize,String projectId) {
//		super(tenantEmailId,startingRow,chunkNumber,chunkSize,projectId);
//		this.tenantEmailId = tenantEmailId;
//		this.startingRow = startingRow;
//		this.chunkNumber = chunkNumber;
//		this.chunkSize = chunkSize;
//		this.projectId = projectId;
//	}
//
//
//
//	@Override
//	public List<LinkedHashMap<String, Object>> execute(Object[] userData) throws ProcessFailedException {
//		
//		List<LinkedHashMap<String, Object>> dataList = new LinkedList<>();
//		IReportDao reportDao= DaoManager.REPORTSDAO.getDao(userData[0],IReportDao.class);
//		
//		try {
//			 dataList = reportDao.getReportsData(this.startingRow, this.chunkSize ,this.projectId);
//		
//		} catch (NumberFormatException | ProjectConfigNotFoundException
//				| ObjectNotSupportedException e) {
// 
//			e.printStackTrace();
//		}
//		
//		System.out.println("from execute() for index : "+this.chunkNumber+" dataChunkSize :" + dataList.size());
//		return dataList;
//		
//	} 
//
//	
//
//}
