package dev.cperez.mx.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceManager {

	private static final Logger LOG = LoggerFactory.getLogger(ResourceManager.class); 
	
	private static DataSource dataSource; 
	
	public static synchronized Connection getConnection() throws NamingException, SQLException{
		Connection connection = null; 
		if(dataSource == null) {
			InitialContext initialContext = new InitialContext(); 
			dataSource = (DataSource)(initialContext.lookup("java:jboss/datasources/PruebasDesarrollos"));
			if(dataSource != null) {				
				connection = dataSource.getConnection();
				LOG.info("Datasource!=null: " + connection);
			}
		}else {
			connection = dataSource.getConnection();
			LOG.info("Datasource no es nullo: " + connection); 
		}
		return connection;
	}
}
