package com.fermedelest.appinventaire.vue;

import java.util.List;

import com.fermedelest.appinventaire.modele.Mouton;

import javafx.scene.layout.VBox;

public class ListeMoutonVue extends VBox
{
	protected List<Mouton> listeMouton = null;
	
	public void afficherListeMouton(List<Mouton> listeMouton)
	{
		this.listeMouton = listeMouton;
		
		
	}
	
}
