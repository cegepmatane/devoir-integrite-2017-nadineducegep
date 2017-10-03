package com.fermedelest.appinventaire.vue;

import com.fermedelest.appinventaire.controleur.EditeurMouton;
import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FormulaireAjouterMoutonVue extends VBox 
{
	
	protected TextField champsNom = null;
	protected TextField champsDescription = null;
	protected EditeurMouton editeurMoutonControleur = null;
	
	// pour le contexte
	protected Troupeau troupeau;
	public void setTroupeau(Troupeau troupeau) {
		this.troupeau = troupeau;
		this.titre.setText(this.TITRE_DEBUT + troupeau.getNom());
	}

	public String TITRE_DEBUT = "Ajouter un mouton dans le troupeau ";
	protected Text titre;
	public FormulaireAjouterMoutonVue()
	{
		titre = new Text(TITRE_DEBUT);
		HBox ligneTitre = new HBox();
		ligneTitre.getChildren().add(titre);
		this.getChildren().add(ligneTitre);
		
		this.champsNom = new TextField();
		HBox ligneNom = new HBox();
		ligneNom.getChildren().add(new Label("Nom"));
		ligneNom.getChildren().add(this.champsNom);
		this.getChildren().add(ligneNom);
		
		this.champsDescription = new TextField();
		HBox ligneDescription = new HBox();
		ligneDescription.getChildren().add(new Label("Description"));
		ligneDescription.getChildren().add(this.champsDescription);
		this.getChildren().add(ligneDescription);
	
		Button actionEnregistrer = new Button("Enregistrer");
		
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) 
			{			
				//editeurMoutonControleur.ajouterMouton();
			}
			
		});
		
		this.getChildren().add(actionEnregistrer);
	}
	
	public Mouton lireFormulaire()
	{
		String nom = this.champsNom.getText();
		String description = this.champsDescription.getText();
		Mouton mouton = new Mouton(nom);
		mouton.setDescription(description);
		return mouton;
	}

	public void setControleur(EditeurMouton controleur)
	{
		this.editeurMoutonControleur = controleur;
	}
}
