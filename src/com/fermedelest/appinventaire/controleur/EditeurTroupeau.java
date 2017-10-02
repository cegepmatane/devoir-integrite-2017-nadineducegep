package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.modele.Troupeau;
import com.fermedelest.appinventaire.vue.FermeVue;
import com.fermedelest.appinventaire.vue.FormulaireAjouterTroupeauVue;
import com.fermedelest.appinventaire.vue.FormulaireModifierTroupeauVue;
import com.fermedelest.appinventaire.vue.ListeTroupeauVue;

public class EditeurTroupeau {

	protected FermeVue fermeVue;
	protected ListeTroupeauVue listeTroupeauVue = null;
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue;
	protected FormulaireModifierTroupeauVue formulaireModifierTroupeauVue;
	
	public EditeurTroupeau(FermeVue fermeVue)
	{
		this.fermeVue = fermeVue;		
	}
	
	public void setFormulaireModifierTroupeauVue(FormulaireModifierTroupeauVue formulaireModifierTroupeauVue) {
		this.formulaireModifierTroupeauVue = formulaireModifierTroupeauVue;
	}

	public void setListeTroupeauVue(ListeTroupeauVue listeTroupeauVue) {
		this.listeTroupeauVue = listeTroupeauVue;
	}

	public void setFormulaireAjouterTroupeauVue(FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue) {
		this.formulaireAjouterTroupeauVue = formulaireAjouterTroupeauVue;
	}

	public void naviguerFormulaireAjouter()
	{
		fermeVue.naviguerFormulaireAjouterTroupeau();
	}
	
	public void naviguerFormulaireModifier(Troupeau troupeau)
	{
		System.out.println("Naviguer pour modifier le troupeau " + troupeau.getId());
		fermeVue.naviguerFormulaireModifierTroupeau();
	}
	
	public void ajouterTroupeau()
	{
		Troupeau troupeau = this.formulaireAjouterTroupeauVue.lireFormulaire();
		TroupeauDAO troupeauDAO = new TroupeauDAO();
		troupeauDAO.ajouterTroupeau(troupeau);
		System.out.println("Le troupeau est ajoute");
		this.fermeVue.naviguerListeTroupeau();
		
	}
	
}
