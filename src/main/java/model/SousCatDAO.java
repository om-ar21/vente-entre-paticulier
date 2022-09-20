package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SousCatDAO {
	public ArrayList<SousCat> getAllById(int idcat) {
		ArrayList<SousCat> list = new ArrayList<SousCat>();
//		CategorieDAO p = new CategorieDAO();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM souscat WHERE id_categorie=? AND del=0");
				preparedStatement.setInt(1,idcat);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					SousCat u = new SousCat ();
					u.setId(resultat.getInt( "id" ));
					u.setId_categorie(resultat.getInt( "id_categorie" ));
					u.setTitre(resultat.getString("titre"));
					u.setDel(resultat.getBoolean("del"));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public SousCat getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM souscat WHERE id=? and del=0");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			SousCat u = new SousCat();

			u.setId(resultat.getInt( "id" ));
			u.setId_categorie(resultat.getInt( "id_categorie" ));
			u.setTitre(resultat.getString("titre"));
			u.setDel(resultat.getBoolean("del"));
			

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
