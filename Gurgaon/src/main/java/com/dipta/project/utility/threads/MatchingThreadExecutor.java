package com.dipta.project.utility.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dipta.project.dto.user.CodApiRequestDto;

public class MatchingThreadExecutor {
	
	public static ExecutorService executor= Executors.newFixedThreadPool(5);
	
	public static void executeMatpProcess(CodApiRequestDto codApiRequests){
		    Runnable worker = new MatchingThread(codApiRequests);
	        executor.execute(worker);
	}
	
}
