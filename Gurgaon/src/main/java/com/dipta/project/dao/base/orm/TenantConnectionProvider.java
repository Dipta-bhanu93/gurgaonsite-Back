package com.dipta.project.dao.base.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;

public class TenantConnectionProvider implements MultiTenantConnectionProvider  {
	private static final String SUPERTENANT;
	private static final String connectionURL;
	private static final String DBCONNECTIONDRIVER;
	
	static{
		SUPERTENANT = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SUPERTENANTSCHEMA","ondemand_1");
		connectionURL = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "DBCONNECTIONURL",null);
		DBCONNECTIONDRIVER = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "DBCONNECTIONDRIVER","oracle.jdbc.driver.OracleDriver");
		try {
			Class.forName(DBCONNECTIONDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 312154841665619677L;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		 return DriverManager.getConnection(connectionURL, SUPERTENANT, SUPERTENANT);
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		 if(connection != null) {
	            connection.close();
	        }
	}

	@Override
	public Connection getConnection(String tenantIdentifier)
			throws SQLException {
		return DriverManager.getConnection(connectionURL, tenantIdentifier, tenantIdentifier);
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection)
			throws SQLException {
		releaseAnyConnection(connection);
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

	
}