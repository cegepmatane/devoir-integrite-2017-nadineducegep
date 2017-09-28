package com.fermedelest.appinventaire.vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormulaireAjouterTroupeauVue extends VBox 
{
	public FormulaireAjouterTroupeauVue()
	{
		HBox ligneNom = new HBox();
		ligneNom.getChildren().add(new Label("Nom"));
		ligneNom.getChildren().add(new TextField());
		this.getChildren().add(ligneNom);
		
		HBox ligneEcurie = new HBox();
		ligneEcurie.getChildren().add(new Label("Ecurie"));
		ligneEcurie.getChildren().add(new TextField());
		this.getChildren().add(ligneEcurie);
		
		this.getChildren().add(new Button("Enregistrer"));
		
	}
}
