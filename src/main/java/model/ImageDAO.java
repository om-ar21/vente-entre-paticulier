package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ImageDAO {
	public void save(Image obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE image set id_annonce=?,lien=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_annonce());
				preparedStatement.setString(2,obj.getLien());
				preparedStatement.setInt(3,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO image (id_annonce,lien) VALUES(?,?)");
				preparedStatement.setInt(1,obj.getId_annonce());
				preparedStatement.setString(2,obj.getLien());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	public ArrayList<Image> getAllByIdAnnonce(int idannonce) {
		ArrayList<Image> list = new ArrayList<Image>();
		
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM image WHERE id_annonce=? AND del=0");
			preparedStatement.setInt(1,idannonce);
			ResultSet resultat=preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Image o = new Image();
				o.setId(resultat.getInt( "id" ));
				o.setId_annonce(resultat.getInt( "id_annonce" ));
				o.setLien(resultat.getString( "lien" ));
				o.setDel(resultat.getBoolean( "del" ));
    			
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM image WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}

}
