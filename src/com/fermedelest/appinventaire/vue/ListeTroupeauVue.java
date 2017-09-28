package com.fermedelest.appinventaire.vue;

import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ListeTroupeauVue extends VBox
{
	protected List<Troupeau> listeTroupeau = null;
	
	public ListeTroupeauVue()
	{
		//this.setPrefColumns(1);
		//this.setMaxWidth(1);
	}
	
	public void afficherListeTroupeau(List<Troupeau> listeTroupeau)
	{
		this.getChildren().add(new Button("Ajouter"));
		this.listeTroupeau = listeTroupeau;
		for(Troupeau troupeau:listeTroupeau)
		{
			HBox ligneVisuelle = new HBox();
			System.out.println(troupeau.getNom());
			ligneVisuelle.getChildren().add(new Text(troupeau.getNom()));
			ligneVisuelle.getChildren().add(new Button("Modifier"));
			ligneVisuelle.getChildren().add(new Button("Supprimer"));
			this.getChildren().add(ligneVisuelle);
		}
		
	}
	
}
