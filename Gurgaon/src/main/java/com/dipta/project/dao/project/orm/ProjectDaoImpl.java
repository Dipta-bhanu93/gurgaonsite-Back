package com.dipta.project.dao.project.orm;



import lombok.extern.slf4j.Slf4j;



import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.project.IProjectDao;

/**
 * 
 * @author saurabh.agarwal
 * 
 */
@Slf4j
public class ProjectDaoImpl extends AbstractBaseDao implements IProjectDao {


	public ProjectDaoImpl(String userEmail) {
		super(userEmail);
	}
	public ProjectDaoImpl(Long clientId) {
		super(clientId);
	}


	}
