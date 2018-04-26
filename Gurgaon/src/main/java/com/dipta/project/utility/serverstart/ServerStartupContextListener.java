package com.dipta.project.utility.serverstart;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.slf4j.Slf4j;

import com.dipta.project.exception.common.ContextStartupFailedException;
//import com.dipta.project.maintenance.company.CompanyMaintenanceImpl;
//import com.dipta.project.maintenance.company.ICompanyMaintenance;
//import com.dipta.project.maintenance.file.FileMaintenanceImpl;
//import com.dipta.project.maintenance.file.IFileMaintenance;
import com.dipta.project.scheduler.SchedulerServerStartupProcess;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.dipta.project.utility.queue.ProjectExecutionQueueManager;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
@Slf4j
public class ServerStartupContextListener implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("---------- Context Destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0){
		/*try {
			PropertyConfigurator.configure(PropertyUtility.getProperties(ApplicationConstants.LOGGERBUNDLE.getValue()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		log.info("ContextInitialized Called");
		log.info("Binding SYSO and Error to Logger");
		//		SYSOController.tieSystemOutAndErrToLog();
		try{
//			PropertyUtility.loadPropertyFile(ApplicationConstants.EXCEPTIONBUNDLE.getValue(),ApplicationConstants.EMAILBUNDLE.getValue(),ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(),ApplicationConstants.APPLICATION_BUNDLE.getValue());
//			PropertyUtility.loadPropertyFile(ApplicationConstants.CAPTCHAVALIDATIONBUNDLE.getValue(),ApplicationConstants.SEARCHPARAMETERBUNDLE.getValue(),ApplicationConstants.WORKFLOWBUNDLE.getValue());
//			PropertyUtility.loadPropertyFile(ApplicationConstants.DAOABSTRACTIONBUNDLE.getValue(),ApplicationConstants.APPLICATIONCLIENT_BUNDLE.getValue());
//
//			IFileMaintenance fileMaintenance = new FileMaintenanceImpl();
//			fileMaintenance.init();
//
//			ICompanyMaintenance companyMaintenance = new CompanyMaintenanceImpl();
//			companyMaintenance.init();
//
//			/*INewsMaintenance newsMaintenance = new NewsMaintenanceImpl();
//			newsMaintenance.startNewsUpdateEveryDay();*/
//			
//			try{
//				
//				String schduleOnStartUp = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), ApplicationConstants.RE_SCHEDULE_JOB_QUEUE.getValue(),"");
//				System.out.println("Re-schedule jobs on start up : "+schduleOnStartUp);
//				if(schduleOnStartUp.equals("Y")){
//					System.out.println("\n*******************************************************************");
//					System.out.println("Jobs Scheduling | Intitiating... ");
//					SchedulerServerStartupProcess schedulerStartupProcess = new SchedulerServerStartupProcess();
//					schedulerStartupProcess.init();
//					System.out.println("Jobs Scheduling | Completed! ");
//					System.out.println("\n*******************************************************************");
//					
//				}else{
//					System.out.println("\n*******************************************************************");
//					System.out.println("Jobs Scheduling | Skipped ! (Enable from configuration.properties) ");
//					System.out.println("\n*******************************************************************");
//				}
			}catch(Exception e){
				e.printStackTrace();
				log.error("Jobs scheduling failed on server startup. Exception"+e);
			}
			
			//ProjectExecutionQueueManager.serverStartupProcess();

			/*try{
				Runnable r = new Runnable() {

					@Override
					public void run() {
						while(true){
							try{
								ScheduleManager.getAllScheduled();
								Thread.sleep(5000);
							}catch(Exception e){
								System.out.println("Exception e:"+e);
							}
						}

					}
				};

				new Thread(r).start();
			}catch(Exception e){
				System.out.println("Exception e:"+e);
			}*/

//		}catch(Exception e){
//			throw new ContextStartupFailedException("------ Exception Generated. Unable to start server. Details :"+e+" -- "+e.getMessage());
//		}
	}

}
