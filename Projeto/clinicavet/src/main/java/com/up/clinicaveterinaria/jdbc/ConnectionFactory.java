package com.up.clinicaveterinaria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/clinicaveterinariadb",
				"SA", "");
		return con;
	}
}