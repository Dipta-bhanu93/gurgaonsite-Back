/**
 * 
 */
package com.dipta.project.domain.email;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aditya.Julka
 *
 */
@Entity
@Table(name = "EMAIL_FAILURE_LOG")
public class EmailContentDomain {

	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_EMAIL_LOGID")
	@SequenceGenerator(name="SEQ_EMAIL_LOGID", sequenceName="SEQ_EMAIL_LOGID")
	@Id @Column(name="ID") @Getter	@Setter	private Long id;
		@Column(name="USER_ID") @Getter	@Setter	private Long userId;
		@Column(name="CLIENT_ID") @Getter	@Setter	private Long clientid;
		@Column(name="EMAIL_CONTENT") @Getter	@Setter	private String emailContent;
		@Column(name="EMAIL_EXCEPTION") @Getter	@Setter	private String exception;
		@Column(name="RETRY_COUNT") @Getter @Setter private int retryCount;
		@Column(name="DATE_CREATED") @Getter @Setter private Timestamp createdDate;
		@Column(name="DATE_MODIFIED") @Getter @Setter private Timestamp modifiedDate;
}