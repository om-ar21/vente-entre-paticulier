package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VisiteDAO {
	public void save(Visite obj) {
		
		
		try {
			
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO visite (id_annonce,id_user,date_visite) VALUES(?,?,?)");
				preparedStatement.setInt(1, obj.getId_annonce());
			    preparedStatement.setInt(2, obj.getId_user());
	            preparedStatement.setDate(3, obj.getDate_visite());
	            preparedStatement.executeUpdate();
				
	            
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public int getVisite(int id_annonce) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT count(*) as vis FROM visite WHERE id_annonce=?");
				preparedStatement.setInt(1,id_annonce);
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();

				int total = resultat.getInt( "vis" );
				return total;
				
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return 0;
	    }
	}
}
