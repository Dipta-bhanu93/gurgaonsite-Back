package com.dipta.project.domain.base.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_INFO")
public class ConnectionDetailDomain {
	@Getter
	@Setter
	@Id
	@Column(name="USER_ID")
	private long id;
	
	
	@Getter
	@Setter
	@Column(name="EMAIL_ID")
	private String email;
	
	@Getter
	@Setter
	@Column(name="CLIENT_ID")
	private Long clientId;
	
	@Getter
	@Setter
	@Column(name="STATUS_ID")
	private Integer status;

	@Override
	public String toString() {
		return "ConnectionDetailDomain [id=" + id + ", email=" + email + ", clientId=" + clientId + ", status=" + status + "]";
	}
	
	
	
}
