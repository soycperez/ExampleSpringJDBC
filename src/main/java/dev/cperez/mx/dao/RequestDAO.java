package dev.cperez.mx.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import dev.cperez.mx.config.ContantsDB;
import dev.cperez.mx.config.ResourceManager;

@Repository
public class RequestDAO implements ContantsDB {

	private static final Logger LOG = LoggerFactory.getLogger(RequestDAO.class);

	public void pruebaConeccion() {
		LOG.info("::::PRUEBA CONECCÓN DE BASE DE DATOS");
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ResourceManager.getConnection();
			if (connection != null) {
				LOG.info("::::SE OBTIENE CONECCION::: " + connection);
				LOG.info("prepareCall: " + DATABASE_SCHEA + GET_DUENIO);
			}

		} catch (Exception e) {
			LOG.info("Error al conseguir conección");
		}
	}

	public void getDuenio(int numero) {
		long tini = System.currentTimeMillis();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ResourceManager.getConnection();
			if (connection != null) {
				LOG.info("SE ESTABLECE CONEXIÓN:: " + connection.getCatalog());
				LOG.info("SE PREPARA CALL TO SP: " + DATABASE_SCHEA + GET_DUENIO);
				callableStatement = connection.prepareCall(DATABASE_SCHEA + GET_DUENIO);
				callableStatement.registerOutParameter(1, CURSOR_TYPE);
				callableStatement.setInt(2, numero);
				callableStatement.execute();
				resultSet = (ResultSet) callableStatement.getObject(1);
				while (resultSet.next()) {
					LOG.info("ID: " + resultSet.getString(1));
					LOG.info("NOMBRE: " + resultSet.getString(2));
					LOG.info("APELLIDOS: " + resultSet.getString(3));
					LOG.info("DIRECCIÓN: " + resultSet.getString(4));
					LOG.info("ID_COLONIA: " + resultSet.getString(5));
					LOG.info("FECHA REGISTRO: " + resultSet.getString(6));
					LOG.info("FECHA ULTIMA MODIFICACIÓN: " + resultSet.getString(7));

				}
			}
		} catch (Exception e) {
			LOG.warn("ERROR: " + e.getMessage());
		} finally {
			try {
				connection.close();
				resultSet.close();
				callableStatement.close();
				LOG.info("TIEMPO DE EJECUCIÓN" + tini);
			} catch (Exception e2) {
				LOG.warn("ERROR AL CERRAR CONEXIÓN" + e2);
			}

		}

	}
	
	public void getColonia() {
		long tini = System.currentTimeMillis();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ResourceManager.getConnection();
			if (connection != null) {
				LOG.info("SE ESTABLECE CONEXIÓN:: " + connection.getCatalog());
				LOG.info("SE PREPARA CALL TO SP: " + DATABASE_SCHEA + GET_COLONIA);
				callableStatement = connection.prepareCall(DATABASE_SCHEA + GET_COLONIA);
				callableStatement.registerOutParameter(1, CURSOR_TYPE);
				callableStatement.execute();
				resultSet = (ResultSet) callableStatement.getObject(1);
				while (resultSet.next()) {
					LOG.info("ID: " + resultSet.getString(1));
					LOG.info("NOMBRE COLONIA: " + resultSet.getString(2));
					LOG.info("FECHA REGISTRO: " + resultSet.getString(3));
					LOG.info("FECHA ULTIMA MODIFICACIÓN: " + resultSet.getString(4));

				}
			}
		} catch (Exception e) {
			LOG.warn("ERROR: " + e.getMessage());
		} finally {
			try {
				connection.close();
				resultSet.close();
				callableStatement.close();
				LOG.info("TIEMPO DE EJECUCIÓN" + tini);
			} catch (Exception e2) {
				LOG.warn("ERROR AL CERRAR CONEXIÓN" + e2);
			}

		}

	}

}
