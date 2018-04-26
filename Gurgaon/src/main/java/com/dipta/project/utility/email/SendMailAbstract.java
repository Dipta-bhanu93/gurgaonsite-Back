package com.dipta.project.utility.email;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.dipta.project.exception.common.InvalidFileException;
import com.dipta.project.exception.common.InvalidKeyException;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public abstract class SendMailAbstract {
	private static String host;
	private static String port;
	private static boolean authentication;
	private static String SMTP;
	private static String SMTPSEND;
	private static String TEXT_HTML;
	private static String SSL_FACTORY;
	private static Session session;
	private static String senderMailID;
	private static String senderPassword;
	private Message msg;

	private static String ALL_FROM;
	private static String ALL_TO;
	private static String ALL_CC;
	private static String ALL_BCC;
	private static String ALL_SUBJECT;
	private static String ALL_HEADER;
	private static String ALL_FOOTER;
	private static boolean ALL_SUPPORTATTACHMENT;
	private static String sslTrust;
	private static String connectiontimeout;
	private static String emailUser;
	private static String emailPassword;

	static void initiate() throws InvalidFileException, InvalidKeyException{
		host = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "EMAIL_HOST");
		port = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "EMAIL_PORT");
		SMTP = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SMTP");
		SMTPSEND= PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SMTPSEND");
		TEXT_HTML= PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "TEXT_HTML");
		SSL_FACTORY= PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SSL_FACTORY");
		authentication = PropertyUtility.getValueBoolean(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "EMAIL_AUTHENTICATION");
		senderMailID = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "senderMailID");
		senderPassword = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "senderPassword");
		sslTrust = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SSL_TRUST");
		connectiontimeout = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "CONNECTIONTIMEOUT");
		emailUser = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "EMAIL_USER");
		emailPassword = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "EMAIL_PASSWORD");

		ALL_FROM = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_FROM","");
		ALL_TO = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_TO","");
		ALL_CC = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_CC","");
		ALL_BCC = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_BCC","");
		ALL_SUBJECT = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_SUBJECT","");
		ALL_HEADER = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_HEADER","");
		ALL_FOOTER = PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_FOOTER","");
		ALL_SUPPORTATTACHMENT = PropertyUtility.getValueBoolean(ApplicationConstants.EMAILBUNDLE.getValue(), "ALL_SUPPORTATTACHMENT",false);

		final Properties props = new Properties();
		props.put("mail.smtp.host", host);
		
		if (authentication) {
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.ssl.trust", sslTrust);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", ""+authentication);
			props.put("mail.smtp.connectiontimeout", connectiontimeout);
		}
		
		session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                 return new javax.mail.PasswordAuthentication(emailUser, emailPassword);
                }
       });
		session.setDebug(false);
	}
	public SendMailAbstract() throws MessagingException {
		msg = new MimeMessage(session);
		msg.setHeader("X-Mailer", SMTPSEND);
		msg.setSentDate(new Date());

		if(ALL_TO!=null && ALL_TO.length()>0){
			setRecepiants(Message.RecipientType.TO,ALL_TO.split(","));
		}
		if(ALL_CC!=null && ALL_CC.length()>0){
			setRecepiants(Message.RecipientType.CC,ALL_CC.split(","));
		}
		if(ALL_BCC!=null && ALL_BCC.length()>0){
			setRecepiants(Message.RecipientType.BCC,ALL_BCC.split(","));
		}
	}

	private final void setRecepiants(RecipientType recipientType,String[] recipiants) throws MessagingException{
		Address[] cc = new Address[recipiants.length];;
		for(int index=0;index<recipiants.length;index++){
			cc[index] = new InternetAddress(recipiants[index]);
		}
		msg.addRecipients(recipientType, cc);
	}

	private final String prepareBody(String body){
		if(body!=null){
			if(ALL_HEADER!=null){
				body = ALL_HEADER + body;
			}
			if(ALL_FOOTER!=null){
				body = body + ALL_FOOTER;
			}
		}else{
			if(ALL_HEADER!=null){
				body = ALL_HEADER;
			}
			if(ALL_FOOTER!=null){
				if(body!=null){
					body = body + ALL_FOOTER;
				}else{
					body = ALL_FOOTER;
				}
			}
		}

		return body;
	}
	void send() throws MessagingException{
		final Transport transport = (Transport)session.getTransport(SMTP);
		if (authentication) {
			transport.connect(host, senderMailID,
					senderPassword);
		} else {
			transport.connect();
		}
		transport.sendMessage(msg, msg.getAllRecipients());
	}
	public final void prepare(String body,String[] fileAttachements,String[] fileAttachementsName,boolean supportAttachment) throws MessagingException, IOException{
		body = prepareBody(body);
		if (ALL_SUPPORTATTACHMENT && supportAttachment && fileAttachements != null && fileAttachements.length >= 0) {
			final MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setDataHandler(new DataHandler(new ByteArrayDataSource(body, TEXT_HTML)));
			final MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);

			MimeBodyPart mbp2 = null;
			boolean isNameDiffrent = false;
			int index = 0;
			if(fileAttachementsName!=null && fileAttachementsName.length == fileAttachements.length){
				isNameDiffrent = true;
			}
			for (final String fileAttachement : fileAttachements) {
				if (!(fileAttachement != null) || fileAttachement.equals("")) {
					continue;
				}
				final File file = new File(fileAttachement);
				if (!file.exists()) {
					continue;
				}

				mbp2 = new MimeBodyPart();
				final FileDataSource fds = new FileDataSource(fileAttachement);
				mbp2.setDataHandler(new DataHandler(fds));
				if(isNameDiffrent){
					mbp2.setFileName(fileAttachementsName[index]);
				}else{
					mbp2.setFileName(fds.getName());
				}
				mp.addBodyPart(mbp2);
				index++;
			}

			msg.setContent(mp);
		} else {
			msg.setDataHandler(new DataHandler(new ByteArrayDataSourceMail(body, TEXT_HTML)));
		}
	}
	public final void setFrom(String from)throws MessagingException,UnsupportedEncodingException{
		if (from != null) {
			if(ALL_FROM!=null){
				msg.setFrom(new InternetAddress(senderMailID,ALL_FROM+from));
			}else{
				msg.setFrom(new InternetAddress(senderMailID,from));
			}

		} else {
			if(ALL_FROM!=null){
				msg.setFrom(new InternetAddress(senderMailID,ALL_FROM));
			}else{
				msg.setFrom();
			}
		}
	}

	public final void setRecepiants(String to[],String cc[],String bcc[]) throws MessagingException{
		if(to!=null && to.length>0){
			setRecepiants(Message.RecipientType.TO,to);
		}
		if(cc!=null && cc.length>0){
			setRecepiants(Message.RecipientType.CC,cc);
		}
		if(bcc!=null && bcc.length>0){
			setRecepiants(Message.RecipientType.BCC,bcc);
		}
	}

	public void setSubject(String subject) throws MessagingException{
		if(ALL_SUBJECT!=null && ALL_SUBJECT.length()>0){
			if(subject!=null){
				subject = ALL_SUBJECT+subject;
			}else{
				subject=ALL_SUBJECT;
			}
		}
		msg.setSubject(subject);
	}
}
