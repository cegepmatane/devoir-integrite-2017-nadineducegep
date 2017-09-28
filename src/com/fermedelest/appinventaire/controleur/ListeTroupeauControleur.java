package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.vue.ListeTroupeauVue;

public class ListeTroupeauControleur {

	protected ListeTroupeauVue listeTroupeauVue = null;
	
	public ListeTroupeauControleur(ListeTroupeauVue listeTroupeauVue)
	{
		this.listeTroupeauVue = listeTroupeauVue;
	}
	
	public void naviguerFormulaireAjouter()
	{
		System.out.println("Ajouter !");	
	}
	
}
