package com.fermedelest.appinventaire;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.fermedelest.appinventaire.accesseur.MoutonDAO;
import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.controleur.EditeurMouton;
import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;
import com.fermedelest.appinventaire.vue.FermeVue;

public class FermeDeLEst {

	public static void main(String[] args) 
	{		
		FermeVue fermeVue = FermeVue.getInstance();
		fermeVue.launch(FermeVue.class, args);
		
		//MoutonControleur controleurMouton = new MoutonControleur(moutonVue);
		//controleurMouton.start();

		/*
		TroupeauDAO accesseurTroupeau = new TroupeauDAO();
		List<Troupeau> listeTroupeaux = accesseurTroupeau.listerTousLesTroupeaux();
		
		for(Troupeau troupeau:listeTroupeaux)
		{
			System.out.println(troupeau.getNom());
		}
		*/
		/*
		MoutonDAO accesseurMouton = new MoutonDAO();
		List<Mouton> listeMoutons = accesseurMouton.listerTousLesMoutons();
		System.out.println("Nombre de moutons " + listeMoutons.size());
		
		for(Iterator<Mouton> visiteurMoutons = listeMoutons.iterator(); visiteurMoutons.hasNext(); )
		{
			Mouton mouton = visiteurMoutons.next();
			System.out.println("mouton" + mouton.getNom() + " " + mouton.getDescription() );
		}	
		
		Mouton mouton = accesseurMouton.lireMouton(2);
		System.out.println("Le mouton 2 est " + mouton.getNom());
		*/
		
		
	}

}
