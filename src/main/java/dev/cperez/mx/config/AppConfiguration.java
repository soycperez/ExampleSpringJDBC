package dev.cperez.mx.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	private static Logger LOG = LoggerFactory.getLogger(AppConfiguration.class);
	
//	@Bean
//	public DataSource dataSource() {
//		DataSource dataSource = null; 
//		LOG.info("VALUE DataSoruce: " + String.valueOf(dataSource));
//		try {
//	   
//	    Context initialContex = new InitialContext();
//	    
//	    dataSource = (DataSource)(initialContex.lookup("java:jboss/datasources/PruebasDesarrollos"));
//	    
//	    if(dataSource != null) {
//	    	dataSource.getConnection();
//	    	LOG.info("VALUE DataSoruce: " + String.valueOf(dataSource.toString()));
//	    }
//	    
//		}catch(Exception e) {
//			e.printStackTrace();
//			LOG.warn("Problems with DataSoruce: " + String.valueOf(e));
//		}
//	   
//	    return dataSource;
//	}

}
