package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.vue.MoutonVue;

/**
 * MoutonControleur : controle les reactions aux inputs de MoutonVue
 * */
public class MoutonControleur
{
	protected MoutonVue moutonVue = null; // recevoir ou instancier
	public MoutonControleur(MoutonVue moutonVue)
	{
		this.moutonVue = moutonVue;
		
		// DEBUT TEST
		Mouton moutonCoucou = new Mouton("");
		moutonCoucou.setNom("coucou");		
		this.moutonVue.afficherMouton(moutonCoucou);
		// FIN TEST
		
	}
	
	
}
