package com.fermedelest.appinventaire.accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

public class TroupeauDAO {
	public static String SQL_LISTER_TROUPEAUX = "SELECT * FROM troupeau";
	
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
				ResultSet curseurTroupeau = requeteListeTroupeaus.executeQuery(SQL_LISTER_TROUPEAUX);
				
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
			
			String SQL_LIRE_TROUPEAU = "SELECT id_troupeau, nom FROM troupeau WHERE id_troupeau = ?";
			PreparedStatement requeteTroupeau = connection.prepareStatement(SQL_LIRE_TROUPEAU);
			requeteTroupeau.setInt(1, id_troupeau);
			ResultSet curseurTroupeau = requeteTroupeau.executeQuery();
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

			String SQL_LIRE_TROUPEAU_AVEC_MOUTON = "SELECT * FROM troupeau WHERE id_troupeau = ?";
			
			PreparedStatement requeteTroupeau = connection.prepareStatement(SQL_LIRE_TROUPEAU_AVEC_MOUTON);
			requeteTroupeau.setInt(1, id_troupeau);
			ResultSet curseurTroupeau = requeteTroupeau.executeQuery();
			curseurTroupeau.next();
			
			String nom = curseurTroupeau.getString("nom");
			String ecurie = curseurTroupeau.getString("ecurie");
			
			troupeau = new Troupeau(nom);
			troupeau.setEcurie(ecurie);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Mouton> listeDesMoutons = new ArrayList<Mouton>();
		
		String SQL_LISTER_MOUTON_SELON_TROUPEAU = "SELECT nom, description FROM mouton WHERE id_troupeau = ?";
		
		PreparedStatement requeteListeMoutons = null;
		try {
			requeteListeMoutons = connection.prepareStatement(SQL_LISTER_MOUTON_SELON_TROUPEAU);
			requeteListeMoutons.setInt(1,  id_troupeau);
			ResultSet curseurMouton = requeteListeMoutons.executeQuery();
			
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
			
			String SQL_AJOUTER_TROUPEAU = "INSERT INTO troupeau(nom, ecurie) VALUES(?,?)";
			PreparedStatement requeteAjouterTroupeau = connection.prepareStatement(SQL_AJOUTER_TROUPEAU);
			requeteAjouterTroupeau.setString(1,  troupeau.getNom());
			requeteAjouterTroupeau.setString(2,  troupeau.getEcurie());
			requeteAjouterTroupeau.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void modifierTroupeau(Troupeau troupeau)
	{
		try {
			
			String SQL_MODIFIER_TROUPEAU = "UPDATE troupeau SET nom = ?, ecurie = ? WHERE id_troupeau = ?";
			PreparedStatement requeteModifierTroupeau = connection.prepareStatement(SQL_MODIFIER_TROUPEAU);
			requeteModifierTroupeau.setString(1, troupeau.getNom());
			requeteModifierTroupeau.setString(2, troupeau.getEcurie());
			requeteModifierTroupeau.setInt(3, troupeau.getId());
			requeteModifierTroupeau.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
