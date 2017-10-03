package com.fermedelest.appinventaire.accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

public class TroupeauDAO {
	
	private Connection connection = null;
	public TroupeauDAO()
	{
		this.connection = AccesseurConnection.getConnection();		
	}

	public List<Troupeau> listerTousLesTroupeaux()
	{
		List<Troupeau> listeDesTroupeaus = new ArrayList<Troupeau>();
		
			Statement requeteListeTroupeaus = null;
			try {
				requeteListeTroupeaus = connection.createStatement();
				ResultSet curseurTroupeau = requeteListeTroupeaus.executeQuery("SELECT * FROM troupeau");
				
				//System.out.println("avant");
				while(curseurTroupeau.next())
				{
					int id = curseurTroupeau.getInt("id_troupeau");
					String nom = curseurTroupeau.getString("nom");
					String ecurie = curseurTroupeau.getString("ecurie");
					
					Troupeau troupeau = new Troupeau(nom);
					troupeau.setEcurie(ecurie);
					troupeau.setId(id);
					
					listeDesTroupeaus.add(troupeau);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("apres");
			
		return listeDesTroupeaus;
	}

	
	public Troupeau lireTroupeau(int id_troupeau)
	{		
		Troupeau troupeau = null;
		try {
			
			Statement requeteTroupeau = connection.createStatement();
			ResultSet curseurTroupeau = requeteTroupeau.executeQuery("SELECT id_troupeau, nom FROM troupeau WHERE id_troupeau = " + id_troupeau);
			curseurTroupeau.next();
			
			String nom = curseurTroupeau.getString("nom");
			String ecurie = curseurTroupeau.getString("ecurie");
			
			troupeau = new Troupeau(nom);
			troupeau.setEcurie(ecurie);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return troupeau;
	}
	
	
	public Troupeau lireTroupeauAvecMoutons(int id_troupeau)
	{		
		Troupeau troupeau = null;
		try {
			
			Statement requeteTroupeau = connection.createStatement();
			ResultSet curseurTroupeau = requeteTroupeau.executeQuery("SELECT * FROM troupeau WHERE id_troupeau = " + id_troupeau);
			curseurTroupeau.next();
			
			String nom = curseurTroupeau.getString("nom");
			String ecurie = curseurTroupeau.getString("ecurie");
			
			troupeau = new Troupeau(nom);
			troupeau.setEcurie(ecurie);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Mouton> listeDesMoutons = new ArrayList<Mouton>();
		
		Statement requeteListeMoutons = null;
		try {
			requeteListeMoutons = connection.createStatement();
			ResultSet curseurMouton = requeteListeMoutons.executeQuery("SELECT nom, description FROM mouton WHERE id_troupeau = " + id_troupeau);
			// TODO requete preparee
			
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

		troupeau.setListeMoutons(listeDesMoutons);
		
		return troupeau;
	}
	
	
	public void ajouterTroupeau(Troupeau troupeau)
	{
		try {
			
			Statement requeteAjouterTroupeau = connection.createStatement();
			requeteAjouterTroupeau.executeUpdate(
					"INSERT INTO troupeau(nom, ecurie) VALUES('"+troupeau.getNom()+"','"+troupeau.getEcurie()+"')");
			// TODO changer en requete preparee
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void modifierTroupeau(Troupeau troupeau)
	{
		try {
			
			Statement requeteModifierTroupeau = connection.createStatement();
			requeteModifierTroupeau.executeUpdate(
					"UPDATE troupeau SET nom = '"+troupeau.getNom()+"', ecurie = '"+troupeau.getEcurie()+"' WHERE id_troupeau = "+troupeau.getId());
			// TODO changer en requete preparee
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
