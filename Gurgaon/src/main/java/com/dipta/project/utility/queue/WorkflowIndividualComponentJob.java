package com.dipta.project.utility.queue;

/**
 * 
 * @author saurabh.agarwal
 *
 */
public class WorkflowIndividualComponentJob extends RunnableQueueJob{

	public WorkflowIndividualComponentJob(Integer jobID,String componentID,Long flowId) {
		super(jobID,componentID,flowId);
	}
	
	@Override
	public boolean execute(Object[] userData) {
		// TODO Auto-generated method stub
		return false;
	}

}