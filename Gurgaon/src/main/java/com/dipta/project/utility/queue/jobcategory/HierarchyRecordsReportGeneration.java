//package com.dipta.project.utility.queue.jobcategory;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import com.dipta.project.domain.project.GeneratedReportsDomain;
//import com.dipta.project.dto.common.FileReportDto;
//import com.dipta.project.dto.workflow.ProjectDTO;
//import com.dipta.project.exception.common.ProcessFailedException;
//import com.dipta.project.maintenance.file.FileMaintenanceImpl;
//import com.dipta.project.maintenance.file.IFileMaintenance;
//import com.dipta.project.maintenance.project.IProjectMaintenance;
//import com.dipta.project.maintenance.project.ProjectMaintenanceImpl;
//import com.dipta.project.maintenance.user.IUserMaintenance;
//import com.dipta.project.maintenance.user.UserMaintenanceImpl;
//import com.dipta.project.maintenence.report.IReportsMaintenence;
//import com.dipta.project.maintenence.report.ReportsMaintenenceImpl;
//import com.dipta.project.report.ReportDataTable;
//import com.dipta.project.service.files.FileDownloadService;
//import com.dipta.project.utility.constants.CommonConstants;
//import com.dipta.project.utility.constants.FileSourceConstants;
//import com.dipta.project.utility.queue.CallableQueueJob;
//
//public class HierarchyRecordsReportGeneration extends CallableQueueJob<Long> {
//
//	
//	
//	public HierarchyRecordsReportGeneration(ReportDataTable reportDataTable) {
//		super(reportDataTable);
//	}
//	
//	@Override
//	public Long execute(Object[] userData) throws ProcessFailedException {
//		try{
//			ReportDataTable reportDataTable = (ReportDataTable)userData[0];
//			
//			long projectId = Long.valueOf(reportDataTable.getProjectId());
//
//			IUserMaintenance userMaintenance  = new UserMaintenanceImpl();
//			long userId =  userMaintenance.getUser(reportDataTable.getTenentEmail(), false).getId();
//
//			IProjectMaintenance projectMaintenance = new ProjectMaintenanceImpl();
//			ProjectDTO projectDetail = projectMaintenance.getProject(reportDataTable.getTenentEmail(), projectId);
//
//
//			IFileMaintenance fileMaintenance =new FileMaintenanceImpl();
//			
//			//Collection<FileReportDto> reportDtolist = reportDataTable.getHierarchyReportingData().values();
//			Collection<FileReportDto> reportDtolist = null;
//			//reportDto.setReportName(feedType);
//			FileReportDto[] reportDtoArr = reportDtolist.toArray(new FileReportDto[1]);
//			List<FileReportDto> newReportDtolist = Arrays.asList(reportDtoArr);
//			Workbook preparedWorkbook = getWorkbook(newReportDtolist);
//			//
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			preparedWorkbook.write(baos);
//			byte[] data = baos.toByteArray();
//			
//			//Long fileID = fileMaintenance.saveFile(reportDataTable.getTenentEmail(), getFileName(projectDetail.getProjectName(), projectDetail.getTemplateID(), reportDataTable.getExecutedOn(), feedType), data, FileSourceConstants.REPORT);
//			
//			Long fileID = fileMaintenance.saveFile(reportDataTable.getTenentEmail(),"Hierarchy", data, FileSourceConstants.REPORT);
//			
//			IReportsMaintenence reportsMaintenence = new ReportsMaintenenceImpl();
//			GeneratedReportsDomain generatedReportsDomain=new GeneratedReportsDomain();
//			
//			generatedReportsDomain.setFileId(fileID);
//			generatedReportsDomain.setProjectId(projectId);
//			generatedReportsDomain.setUserId(userId);
//			generatedReportsDomain.setGeneratedDate(reportDataTable.getExecutedOn());
//			generatedReportsDomain.setExecutionId(reportDataTable.getExecutedId());
//			generatedReportsDomain.setBadRecordsFileFlag("Y");
//			if(reportsMaintenence.saveGeneratedReports(reportDataTable.getTenentEmail(), generatedReportsDomain)){
//				return fileID;
//			}else{
//				return 0L;
//			}
//			
//		}catch(Exception e){
//			throw new ProcessFailedException(e.getMessage());
//		}
//		
//	}
//	
//	private Workbook getWorkbook(List<FileReportDto> requestedData) throws IOException{
//		FileDownloadService fds = new FileDownloadService();
//		return fds.createhierarchyWorkBook(requestedData,"xlsx");
//	}
//	
//	private String getFileName(String projectName, long templateId,	Timestamp reportGenOn, String feedType){
//
//		if(templateId == 2){
//			return "BadRecords_"+CommonConstants.FILE_PREFIX_INSTISS + projectName + "_" + feedType + new SimpleDateFormat("_dd-MMM-yyyy_(HH-mm-ss").format(reportGenOn)+"Hrs).xlsx";
//		}else if(templateId == 3){
//			return "BadRecords_"+CommonConstants.FILE_PREFIX_XREF + projectName + "_" + feedType + new SimpleDateFormat("_dd-MMM-yyyy_(HH-mm-ss").format(reportGenOn)+"Hrs).xlsx";
//		}else{
//			return "BadRecords_"+CommonConstants.FILE_PREFIX_REFDATA + projectName + "_" + feedType + new SimpleDateFormat("_dd-MMM-yyyy_(HH-mm-ss").format(reportGenOn)+"Hrs).xlsx";
//		}
//
//	}
//	
//	/*public Long executeReport(ReportDataTable reportDataTable) throws ProcessFailedException {
//		try{
//			
//			long projectId = Long.valueOf(reportDataTable.getProjectId());
//
//			IUserMaintenance userMaintenance  = new UserMaintenanceImpl();
//			long userId =  userMaintenance.getUser(reportDataTable.getTenentEmail(), false).getId();
//
//			IProjectMaintenance projectMaintenance = new ProjectMaintenanceImpl();
//			ProjectDTO projectDetail = projectMaintenance.getProject(reportDataTable.getTenentEmail(), projectId);
//
//
//			IFileMaintenance fileMaintenance =new FileMaintenanceImpl();
//			
//			Collection<FileReportDto> reportDtolist = reportDataTable.getHierarchyReportingData().values();
//			//reportDto.setReportName(feedType);
//			FileReportDto[] reportDtoArr = reportDtolist.toArray(new FileReportDto[1]);
//			List<FileReportDto> newReportDtolist = Arrays.asList(reportDtoArr);   
//			Workbook preparedWorkbook = getWorkbook(newReportDtolist);
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			preparedWorkbook.write(baos);
//			byte[] data = baos.toByteArray();
//			
//			
//			FileUtils.writeByteArrayToFile(new File("C:/Users/patel_as/Desktop/file/hierarchy.xls"), data);
//			
//			//Long fileID = fileMaintenance.saveFile(reportDataTable.getTenentEmail(), getFileName(projectDetail.getProjectName(), projectDetail.getTemplateID(), reportDataTable.getExecutedOn(), feedType), data, FileSourceConstants.REPORT);
//			
//			Long fileID = fileMaintenance.saveFile(reportDataTable.getTenentEmail(),"Hierarchy", data, FileSourceConstants.REPORT);
//			
//			IReportsMaintenence reportsMaintenence = new ReportsMaintenenceImpl();
//			GeneratedReportsDomain generatedReportsDomain=new GeneratedReportsDomain();
//			
//			generatedReportsDomain.setFileId(fileID);
//			generatedReportsDomain.setProjectId(projectId);
//			generatedReportsDomain.setUserId(userId);
//			generatedReportsDomain.setGeneratedDate(reportDataTable.getExecutedOn());
//			generatedReportsDomain.setExecutionId(reportDataTable.getExecutedId());
//			generatedReportsDomain.setBadRecordsFileFlag("Y");
//			if(reportsMaintenence.saveGeneratedReports(reportDataTable.getTenentEmail(), generatedReportsDomain)){
//				return fileID;
//			}else{
//				return 0L;
//			}
//			
//		}catch(Exception e){
//			throw new ProcessFailedException(e.getMessage());
//		}
//		
//	}*/
//
//}