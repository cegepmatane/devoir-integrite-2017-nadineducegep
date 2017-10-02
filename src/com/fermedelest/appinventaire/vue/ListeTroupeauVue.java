package com.fermedelest.appinventaire.vue;

import java.util.List;

import com.fermedelest.appinventaire.controleur.ListeTroupeauControleur;
import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ListeTroupeauVue extends VBox
{
	protected List<Troupeau> listeTroupeau = null;
	protected ListeTroupeauControleur listeTroupeauControleur = null;
	
	public ListeTroupeauVue()
	{
		//this.setPrefColumns(1);
		//this.setMaxWidth(1);
	}
	
	public void afficherListeTroupeau(List<Troupeau> listeTroupeau)
	{
		
		Button actionAjouter = new Button("Ajouter");
		actionAjouter.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent evenement) 
				{
					listeTroupeauControleur.naviguerFormulaireAjouter();
				}
			});
		
		this.getChildren().clear(); // TODO optimiser avec une mise a jour differentielle ?
		
		this.getChildren().add(actionAjouter);
		
		this.listeTroupeau = listeTroupeau;
		for(Troupeau troupeau:listeTroupeau)
		{
			Button boutonModifier = new Button("Modifier");
			boutonModifier.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent evenement) 
				{
					
				}
			});
			
			HBox ligneVisuelle = new HBox();
			System.out.println(troupeau.getNom());
			ligneVisuelle.getChildren().add(new Text(troupeau.getNom()));
			ligneVisuelle.getChildren().add(boutonModifier);
			ligneVisuelle.getChildren().add(new Button("Supprimer"));
			this.getChildren().add(ligneVisuelle);
		}
		
	}
	
	public void setControleur(ListeTroupeauControleur listeTroupeauControleur)
	{
		this.listeTroupeauControleur = listeTroupeauControleur;
	}
	
}
