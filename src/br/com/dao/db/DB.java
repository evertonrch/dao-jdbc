package br.com.dao.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConn() {
		if(conn != null) {
			try {
				Properties props = loadFile();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException se) {
				throw new DBException(se.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConn() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException se) {
				throw new DBException(se.getMessage());
			}
		}
	}
	
	public static Properties loadFile() {
		try(BufferedReader br = new BufferedReader(new FileReader("db.properties"))){
			Properties props = new Properties();
			props.load(br);
			return props;
		}
		catch(IOException io) {
			throw new DBException(io.getMessage());
		}
	}
}
