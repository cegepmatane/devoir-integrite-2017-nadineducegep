package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.vue.FermeVue;
import com.fermedelest.appinventaire.vue.ListeTroupeauVue;

public class ListeTroupeauControleur {

	protected ListeTroupeauVue listeTroupeauVue = null;
	protected FermeVue fermeVue;
	
	public ListeTroupeauControleur(ListeTroupeauVue listeTroupeauVue, FermeVue fermeVue)
	{
		this.listeTroupeauVue = listeTroupeauVue;
		this.fermeVue = fermeVue;
	}
	
	public void naviguerFormulaireAjouter()
	{
		fermeVue.naviguerFormulaireAjouterTroupeau();
	}
	
	
}
