package com.fermedelest.appinventaire.vue;

import java.util.ArrayList;
import java.util.List;

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
	
	protected Stage scenePrincipale;
		
	protected MoutonVue moutonVue = null;
	protected MoutonControleur moutonControleur = null;
	protected ListeMoutonVue listeMoutonVue = null;
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue = null;
	
	protected ListeTroupeauVue listeTroupeauVue = null;
	protected ListeTroupeauControleur listeTroupeauControleur = null;
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		
		this.moutonVue = new MoutonVue();
		this.moutonControleur = new MoutonControleur(moutonVue);
		this.moutonVue.setControleur(moutonControleur);
		
		this.listeTroupeauVue = new ListeTroupeauVue();
		this.listeTroupeauControleur = new ListeTroupeauControleur(listeTroupeauVue);
		this.listeTroupeauVue.setControleur(listeTroupeauControleur);
		
		// test
		
		List<Mouton> listeMoutons = new ArrayList<Mouton>();
		listeMoutons.add(new Mouton("Dolly"));
		listeMoutons.add(new Mouton("Ardoise"));
		listeMoutons.add(new Mouton("Lactee"));
		listeMoutons.add(new Mouton("Laineux"));
		listeMoutons.add(new Mouton("Atchoum"));
		this.listeMoutonVue = new ListeMoutonVue();
		this.listeMoutonVue.afficherListeMouton(listeMoutons);
		
		
		// test
		
		List<Troupeau> listeTroupeau = new ArrayList<Troupeau>();
		listeTroupeau.add(new Troupeau("Les peureux"));
		listeTroupeau.add(new Troupeau("Les frises"));
		listeTroupeau.add(new Troupeau("Les aventureux"));
		this.listeTroupeauVue.afficherListeTroupeau(listeTroupeau);
		
		this.formulaireAjouterTroupeauVue = new FormulaireAjouterTroupeauVue();
		
		scenePrincipale.setTitle("Gestion de la ferme");
		scenePrincipale.setScene(new Scene(this.listeTroupeauVue, 500,500));
		scenePrincipale.show();
	}
	
	public void naviguerFormulaireAjouterTroupeau()
	{
		scenePrincipale.setScene(new Scene(this.formulaireAjouterTroupeauVue, 500,500));		
	}
	
	
}

