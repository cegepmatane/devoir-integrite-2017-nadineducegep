package com.fermedelest.appinventaire.vue;

import com.fermedelest.appinventaire.controleur.EditeurMouton;
import com.fermedelest.appinventaire.modele.Mouton;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MoutonVue extends HBox
{
	
	protected Text valeurNomMouton = new Text("");
	protected Mouton mouton;
	
	public MoutonVue()
	{
		Text libelleNomMouton = new Text("Nom : ");
		
		this.getChildren().add(libelleNomMouton);
		this.getChildren().add(valeurNomMouton);		
	}
	
	public void setMouton(Mouton mouton)
	{
		this.mouton = mouton;
	}
	
	public void afficherMouton(Mouton mouton)
	{
		this.valeurNomMouton.setText(mouton.getNom());
	}
	
	
	protected EditeurMouton moutonControleur = null;
	public void setControleur(EditeurMouton moutonControleur)
	{
		this.moutonControleur = moutonControleur;
	}

}
