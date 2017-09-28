package com.fermedelest.appinventaire.modele;

public class Mouton 
{
	protected String nom;
	protected char sexe;
	protected char couleur;
	protected String sousespece;
	protected String description;
	protected Troupeau troupeau;
	
	public Mouton(String nom)
	{
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public char getCouleur() {
		return couleur;
	}
	public void setCouleur(char couleur) {
		this.couleur = couleur;
	}
	public String getSousespece() {
		return sousespece;
	}
	public void setSousespece(String sousespece) {
		this.sousespece = sousespece;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
