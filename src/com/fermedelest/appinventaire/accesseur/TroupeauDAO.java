package com.fermedelest.appinventaire.accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				ResultSet curseurTroupeau = requeteListeTroupeaus.executeQuery("SELECT nom, ecurie FROM troupeau");
				
				//System.out.println("avant");
				while(curseurTroupeau.next())
				{
					String nom = curseurTroupeau.getString("nom");
					String ecurie = curseurTroupeau.getString("ecurie");
					
					Troupeau troupeau = new Troupeau(nom);
					troupeau.setEcurie(ecurie);
					
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
			ResultSet curseurTroupeau = requeteTroupeau.executeQuery("SELECT * FROM troupeau WHERE id_troupeau = " + id_troupeau);
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
	
	
}
