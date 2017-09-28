package com.fermedelest.appinventaire.accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesseurConnection {
	
	public static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	public static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/fermedelest";
	public static String BASEDEDONNEES_USAGER = "postgres";
	public static String BASEDEDONNEES_MOTDEPASSE = "informatique";
	private static Connection connection = null;	
	
	public AccesseurConnection()
	{
	}
	
	public static Connection getConnection()
	{
		if(null == connection)
		{
			try {
				Class.forName(BASEDEDONNEES_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			//connection.close();			
		}
		return connection;
	}
	

}
