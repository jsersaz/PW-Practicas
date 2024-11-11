package es.uco.pw.data.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileReader;

import com.mysql.jdbc.Connection;


public class DBConnection {

	protected Connection connection = null;

	// Important: This configuration is hard-coded here for illustrative purposes only
	
	/*protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i22mujul";

	protected String user = "i22mujul";

	protected String password = "pw2021";*/

	public Connection getConnection(){
		Properties p=new Properties();
		String filename="configure.properties";
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}*/
		try{ 
			BufferedReader lector=new BufferedReader(new FileReader(new File(filename))); 
			p.load(lector);
			String url=p.getProperty("url");
			String user=p.getProperty("user");
			String password=p.getProperty("password");
			
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		}
		catch (SQLException e) {
			System.err.println("		Connection to MySQL has failed!");
			e.printStackTrace();
			
		}
		catch (ClassNotFoundException e) {
			System.err.println("		JDBC Driver not found.");
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			//System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		}
		catch (IOException e) {
			//System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	// We can include here other methods to encapsulate CRUD commands...

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}
