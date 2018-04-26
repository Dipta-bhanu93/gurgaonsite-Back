package com.dipta.project.dto.email.base;


/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public interface IBaseEmail {
	String getEvent();
	String getFrom();
	String[] getTo() ;
	String[] getCc();
	String[] getBcc();
	String getSubject();
	String getBody();
	String getHeader();
	String getFooter();
	String[] getAttachments();
	String[] getAttachmentsName();
	boolean getSupportAttachment();
}
