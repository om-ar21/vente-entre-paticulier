package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RechercheDAO {
	public void save(Recherche obj) {
		
		try {
			
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO recherche (id_user,mot,date_rech) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setString(2,obj.getMot());
				preparedStatement.setDate(3,obj.getDate_rech());
	            preparedStatement.executeUpdate();
	            
	            ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            System.out.println("insert ok");
	            
	            
			
			System.out.println("save ok");
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
}
