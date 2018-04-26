package com.dipta.project.domain.acl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Embeddable
public class UserRoleCompositeId implements Serializable {

	
	@Column(name="USER_ID")
	@Getter
	@Setter
    private Long userId;

	
    @Column(name="ROLE_ID")
    @Getter
	@Setter
    private Long roleId;
}
