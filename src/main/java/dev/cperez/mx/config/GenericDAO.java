package dev.cperez.mx.config;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public abstract class GenericDAO implements ContantsDB {
	
	private static DataSource ds = null;
	
	private static final Logger LOG = LoggerFactory.getLogger(GenericDAO.class); 
	
	public final void setDataSource() {
		long tini = System.currentTimeMillis();
        if(ds == null) {
        	try {
        	InitialContext initialContext = new InitialContext();
        	ds = (DataSource) initialContext.lookup("java:jboss/datasources/PruebasDesarrollos");
	        } catch (Exception ex) {
	            //LOG.info(logEx, null, null,"config/GenericDAO/setDataSource" , new Object(){}.getClass().getEnclosingMethod().getName(), Utils.serviceTime(tini), "Y4NK33 al setear parametros de session para base");
	        }
        }
        init(ds);
    }
	public abstract void init(DataSource ds);

}
