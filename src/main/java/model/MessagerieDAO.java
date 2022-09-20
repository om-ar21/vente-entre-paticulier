package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MessagerieDAO {

public void save(Messagerie obj) {
	try {
	 
		PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO messagerie (id_em,id_rec,id_annonce,message,date_message,contact) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1,obj.getId_em());
		preparedStatement.setInt(2,obj.getId_rec());
		preparedStatement.setInt(3,obj.getId_annonce());
		preparedStatement.setString(4,obj.getMessage());
		preparedStatement.setTimestamp(5,obj.getDate_message());
		preparedStatement.setInt(6,obj.getContact());
		
        preparedStatement.executeUpdate();
        
        System.out.println("save ok");
    	
	
	}

	 catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
public void update(Messagerie obj) {
	try {

	PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE messagerie set etat=? WHERE id=?");

	
	preparedStatement.setBoolean(1,obj.isEtat());
	preparedStatement.setInt(2,obj.getId());
	preparedStatement.executeUpdate();
	System.out.println("update  ok" +obj);
	


	}catch (Exception ex) {
   	ex.printStackTrace();
   	System.out.println("SAVED NO");
   }


}
public ArrayList<Messagerie> getAllByuserid(int id_user) {
	ArrayList<Messagerie> list = new ArrayList<Messagerie>();
	try {
		
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM messagerie where (id_rec=? or id_em=?) group by contact, id_annonce ORDER by date_message DESC;");
			preparedStatement.setInt(1,id_user);
			preparedStatement.setInt(2,id_user);
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Messagerie u = new Messagerie();
				u.setId(resultat.getInt( "id" ));
				u.setId_rec(resultat.getInt( "id_rec" ));
				u.setId_em(resultat.getInt( "id_em" ));
				u.setId_annonce(resultat.getInt( "id_annonce" ));
				u.setMessage(resultat.getString( "message" ));
				u.setDate_message(resultat.getTimestamp( "date_message" ));
				u.setEtat(resultat.getBoolean( "etat" ));
				u.setContact(resultat.getInt( "contact" ));
				list.add(u);
			}
			
			
			return list;
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	return null;
    }
}
public ArrayList<Messagerie> getAllById(int id_user) {
	ArrayList<Messagerie> list = new ArrayList<Messagerie>();
	try {
		
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM messagerie where id_rec=? or id_em=?;");
			preparedStatement.setInt(1,id_user);
			preparedStatement.setInt(2,id_user);
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Messagerie u = new Messagerie();
				u.setId(resultat.getInt( "id" ));
				u.setId_rec(resultat.getInt( "id_rec" ));
				u.setId_em(resultat.getInt( "id_em" ));
				u.setId_annonce(resultat.getInt( "id_annonce" ));
				u.setMessage(resultat.getString( "message" ));
				u.setDate_message(resultat.getTimestamp( "date_message" ));
				u.setEtat(resultat.getBoolean( "etat" ));
				u.setContact(resultat.getInt( "contact" ));
				list.add(u);
			}
			
			
			return list;
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	return null;
    }
}

public int verifEtatConv(int id_rec , int id_em,int id_contact,int id_annonce) {
	///
	try {
		
		PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT count(*) as msg FROM messagerie WHERE id_rec=? and id_em=? and contact=? and id_annonce=? and etat=0");
		preparedStatement.setInt(1,id_rec);
		preparedStatement.setInt(2,id_em);
		preparedStatement.setInt(3,id_contact);
		preparedStatement.setInt(4,id_annonce);
		
		
		
		ResultSet resultat=preparedStatement.executeQuery();
		resultat.next();

		int total = resultat.getInt( "msg" );
		return total;
	
} catch (Exception ex) {
	ex.printStackTrace();
	return 0;
}
	
}

public ArrayList<Messagerie> getAllByAnnonce(int id_rec , int id_em,int id_annonce) {
	ArrayList<Messagerie> list = new ArrayList<Messagerie>();
	try {
		
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM messagerie where ((id_rec=? AND id_em=?) OR (id_em=? AND id_rec=?)) AND id_annonce=? ORDER BY date_message;");
			preparedStatement.setInt(1,id_rec);
			preparedStatement.setInt(2,id_em);
			preparedStatement.setInt(3,id_rec);
			preparedStatement.setInt(4,id_em);
			preparedStatement.setInt(5,id_annonce);
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Messagerie u = new Messagerie();
				u.setId(resultat.getInt( "id" ));
				u.setId_rec(resultat.getInt( "id_rec" ));
				u.setId_em(resultat.getInt( "id_em" ));
				u.setId_annonce(resultat.getInt( "id_annonce" ));
				u.setMessage(resultat.getString( "message" ));
				u.setDate_message(resultat.getTimestamp( "date_message" ));
				u.setEtat(resultat.getBoolean( "etat" ));
				u.setContact(resultat.getInt( "contact" ));
				list.add(u);
			}
			
			
			return list;
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	return null;
    }
}
}
