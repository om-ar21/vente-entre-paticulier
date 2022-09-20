package model;

import java.sql.PreparedStatement;

public class SignalementDAO {
	public void save(Signalement obj) {
		
		
		try {
			
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO signalement (id_user,id_annonce,sujet,message) VALUES(?,?,?,?)");
				
			    preparedStatement.setInt(1, obj.getId_user());
			    preparedStatement.setInt(2, obj.getId_annonce());
	            preparedStatement.setString(3, obj.getSujet());
	            preparedStatement.setString(4, obj.getMessage());
	            preparedStatement.executeUpdate();
				
	            
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
}
