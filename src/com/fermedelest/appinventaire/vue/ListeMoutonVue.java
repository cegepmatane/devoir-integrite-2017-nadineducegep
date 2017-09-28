package com.fermedelest.appinventaire.vue;

import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ListeMoutonVue extends VBox
{
	protected List<Mouton> listeMouton = null;
	
	public ListeMoutonVue()
	{
		//this.setPrefColumns(1);
		//this.setMaxWidth(1);
	}
	
	public void afficherListeMouton(List<Mouton> listeMouton)
	{
		this.getChildren().add(new Button("Ajouter"));
		this.listeMouton = listeMouton;
		for(Mouton mouton:listeMouton)
		{
			HBox ligneVisuelle = new HBox();
			System.out.println(mouton.getNom());
			ligneVisuelle.getChildren().add(new Text(mouton.getNom()));
			ligneVisuelle.getChildren().add(new Button("Modifier"));
			ligneVisuelle.getChildren().add(new Button("Supprimer"));
			this.getChildren().add(ligneVisuelle);
		}
		
	}
	
}
