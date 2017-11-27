package com.fermedelest.appinventaire.accesseur.sql;

public interface TroupeauSQL {
	public static String SQL_LISTER_TROUPEAUX = "SELECT * FROM troupeau";
	public static String SQL_LIRE_TROUPEAU = "SELECT id_troupeau, nom FROM troupeau WHERE id_troupeau = ?";
	public static String SQL_LIRE_TROUPEAU_AVEC_MOUTON = "SELECT * FROM troupeau WHERE id_troupeau = ?";
	public static String SQL_LISTER_MOUTON_SELON_TROUPEAU = "SELECT nom, description FROM mouton WHERE id_troupeau = ?";			
	public static String SQL_AJOUTER_TROUPEAU = "INSERT INTO troupeau(nom, ecurie) VALUES(?,?)";
	public static String SQL_MODIFIER_TROUPEAU = "UPDATE troupeau SET nom = ?, ecurie = ? WHERE id_troupeau = ?";
}
