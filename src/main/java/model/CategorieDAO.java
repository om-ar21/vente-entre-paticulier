package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategorieDAO {
	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> list = new ArrayList<Categorie>();
		
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE del=0");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Categorie o = new Categorie();
					o.setId(resultat.getInt( "id" ));
					o.setTitre(resultat.getString( "titre" ));
					o.setDel(resultat.getBoolean( "del" ));
					
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public Categorie getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE id=? and del=0");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Categorie u = new Categorie();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));	
					u.setTitre(resultat.getString( "titre" ));
					u.setDel(resultat.getBoolean("del"));
					
					
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}

}
