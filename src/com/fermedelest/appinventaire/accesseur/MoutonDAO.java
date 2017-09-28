package com.fermedelest.appinventaire.accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;

public class MoutonDAO 
{
	
	public List<Mouton> listerTousLesMoutons()
	{
		List<Mouton> listeDesMoutons = new ArrayList<Mouton>();
		
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fermedelest", "postgres", "informatique");
			
			Statement requeteListeMoutons = connection.createStatement();
			ResultSet curseurMouton = requeteListeMoutons.executeQuery("SELECT * FROM mouton");
			
			//System.out.println("avant");
			while(curseurMouton.next())
			{
				String nom = curseurMouton.getString("nom");
				String description = curseurMouton.getString("description");
				
				Mouton mouton = new Mouton();
				mouton.setNom(nom);
				mouton.setDescription(description);
				
				listeDesMoutons.add(mouton);
			}
			
			//System.out.println("apres");
			
			connection.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeDesMoutons;
	}
	
}
