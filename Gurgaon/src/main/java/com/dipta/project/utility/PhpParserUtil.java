package com.dipta.project.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.dipta.project.dto.ticketManagement.KeyValueObject;

public class PhpParserUtil {
	private static final String PLACEHOLDER_PREFIX="{";
	private static final String PLACEHOLDER_SUFFIX="}";
	private static final String TAG_SCRIPT_FILE="script-file";
	/**
	 * This method is used to read php and add dynamic place holders.
	 * @param serverDetail
	 * @param serviceDetail
	 * @return String
	 * @throws IOException
	 */
//	public static String parsePhp(List<KeyValueObject> serverDetail, List<KeyValueObject> serviceDetail) throws IOException{
//		Map<String, String> map = transformConfig(serverDetail,serviceDetail);
//		String scriptFile = map.get(TAG_SCRIPT_FILE);
//			String result = new String();
//				result =FileReaderUtil.getText(File.separator +scriptFile);// new String(Files.readAllBytes(Paths.get("resources/createticket.php")));
//				String value="";
//				for (String key : map.keySet()) {
//					value=map.get(key);
//					if(value==null){
//					value="";}
//					result = result.replace(PLACEHOLDER_PREFIX + key + PLACEHOLDER_SUFFIX, value);
//				}
//			return result;
//	}
	/**
	 * This Method merge the server configuration and the service configuration  details into Map  
	 * @return
	 */
//	private static Map<String, String> transformConfig(List<KeyValueObject> serverDetail, List<KeyValueObject> serviceDetail){
//		Map<String, String> config = new HashMap<String, String>();
//		for (KeyValueObject obj : serverDetail) {
//			config.put(obj.getKey(), obj.getValue());
//		}
//		for (KeyValueObject obj : serviceDetail) {
//			config.put(obj.getKey(), obj.getValue());
//		}
//		return config;
//	}
}