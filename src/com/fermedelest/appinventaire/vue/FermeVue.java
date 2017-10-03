package com.fermedelest.appinventaire.vue;

import java.util.ArrayList;
import java.util.List;

import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.controleur.EditeurTroupeau;
import com.fermedelest.appinventaire.controleur.EditeurMouton;
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
		
	protected EditeurMouton editeurMoutonControleur = null;
	
	protected MoutonVue moutonVue = null;
	protected FormulaireAjouterMoutonVue formulaireAjouterMoutonVue = null;
	
	protected Scene sceneFormulaireAjouterMouton = null;
	
	protected EditeurTroupeau editeurTroupeauControleur = null;
	
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue = null;
	protected ListeTroupeauVue listeTroupeauVue = null;
	protected FormulaireModifierTroupeauVue formulaireModifierTroupeauVue = null;
	
	protected Scene sceneListeTroupeau = null;
	protected Scene sceneFormulaireAjouterTroupeau = null;
	protected Scene sceneFormulaireModifierTroupeau = null;
	
	protected TroupeauDAO troupeauDAO = null; // TODO peut-être ameliorer cette architecture
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		this.troupeauDAO = new TroupeauDAO();
		
		this.editeurMoutonControleur = new EditeurMouton(this);
	
		this.moutonVue = new MoutonVue();
		this.moutonVue.setControleur(editeurMoutonControleur);
		
		this.formulaireAjouterMoutonVue = new FormulaireAjouterMoutonVue();
		this.editeurMoutonControleur.setFormulaireAjouterMoutonVue(this.formulaireAjouterMoutonVue);
		this.formulaireAjouterMoutonVue.setControleur(editeurMoutonControleur);
		this.sceneFormulaireAjouterMouton = new Scene(this.formulaireAjouterMoutonVue, 500,500);
		
		this.editeurTroupeauControleur = new EditeurTroupeau(this);
		
		this.listeTroupeauVue = new ListeTroupeauVue();
		this.editeurTroupeauControleur.setListeTroupeauVue(listeTroupeauVue);
		this.listeTroupeauVue.setControleur(editeurTroupeauControleur);
		this.sceneListeTroupeau = new Scene(this.listeTroupeauVue, 500,500);
		
		this.formulaireAjouterTroupeauVue = new FormulaireAjouterTroupeauVue();
		this.editeurTroupeauControleur.setFormulaireAjouterTroupeauVue(formulaireAjouterTroupeauVue);
		this.formulaireAjouterTroupeauVue.setControleur(this.editeurTroupeauControleur);
		this.sceneFormulaireAjouterTroupeau = new Scene(this.formulaireAjouterTroupeauVue, 500,500);
		
		this.formulaireModifierTroupeauVue = new FormulaireModifierTroupeauVue();
		this.editeurTroupeauControleur.setFormulaireModifierTroupeauVue(formulaireModifierTroupeauVue);
		this.editeurMoutonControleur.setFormulaireModifierTroupeauVue(formulaireModifierTroupeauVue); ///
		this.formulaireModifierTroupeauVue.setControleur(this.editeurTroupeauControleur);
		this.formulaireModifierTroupeauVue.setControleurMouton(this.editeurMoutonControleur); ///
		this.sceneFormulaireModifierTroupeau = new Scene(this.formulaireModifierTroupeauVue, 500,500);		
		
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
		this.scenePrincipale.setScene(sceneFormulaireAjouterTroupeau);	
	}
	public void naviguerFormulaireModifierTroupeau()
	{
		this.scenePrincipale.setScene(sceneFormulaireModifierTroupeau);	
	}
	public void naviguerFormulaireAjouterMouton()
	{
		this.scenePrincipale.setScene(sceneFormulaireAjouterMouton);	
	}
	
	
}

