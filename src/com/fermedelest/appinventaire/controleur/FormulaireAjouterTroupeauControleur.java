package com.fermedelest.appinventaire.controleur;

import com.fermedelest.appinventaire.accesseur.TroupeauDAO;
import com.fermedelest.appinventaire.modele.Troupeau;
import com.fermedelest.appinventaire.vue.FermeVue;
import com.fermedelest.appinventaire.vue.FormulaireAjouterTroupeauVue;

public class FormulaireAjouterTroupeauControleur {

	protected FermeVue fermeVue;
	protected FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue;
	public FormulaireAjouterTroupeauControleur(FormulaireAjouterTroupeauVue formulaireAjouterTroupeauVue,FermeVue fermeVue) 
	{
		this.fermeVue = fermeVue;
		this.formulaireAjouterTroupeauVue = formulaireAjouterTroupeauVue;
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
