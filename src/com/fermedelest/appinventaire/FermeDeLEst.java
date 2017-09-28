package com.fermedelest.appinventaire;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.fermedelest.appinventaire.accesseur.MoutonDAO;
import com.fermedelest.appinventaire.modele.Mouton;

public class FermeDeLEst {

	public static void main(String[] args) 
	{

		MoutonDAO accesseurMouton = new MoutonDAO();
		List<Mouton> listeMoutons = accesseurMouton.listerTousLesMoutons();
		System.out.println("Nombre de moutons " + listeMoutons.size());
		
		for(Iterator<Mouton> visiteurMoutons = listeMoutons.iterator(); visiteurMoutons.hasNext(); )
		{
			Mouton mouton = visiteurMoutons.next();
			System.out.println("mouton" + mouton.getNom() + " " + mouton.getDescription() );
			
		}
		
	}

}
