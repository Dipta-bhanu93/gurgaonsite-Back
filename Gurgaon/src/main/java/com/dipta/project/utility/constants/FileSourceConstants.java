package com.dipta.project.utility.constants;

/**
 * 
 * @author saurabh.agarwal
 *
 */
public enum FileSourceConstants {
	UPLOAD("UPLOAD","UPLOAD/"),
	REPORT("REPORT","REPORT/"),
	NDA("NDA","NDA/"),
	NEWS("NEWS","NEWS/"),
	CATALOG("CATALOG","CATALOG/")
	;
	
	private String source;
	private String path;
	
	private FileSourceConstants(String source,String path) {
		this.source=source;
		this.path = path;
	}
	
	public String getSource() {
		return source;
	}
	public String getPath() {
		return path;
	}
}