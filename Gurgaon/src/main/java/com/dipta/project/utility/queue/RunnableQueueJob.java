package com.dipta.project.utility.queue;

import com.dipta.project.exception.common.ProcessFailedException;

/**
 * 
 * @author saurabh.agarwal
 *
 */
public abstract class RunnableQueueJob implements Runnable{
	private Object[] data;
	public RunnableQueueJob(Object... data) {
		this.data = data;
	}
	
	public void setData(Object... data){
		this.data = data;
	}
	
	@Override
	public final void run() {
		try {
			execute(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public abstract boolean execute(Object[] userData) throws ProcessFailedException;
}
