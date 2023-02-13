package dev.cperez.mx.config;

public interface ContantsDB {
	
	String DATABASE_SCHEA = "{ ? = call PRUEBAS_DESA.";
	String SP_SCHEMA = "{CALL PRUEBAS_DESA."; 
	
	int CURSOR_TYPE 	= oracle.jdbc.OracleTypes.CURSOR;
	int NUMBER_TYPE 	= oracle.jdbc.OracleTypes.NUMBER;
	int VARCHAR_TYPE 	= oracle.jdbc.OracleTypes.VARCHAR;

	String GET_DUENIO	 	= "GETDUENIO(?)}";
	String GET_COLONIA 		= "GETCOLONIA()";
}
