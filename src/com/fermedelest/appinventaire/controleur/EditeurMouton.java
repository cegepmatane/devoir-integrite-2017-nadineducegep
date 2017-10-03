package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.modele.Mouton;
import com.fermedelest.appinventaire.modele.Troupeau;
import com.fermedelest.appinventaire.vue.FermeVue;
import com.fermedelest.appinventaire.vue.FormulaireAjouterMoutonVue;
import com.fermedelest.appinventaire.vue.FormulaireModifierTroupeauVue;
import com.fermedelest.appinventaire.vue.MoutonVue;

/**
 * MoutonControleur : controle les reactions aux inputs de MoutonVue
 * */
public class EditeurMouton
{
	protected FormulaireAjouterMoutonVue formulaireAjouterMoutonVue = null;
	protected FormulaireModifierTroupeauVue formulaireModifierTroupeauVue = null;
	
	protected FermeVue fermeVue = null;
	public EditeurMouton(FermeVue fermeVue)
	{
		this.fermeVue = fermeVue;
	}
	
	public void setFormulaireAjouterMoutonVue(FormulaireAjouterMoutonVue formulaireAjouterMoutonVue)
	{
		this.formulaireAjouterMoutonVue = formulaireAjouterMoutonVue;
	}
	
	public void setFormulaireModifierTroupeauVue(FormulaireModifierTroupeauVue formulaireModifierTroupeauVue) {
		this.formulaireModifierTroupeauVue = formulaireModifierTroupeauVue;
	}
	
	public void naviguerFormulaireAjouterMouton()
	{
		System.out.println("naviguerFormulaireAjouterMouton()");
		Troupeau troupeau = this.formulaireModifierTroupeauVue.lireFormulaire();
		this.formulaireAjouterMoutonVue.setTroupeau(troupeau);
		fermeVue.naviguerFormulaireAjouterMouton();		
	}
}
