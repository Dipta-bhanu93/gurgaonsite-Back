/**
 * 
 */
package com.dipta.project.utility;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import lombok.extern.slf4j.Slf4j;

import com.dipta.project.exception.ticket.PhpException;
import com.dipta.project.exception.ticket.ConnectionException;
import com.dipta.project.utility.constants.TicketExceptionConstants;


/**
 * @author Aditya.Julka
 * This class is used to execute php script.
 */


@Slf4j
public class PhpExecutorUtil {
	
	private static final String CLASSNAME="PhpExecutorUtil";
	
	/**
	 * This method is used to execute Php Scripts
	 * @param String
	 * @return String containing the output of Scripts
	 * @throws ConnectionException 
	 * @throws PhpException 
	 */
	public static String executeScript(String script) throws PhpException,ConnectionException {
		final String methodName = "executeScript";
		 log.info("Inside "+methodName+" method of "+CLASSNAME);
		 ScriptEngineManager manager = new ScriptEngineManager();
		 ScriptEngine engine = manager.getEngineByExtension("php");
		 String result=new String();
		 try {
		

			
			 Object o=engine.eval(script);
				result=o.toString();
			log.info("Result for "+methodName+ ":: "+result);
		 }
		 catch (NullPointerException e) {
			 log.error("Exception thrown by "+methodName +" "+TicketExceptionConstants.CONNECTIONEXCEPTION.getConstant());
			 throw new ConnectionException(TicketExceptionConstants.CONNECTIONEXCEPTION.getConstant());
		} catch (ScriptException e) {
			log.error("Exception thrown by "+methodName +" "+TicketExceptionConstants.PHPEXCEPTION.getConstant());
			throw new PhpException(TicketExceptionConstants.PHPEXCEPTION.getConstant());
		}catch (Exception e) {
			log.error("Exception thrown by "+methodName +" "+TicketExceptionConstants.PHPEXCEPTION.getConstant());
			throw new PhpException(TicketExceptionConstants.PHPEXCEPTION.getConstant());
		}
		 if(result.equalsIgnoreCase("Success") || (checkInteger(result))){
			 /* Success block*/
		 }
		 else{
			 throw new PhpException(result);
		 }
		 log.info("Exiting "+methodName+" method of "+CLASSNAME);
		return result;
	}
	
	
	
	/**
	 * This method is used to check whether a string is integer or not.
	 * @param resultantString
	 * @return boolean
	 */
	public static boolean checkInteger(String resultantString){
		boolean result=true;
		try{
		Integer.parseInt(resultantString);
		
		}catch(NumberFormatException e){
		result = false;
		}
		
		
		
		return result;
	}
	
}
