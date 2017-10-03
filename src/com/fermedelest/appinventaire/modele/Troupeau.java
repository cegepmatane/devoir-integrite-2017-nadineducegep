package com.fermedelest.appinventaire.modele;

import java.util.List;

public class Troupeau {
	
	protected int id;
	protected String nom;
	protected String ecurie;
	protected List<Mouton> listeMoutons = null;
	
	public List<Mouton> getListeMoutons() {
		return listeMoutons;
	}

	public void setListeMoutons(List<Mouton> listeMoutons) {
		this.listeMoutons = listeMoutons;
	}

	public Troupeau(String nom)
	{
		this.nom = nom;
		this.ecurie = "centrale";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEcurie() {
		return ecurie;
	}

	public void setEcurie(String ecurie) {
		this.ecurie = ecurie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
