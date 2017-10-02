package com.fermedelest.appinventaire.vue;

import com.fermedelest.appinventaire.controleur.EditeurTroupeau;
import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormulaireModifierTroupeauVue extends VBox 
{
	protected Troupeau troupeau = null;

	protected TextField champsNom = null;
	protected TextField champsEcurie = null;
	protected EditeurTroupeau editeurTroupeau = null;
	
	public FormulaireModifierTroupeauVue()
	{
		this.champsNom = new TextField();
		HBox ligneNom = new HBox();
		ligneNom.getChildren().add(new Label("Nom"));
		ligneNom.getChildren().add(this.champsNom);
		this.getChildren().add(ligneNom);
		
		this.champsEcurie = new TextField();
		HBox ligneEcurie = new HBox();
		ligneEcurie.getChildren().add(new Label("Ecurie"));
		ligneEcurie.getChildren().add(this.champsEcurie);
		this.getChildren().add(ligneEcurie);
		
		Button actionEnregistrer = new Button("Enregistrer");
		
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{			
				editeurTroupeau.modifierTroupeau();
			}
			
		});
		
		this.getChildren().add(actionEnregistrer);
	}

	public Troupeau lireFormulaire()
	{
		String nom = this.champsNom.getText();
		String ecurie = this.champsEcurie.getText();
		
		troupeau.setNom(nom);
		troupeau.setEcurie(ecurie);
		return troupeau;
	}
	
	public void afficherTroupeau(Troupeau troupeau)
	{
		this.troupeau = troupeau;
		this.champsNom.setText(troupeau.getNom());
		this.champsEcurie.setText(troupeau.getEcurie());
	}

	public void setControleur(EditeurTroupeau controleur)
	{
		this.editeurTroupeau = controleur;
	}
}
