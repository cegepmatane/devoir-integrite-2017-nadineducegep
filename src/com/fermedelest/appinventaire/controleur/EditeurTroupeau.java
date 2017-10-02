package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.modele.Troupeau;
import com.fermedelest.appinventaire.vue.FermeVue;
import com.fermedelest.appinventaire.vue.FormulaireAjouterTroupeauVue;
import com.fermedelest.appinventaire.vue.ListeTroupeauVue;

public class EditeurTroupeau {

	protected FermeVue fermeVue;
	protected ListeTroupeauVue listeTroupeauVue = null;
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue;
	
	public EditeurTroupeau(FermeVue fermeVue)
	{
		this.fermeVue = fermeVue;		
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
	
	public void ajouterTroupeau()
	{
		Troupeau troupeau = this.formulaireAjouterTroupeauVue.lireFormulaire();
		TroupeauDAO troupeauDAO = new TroupeauDAO();
		troupeauDAO.ajouterTroupeau(troupeau);
		System.out.println("Le troupeau est ajoute");
		this.fermeVue.naviguerListeTroupeau();
		
	}
	
}
