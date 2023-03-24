package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection(){
		
		String url = "jdbc:mariadb://localhost/iscritticorsi?user=root&password=passroot";
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore di connessione");
			e.printStackTrace();
			return null;
		}
	}

}
