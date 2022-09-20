package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactDAO {
public void save(Contact obj) {
		
		try {
			
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO contact (email,sujet,message,id_user) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1,obj.getEmail());
				preparedStatement.setString(2,obj.getSujet());
				preparedStatement.setString(3,obj.getMessage());
				preparedStatement.setInt(4,obj.getId_user());
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
