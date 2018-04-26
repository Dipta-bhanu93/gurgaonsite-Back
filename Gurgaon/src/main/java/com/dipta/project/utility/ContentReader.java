package com.dipta.project.utility;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContentReader {
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
	
	public static String getURIContent(String uri) throws Exception{
		// Fetch the link data
				String bodyContant = null;
				Document doc;
				try {
					doc = Jsoup.connect(uri).userAgent(USER_AGENT).timeout(20 * 1000).get();
					bodyContant = doc.body().text();
				} catch (IOException e1) {
					e1.printStackTrace();
					throw new Exception (e1.getMessage());
				}
			return bodyContant;	
	}

}
