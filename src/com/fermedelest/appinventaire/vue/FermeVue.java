package com.fermedelest.appinventaire.vue;

import java.util.ArrayList;
import java.util.List;

import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.controleur.FormulaireAjouterTroupeauControleur;
import com.fermedelest.appinventaire.controleur.ListeTroupeauControleur;
import com.fermedelest.appinventaire.controleur.MoutonControleur;
import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FermeVue extends Application 
{
	// Singleton
	protected static FermeVue fermeVue = null;
	
	public static FermeVue getInstance()
	{
		if(null == fermeVue)
		{
			fermeVue = new FermeVue();
		}
		
		return fermeVue;
	}
	public FermeVue()
	{
	}
	
	// Fin Singleton
	
	protected Stage scenePrincipale = null;
		
	protected MoutonVue moutonVue = null;
	protected MoutonControleur moutonControleur = null;
	protected ListeMoutonVue listeMoutonVue = null;
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue = null;
	
	protected ListeTroupeauVue listeTroupeauVue = null;
	protected ListeTroupeauControleur listeTroupeauControleur = null;
	protected FormulaireAjouterTroupeauControleur formulaireAjouterTroupeauControleur = null;
	
	protected Scene sceneListeTroupeau = null;
	protected Scene sceneFormulaireAjouterTroupeau = null;
	protected TroupeauDAO troupeauDAO = null; // TODO peut-être ameliorer cette architecture
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		this.troupeauDAO = new TroupeauDAO();
	
		this.moutonVue = new MoutonVue();
		this.moutonControleur = new MoutonControleur(moutonVue);
		this.moutonVue.setControleur(moutonControleur);
		
		this.listeTroupeauVue = new ListeTroupeauVue();
		this.listeTroupeauControleur = new ListeTroupeauControleur(listeTroupeauVue, this);
		this.listeTroupeauVue.setControleur(listeTroupeauControleur);
		this.sceneListeTroupeau = new Scene(this.listeTroupeauVue, 500,500);
		
		this.formulaireAjouterTroupeauVue = new FormulaireAjouterTroupeauVue();
		this.formulaireAjouterTroupeauControleur = new FormulaireAjouterTroupeauControleur(this.formulaireAjouterTroupeauVue, this);
		this.formulaireAjouterTroupeauVue.setControleur(this.formulaireAjouterTroupeauControleur);
		this.sceneFormulaireAjouterTroupeau = new Scene(this.formulaireAjouterTroupeauVue, 500,500);

		// test		
		/*
		List<Mouton> listeMoutons = new ArrayList<Mouton>();
		listeMoutons.add(new Mouton("Dolly"));
		listeMoutons.add(new Mouton("Ardoise"));
		listeMoutons.add(new Mouton("Lactee"));
		listeMoutons.add(new Mouton("Laineux"));
		listeMoutons.add(new Mouton("Atchoum"));
		this.listeMoutonVue = new ListeMoutonVue();
		this.listeMoutonVue.afficherListeMouton(listeMoutons);*/
		
		
		this.listeTroupeauVue.afficherListeTroupeau(troupeauDAO.listerTousLesTroupeaux());		
		
		scenePrincipale.setTitle("Gestion de la ferme");
		scenePrincipale.setScene(this.sceneListeTroupeau);
		scenePrincipale.show();
	}
	protected Scene scene = null;
	
	public void naviguerListeTroupeau()
	{
		this.scenePrincipale.setScene(this.sceneListeTroupeau);	
		this.listeTroupeauVue.afficherListeTroupeau(troupeauDAO.listerTousLesTroupeaux());		
		// La super vue est un peu un controleur de vues
	}
	public void naviguerFormulaireAjouterTroupeau()
	{
		//this.scenePrincipale.setScene(sceneFormulaireModifierTroupeau);	
	}
	public void naviguerFormulaireModifierTroupeau()
	{
		this.scenePrincipale.setScene(sceneFormulaireAjouterTroupeau);	
	}
	
	
}

