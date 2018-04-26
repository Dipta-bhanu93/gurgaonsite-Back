package com.dipta.project.domain.user;

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
 * This class is used to store API Request information.
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "API_USER_ACCESS_TOKEN")
public class CodApiRequestDomain {

	@Getter
	@Setter
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ACCESS_ID")
	@SequenceGenerator(name="SEQ_ACCESS_ID", sequenceName="SEQ_ACCESS_ID")
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
	@Column(name = "TOKEN_EXPIRED_FLAG")
	private String tokenExpiredFlag;
	
	@Getter
	@Setter
	@Column(name = "REQUEST_STATUS")
	private String requestStatus;
	
	@Getter
	@Setter
	@Column(name = "COMMENTS")
	private String comments;
	
}
