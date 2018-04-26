package com.dipta.project.dao.ticketManagement.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dipta.project.dao.ticketManagement.INotificationDao;
import com.dipta.project.dao.base.orm.AbstractBaseDao;

import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.utility.CommonUtils;

public class NotificationDaoImpl extends AbstractBaseDao implements INotificationDao  {
	
	public NotificationDaoImpl(String tenantEmail) {
		super(tenantEmail);
	}

		
}
