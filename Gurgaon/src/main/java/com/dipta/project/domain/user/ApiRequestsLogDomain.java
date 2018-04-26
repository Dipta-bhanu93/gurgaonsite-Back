package com.dipta.project.domain.user;

import java.util.Date;

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
 * This class is used to store API Requests log information.
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "API_REQUESTS_LOG")
public class ApiRequestsLogDomain {

	@Getter
	@Setter
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_REQ_TRK_ID")
	@SequenceGenerator(name="SEQ_REQ_TRK_ID", sequenceName="SEQ_REQ_TRK_ID")
	private Long id;
	
	@Getter
	@Setter
	@Column(name="EMAIL")
	private String email;
	
	@Getter
	@Setter
	@Column(name = "ACCESS_TOKEN")
	private Long accessToken;
	
	@Getter
	@Setter
	@Column(name = "REQUEST_TYPE")
	private String requestType;
	
	@Getter
	@Setter
	@Column(name="REQ_DATE")
	private Date requestDate;
	
	@Getter
	@Setter
	@Column(name = "COMMENTS")
	private String comments;
	
	
	
	
}
