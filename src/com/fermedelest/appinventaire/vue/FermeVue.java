package com.fermedelest.appinventaire.vue;

import com.fermedelest.appinventaire.controleur.MoutonControleur;
import com.fermedelest.appinventaire.modele.Mouton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FermeVue extends Application 
{
	protected Stage scenePrincipale;
	
	public FermeVue()
	{
	}
	
	protected MoutonVue moutonVue = null;
	protected MoutonControleur moutonControleur = null;
	protected ListeMoutonVue listeMoutonVue = null;
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.moutonVue = new MoutonVue();
		this.moutonControleur = new MoutonControleur(moutonVue);
		this.moutonVue.setControleur(moutonControleur);
		
		this.listeMoutonVue = new ListeMoutonVue();
		
		this.scenePrincipale = scenePrincipale;
		scenePrincipale.setTitle("Gestion de la ferme");
		scenePrincipale.setScene(new Scene(listeMoutonVue, 500,500));
		scenePrincipale.show();
	}
	
}

