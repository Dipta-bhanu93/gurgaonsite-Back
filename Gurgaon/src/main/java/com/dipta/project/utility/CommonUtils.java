package com.dipta.project.utility;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.common.InvalidFileException;
import com.dipta.project.exception.common.InvalidKeyException;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.utility.constants.*;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public class CommonUtils {
	public static int startPoint=0;
	public static int endPoint=50;
	
	//public static String TARGET_STRING_BUILD_HIERARCHY[] = {"x.cdIDREFERENCE IDREFERENCE,","(select legalname from counterparty_gold where cdid =X.cdIDREFERENCE) IDREF_LEGALNAME,","(select domicilecntry from counterparty_gold where cdid =X.cdIDREFERENCE) IDREF_COUNTRY,",",x.REFERENCEPERCENTAGE,","x.REFERENCETYPE,","x.REFERENCESUBTYPE"};

	public static String generatePassword(){
		String password = "";
		final Random rn = new Random();
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int number = 0;

		for (int i = 0; i < 3; i++) {
			int index = rn.nextInt() % 26;
			if (index < 0) {
				index = 0;
			}
			number = rn.nextInt() % 10;
			password += alphabet.substring(index, index + 1) + (number < 0 ? -1 * number : number);
		}
		return password;
	}
	
	public static int percentageIncrementer(boolean stats){
		Random rn = new Random();
    	if(stats==true && startPoint!=endPoint){
    			int range = (startPoint - endPoint) + 1;
    			int randomNum =  rn.nextInt(range) + startPoint;
    			startPoint=randomNum;
    			return randomNum;
    	}else if(startPoint == endPoint){
    		  startPoint=0;
    		  return 50;
    	}else{
    		return -1;
    	}
        
    }

	public static Timestamp getCurrentTimestamp() {
		final Calendar cal = Calendar.getInstance();
		final java.sql.Timestamp ts = new java.sql.Timestamp(cal.getTimeInMillis());
		return ts;
	}
	public static Timestamp getFutureTimestamp(long addValue) {
		final Calendar cal = Calendar.getInstance();
		final java.sql.Timestamp ts = new java.sql.Timestamp(cal.getTimeInMillis()+addValue);
		return ts;
	}
	public static <T>T getObjectFromJSON(String json,Class<T> returnType) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		return mapper.readValue(json, returnType);
	}

	@SuppressWarnings("unchecked")
	public static <T>T getObjectFromXML(String json,Class<T> returnType) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(returnType);
		Unmarshaller un = context.createUnmarshaller();
		InputStream is = new ByteArrayInputStream(json.getBytes());
		return (T) un.unmarshal(is);
	}
	public static String getRequestedURI(ServletRequest request){
		String contextPath = ((HttpServletRequest)request).getContextPath();
		String requestedURI = ((HttpServletRequest)request).getRequestURI();
		if(contextPath!=null && requestedURI!=null){
			if(contextPath!=null){
				if(requestedURI.startsWith(contextPath)){
					requestedURI = requestedURI.substring(contextPath.length(),requestedURI.length());
					if(requestedURI!=null && requestedURI.startsWith("/")){
						requestedURI = requestedURI.substring(1);
					}
					if(requestedURI!=null && requestedURI.endsWith("/")){
						requestedURI = requestedURI.substring(0,requestedURI.length()-1);
					}
				}
			}
		}
		return requestedURI;
	}
	public static String getUniqueToken() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}


	public static String getJsonFromObject(Object objectToSerialize){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(objectToSerialize);
		} catch (Exception e) {
			System.out.println("Error Generated"+e);
			return null;
		}
	}


	public static String getXMLFromObject(Object objectToSerialize){
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			System.out.println(objectMapper.writeValueAsString(objectToSerialize));

			Object json = objectMapper.readValue(
					objectMapper.writeValueAsString(objectToSerialize), Object.class);
			System.out.println(json);

			JAXBContext jaxbContext = JAXBContext.newInstance(objectToSerialize.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(objectToSerialize, stringWriter);
			return stringWriter.toString();
		} catch (Exception e) {
			System.out.println("Error Generated"+e);
			return null;
		}
	}
	
	public static HttpServletResponse setHeader(HttpServletResponse response,String headerKey,String headerValue){
		response.setHeader(headerKey, headerValue);
		return response;
	}
	
	public static void prepareErrorResponse(HttpServletRequest request,HttpServletResponse response,String code,String description,boolean isError) throws IOException{
		ResponseMessageDTO responseDto = new ResponseMessageDTO();
		responseDto.setError(isError);
		responseDto.setResponseCode(code);
		if(isError){
			responseDto.setErrorDiscription(description);
		}else{
			responseDto.setResponseMessage(description);
		}
		
		String requestContentType = request.getHeader("Accept");
		String responseContentType = response.getContentType();
		String contentType = (responseContentType==null)?requestContentType:responseContentType;
		String responseData = null;
		
		if(contentType!=null && contentType.toUpperCase().endsWith("XML")){
			responseData = CommonUtils.getXMLFromObject(responseDto);
		}else if(contentType!=null && contentType.toUpperCase().endsWith("JSON")){
			responseData = CommonUtils.getJsonFromObject(responseDto);
		}else if(contentType!=null && contentType.toLowerCase().contains("application/json")){
			responseData = CommonUtils.getJsonFromObject(responseDto);
		}else{
			responseData = CommonUtils.getXMLFromObject(responseDto);
		}
		
		response.getOutputStream().write(responseData.getBytes());
		
	}
	public static void prepareErrorResponse(ServletRequest request,ServletResponse response,String code,String description,boolean isError) throws IOException{
		prepareErrorResponse((HttpServletRequest)request,(HttpServletResponse) response,code,description,isError);
	}
	
	public static void prepareSuccessResponse(HttpServletRequest request,HttpServletResponse response,String code,String description,boolean isError,Object data) throws IOException{
		ResponseMessageDTO responseDto = new ResponseMessageDTO();
		responseDto.setError(isError);
		responseDto.setResponseCode(code);
		responseDto.setData(data);
		if(isError){
			responseDto.setErrorDiscription(description);
		}else{
			responseDto.setResponseMessage(description);
		}
		
		String requestContentType = request.getHeader("Accept");
		String responseContentType = response.getContentType();
		String contentType = (responseContentType==null)?requestContentType:responseContentType;
		String responseData = null;
		
		if(contentType!=null && contentType.toUpperCase().endsWith("XML")){
			responseData = CommonUtils.getXMLFromObject(responseDto);
		}else if(contentType!=null && contentType.toUpperCase().endsWith("JSON")){
			responseData = CommonUtils.getJsonFromObject(responseDto);
		}else if(contentType!=null && contentType.toLowerCase().contains("application/json")){
			responseData = CommonUtils.getJsonFromObject(responseDto);
		}else{
			responseData = CommonUtils.getXMLFromObject(responseDto);
		}
		
		response.getOutputStream().write(responseData.getBytes());
		
	}
	
	public static ResponseMessageDTO getSuccessMessage(String responseMessage,Object data){
		ResponseMessageDTO response = new ResponseMessageDTO();
		response.setResponseCode(HttpStatusCodes.SUCCESS.getCode());
		response.setResponseMessage(responseMessage);
		response.setData(data);
		
		return response;
	}
	public static ResponseMessageDTO getSuccessMessage(String statusCode,String responseMessage,Object data){
		ResponseMessageDTO response = new ResponseMessageDTO();
		response.setResponseCode(statusCode);
		response.setResponseMessage(responseMessage);
		response.setData(data);
		
		return response;
	}
	public static BufferedInputStream getBufferedInputStream(String filePath) throws FileNotFoundException{
		FileInputStream file = new FileInputStream(new File(filePath));
		BufferedInputStream bis = new BufferedInputStream(file);
		return bis;
	}
	public static <T>T convertObject(Object inObject,Class<T> returnType) throws ObjectNotSupportedException {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(inObject, returnType);
	}
	/**
	   * This method is used for given String Empty and null or not 
	   * @return boolean
	*/
	public static boolean isStringEmpty(String input){
      if(input == null || input.isEmpty()){
          return true;
      }
      return false;
  }
	
	/**
	 * COnvert timestamp into java.util.date
	 * @param timestamp
	 * @return
	 */
	public static java.util.Date toDate(java.sql.Timestamp timestamp) {
	    long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
	    return new java.util.Date(milliseconds);
	}
	
	
	/**
	 * to calculate days between two dates
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long daysBetween(Date date1, Date date2) { 
		
		Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        Calendar dcal1 = Calendar.getInstance();
        dcal1.setTime(date1);
        int year = dcal1.get(Calendar.YEAR);
        int month = dcal1.get(Calendar.MONTH) +1;
        int day = dcal1.get(Calendar.DAY_OF_MONTH);
        
        // Set the date for both of the calendar instance
        cal1.set(year, month, day);
        
        dcal1.setTime(date2);
         year = dcal1.get(Calendar.YEAR);
         month = dcal1.get(Calendar.MONTH)+1;
        day = dcal1.get(Calendar.DAY_OF_MONTH);
        
        
        cal2.set(year, month, day);

      
        // Get the represented date in milliseconds
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();
        
        // Calculate difference in milliseconds
        long diff = milis2 - milis1;
        long diffDays = diff / (24 * 60 * 60 * 1000) ;
		
		
		return diffDays;
		
	}
	
	/**
	 * To add days in date
	 * @param date
	 * @param days
	 * @return
	 */
	 public static Date addDay(Date date, int days) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, days-1);
	        return cal.getTime();
	    }
	 
	 /**
	  *  To add months in date
	  * @param date
	  * @param months
	  * @return
	  */
    public static Date addMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,months);
        return cal.getTime();
    }
    
    /**
     * To add years in date
     * @param date
     * @param year
     * @return
     */
    public static Date addYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }
    
    /**
     * To check if internal user or not
     * @param companyId
     * @return
     */
    public static boolean isInternalUser(Long companyId){
		return companyId == 1;
	}
    
    public static String getOsName()
    {
       return System.getProperty("os.name");
    }
    
    public static boolean isWindows()
    {
       return getOsName().startsWith("Windows");
    }
    
    
    public static int getRandomNumber(int stagePercent)
    {
    	Random random = new Random();
    	int approxPercent = 0;
    	int max = stagePercent;
    	int min = 0;
    	min = stagePercent-10;
    	approxPercent = random.nextInt(max - min + 1) + min;
		
		return approxPercent;
    }
    
    
    public static void main(String[] args) {
		System.out.println(getRandomNumber(50));
	}
    
    /**
     * To get header from properties file for hierarchy report related file.
     * @param header
     * @return
     */
    public static String getHierarchyReportHeader(String header){
    	String headerValue = "";
    	if(null != header && !header.isEmpty()){
    		try {
				headerValue = PropertyUtility.getValueString(ApplicationConstants.APPLICATION_BUNDLE.getValue(),"REPORT_"+header);
				if(null == headerValue || headerValue.isEmpty()){
					headerValue = header;
				}
			} catch (InvalidFileException | InvalidKeyException e) {
				e.printStackTrace();
				headerValue = header;
			}
    	}
		return headerValue;
    }
   
    /**
     * To remove specific column from query 
     * @param query
     * @param patern
     * @return
     */
    public static String removeReferenceTypeColumnFromHierarchyQuery(String query,String target,String replacement){
    	String updateQuery = query.replace(target,replacement);
		return updateQuery;
    }
    
    
   /* *//**
     * To remove specific column from query only for build hierarchy query 
     * @param query
     * @return
     *//*
    public static String removeColumnFromBuildHierarchyQuery(String query){
    	String result = StringUtils.normalizeSpace(query);
    //	String result = query.replaceAll("[\\t\\n\\r]+"," ");
    	for (int i = 0; i < TARGET_STRING_BUILD_HIERARCHY.length; ++i)
    	{
    	    result = result.replace(TARGET_STRING_BUILD_HIERARCHY[i], "");
    	}
		return result;
    }*/
	
}
