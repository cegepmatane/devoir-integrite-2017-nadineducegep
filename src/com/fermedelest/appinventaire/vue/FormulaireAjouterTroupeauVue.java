package com.fermedelest.appinventaire.vue;

import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormulaireAjouterTroupeauVue extends VBox 
{
	
	protected TextField champsNom = null;
	protected TextField champsEcurie = null;
	
	public FormulaireAjouterTroupeauVue()
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
		
		this.getChildren().add(new Button("Enregistrer"));
	}
	
	public Troupeau lireFormulaire()
	{
		String nom = this.champsNom.getText();
		String ecurie = this.champsEcurie.getText();
		Troupeau troupeau = new Troupeau(nom);
		troupeau.setEcurie(ecurie);
		return troupeau;
	}
}
