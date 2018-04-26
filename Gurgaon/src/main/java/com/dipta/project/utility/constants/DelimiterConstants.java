package com.dipta.project.utility.constants;

import java.util.HashMap;

import lombok.Getter;

public enum DelimiterConstants {

	PIPE("PIPE","pipe","|"),
	SPACE("SPACE","space"," "),
	TILDE("TILDE","tilde","~"),
	TAB("TAB","tab","\t"),
	COMMA("COMMA","comma",","),
	SEMICOLON("SEMICOLON","semicolon",";"),
	TILDEQUOTE("TILDEQUOTE","tildequote","'~'"),
	HASH("HASH","hash","#")
	;
	
	@Getter
	private String key;
	
	@Getter
	private String value;
	
	@Getter
	private String symbol;
	
	private DelimiterConstants(String key,String value, String symbol) {
		this.key=key;
		this.value = value;
		this.symbol = symbol;
	}
	
	private static HashMap<String, String> lookupSymbol = new HashMap<String, String>();
	static {
		
		// Populate out lookup when enum is created
		for (DelimiterConstants e : DelimiterConstants.values()) {
			lookupSymbol.put(e.getValue(), e.getSymbol());
		}
	}

	// Provide a method to lookup up enum with matching label
	public static String getSymbol(String label) {
			return lookupSymbol.get(label);
	}
}
