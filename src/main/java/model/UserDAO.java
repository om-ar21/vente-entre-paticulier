package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	public void save(User obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE user set nom=?,prenom=?,email=?,mdp=?,tel=?,del=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getPrenom());
				preparedStatement.setString(3,obj.getEmail());
				preparedStatement.setString(4,obj.getMdp());
				preparedStatement.setString(5,obj.getTel());
				preparedStatement.setBoolean(6,obj.isDel());
				preparedStatement.setInt(7,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO user (nom,prenom,date_inscription,tel,email,mdp) VALUES(?,?,?,?,?,?)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getPrenom());
				preparedStatement.setDate(3,obj.getDate_inscription());
				preparedStatement.setString(4,obj.getTel());
				preparedStatement.setString(5,obj.getEmail());
				preparedStatement.setString(6,obj.getMdp());
			
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public User connexion(String email,String mdp) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.
						prepareStatement("SELECT * FROM user WHERE email=? AND mdp=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,mdp);
				ResultSet resultat=preparedStatement.executeQuery();
				User u = new User();
				if(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDate_inscription(resultat.getDate("date_inscription"));
					u.setEmail(resultat.getString( "email" ));
					u.setTel(resultat.getString( "tel" ));
					u.setMdp(resultat.getString( "mdp" ));
					u.setDel(resultat.getBoolean( "del" ));
					
					return u;
				}else {
					return null;
				}
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<User> getAll() {
		ArrayList<User> list = new ArrayList<User>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM user");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					User u = new User();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setEmail(resultat.getString( "email" ));
					u.setMdp(resultat.getString( "mdp" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public User getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM user WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				User u = new User();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));	
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString("prenom"));
					u.setDate_inscription(resultat.getDate("date_inscription"));
					u.setEmail(resultat.getString( "email" ));
					u.setTel(resultat.getString( "tel" ));
					u.setMdp(resultat.getString( "mdp" ));
					u.setDel(resultat.getBoolean( "del" ));
					
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public int verifyEmail(String email) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT count(*) as mail FROM user WHERE email=?");
				preparedStatement.setString(1,email);
				
				
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();

				int total = resultat.getInt( "mail" );
				return total;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return 0;
        }
	}
	
	

}
