package com.dipta.project.domain.crossReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TAB_RESERVED_WORDS")
public class ReserveKeywordDomain {
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "KEYWORD")
	private String keyword;

}
