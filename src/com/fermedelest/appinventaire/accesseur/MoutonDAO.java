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
	private Connection connection = null;
	
	public MoutonDAO()
	{
		this.connection = AccesseurConnection.getConnection();
	}
	
	public List<Mouton> listerTousLesMoutons()
	{
		List<Mouton> listeDesMoutons = new ArrayList<Mouton>();
		
			Statement requeteListeMoutons = null;
			try {
				requeteListeMoutons = connection.createStatement();
				ResultSet curseurMouton = requeteListeMoutons.executeQuery("SELECT nom, description FROM mouton");
				
				//System.out.println("avant");
				while(curseurMouton.next())
				{
					String nom = curseurMouton.getString("nom");
					String description = curseurMouton.getString("description");
					
					Mouton mouton = new Mouton(nom);
					mouton.setDescription(description);
					
					listeDesMoutons.add(mouton);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("apres");
			
		return listeDesMoutons;
	}

	
	public Mouton lireMouton(int id_mouton)
	{		
		Mouton mouton = null;
		try {
			
			Statement requeteMouton = connection.createStatement();
			ResultSet curseurMouton = requeteMouton.executeQuery("SELECT * FROM mouton WHERE id_mouton = " + id_mouton);
			curseurMouton.next();
			String nom = curseurMouton.getString("nom");
			String description = curseurMouton.getString("description");
				
			mouton = new Mouton(nom);
			mouton.setDescription(description);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mouton;
	}

}
