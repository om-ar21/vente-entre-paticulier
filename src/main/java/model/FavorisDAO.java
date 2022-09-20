package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FavorisDAO {
	public void save(Favoris obj) {
		
		try {
			
			
				 
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO favoris (id_annonce,id_user) VALUES(?,?)");
				preparedStatement.setInt(1,obj.getId_annonce());
				preparedStatement.setInt(2,obj.getId_user());
				
			
	            preparedStatement.executeUpdate();
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	
	public ArrayList<Favoris> getAllById(int userid) {
		ArrayList<Favoris> list = new ArrayList<Favoris>();
	
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM favoris WHERE id_user=? and id_annonce in(select id from annonce where del=0 and val=1)");
				preparedStatement.setInt(1,userid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Favoris u = new Favoris ();
					u.setId(resultat.getInt( "id" )); 
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_annonce(resultat.getInt("id_annonce"));
					
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public Favoris getByIdAnnonce(int idannonce) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM favoris WHERE id_annonce=?");
				preparedStatement.setInt(1,idannonce);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Favoris u = new Favoris();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setId_annonce(resultat.getInt( "id_annonce" ));
					u.setId_user(resultat.getInt( "id_user" ));
					
					
					
					
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public void deleteById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM favoris WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	public int countFavoris(int id_user) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT count(*) as fav FROM favoris WHERE id_user=? and id_annonce in(select id from annonce where del=0 and val=1)");
				preparedStatement.setInt(1,id_user);
				
				
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();

				int total = resultat.getInt( "fav" );
				return total;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return 0;
        }
	}
}
