package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnnonceDAO {
	public void save(Annonce obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE annonce set id_souscat=?,titre=?,description=?,image=?,ville=?,prix=?,val=?,del=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_souscat());
				preparedStatement.setString(2,obj.getTitre());
				preparedStatement.setString(3,obj.getDescription());
				preparedStatement.setString(4,obj.getImage());
				preparedStatement.setString(5,obj.getVille());
				preparedStatement.setDouble(6,obj.getPrix());
				preparedStatement.setBoolean(7,obj.isVal());
				preparedStatement.setBoolean(8,obj.isDel());
				preparedStatement.setInt(9,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO annonce (id_souscat,titre,id_user,description,date_pub,image,ville,prix,val) VALUES(?,?,?,?,?,?,?,?,?)");
				preparedStatement.setInt(1,obj.getId_souscat());
				preparedStatement.setString(2,obj.getTitre());
				preparedStatement.setInt(3,obj.getId_user());
				preparedStatement.setString(4,obj.getDescription());
				preparedStatement.setDate(5,obj.getDate_pub());
				preparedStatement.setString(6,obj.getImage());
				preparedStatement.setString(7,obj.getVille());
				preparedStatement.setDouble(8,obj.getPrix());
				preparedStatement.setBoolean(9,obj.isVal());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	
	
	public Annonce getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE id=? ;");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Annonce u = new Annonce();

			u.setId(resultat.getInt( "id" ));
			u.setId_souscat(resultat.getInt( "id_souscat" ));
			u.setId_user(resultat.getInt( "id_user" ));
			u.setTitre(resultat.getString( "titre" ));
			u.setDescription(resultat.getString( "description" ));
			u.setDate_pub(resultat.getDate( "date_pub" ));
			u.setImage(resultat.getString( "image" ));
			u.setVille(resultat.getString( "ville" ));
			u.setPrix(resultat.getDouble( "prix" ));
			u.setDel(resultat.getBoolean( "del" ));
			u.setVal(resultat.getBoolean( "val" ));
		

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public void hideById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE annonce set del=1 WHERE id=?");
			
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("HIDE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public ArrayList<Annonce> getAll() {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		SousCatDAO ut = new SousCatDAO();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE del=0 AND val=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Annonce o = new Annonce();
				o.setId(resultat.getInt( "id" ));
				o.setId_souscat(resultat.getInt( "id_souscat" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setDescription(resultat.getString( "description" ));
				o.setDate_pub(resultat.getDate( "date_pub" ));
				o.setImage(resultat.getString( "image" ));
				o.setVille(resultat.getString( "ville" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setDel(resultat.getBoolean( "del" ));
    			o.setVal(resultat.getBoolean( "val" ));
    			o.setSouscat(ut.getById(resultat.getInt( "id_souscat" )));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Annonce> getAllByIdSousCat(int idsoucat) {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		SousCatDAO ut = new SousCatDAO();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE id_souscat=? AND del=0 And val=1");
			preparedStatement.setInt(1,idsoucat);
			ResultSet resultat=preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Annonce o = new Annonce();
				o.setId(resultat.getInt( "id" ));
				o.setId_souscat(resultat.getInt( "id_souscat" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setDescription(resultat.getString( "description" ));
				o.setDate_pub(resultat.getDate( "date_pub" ));
				o.setImage(resultat.getString( "image" ));
				o.setVille(resultat.getString( "ville" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setDel(resultat.getBoolean( "del" ));
    			o.setVal(resultat.getBoolean( "val" ));
    			o.setSouscat(ut.getById(resultat.getInt( "id_souscat" )));	
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Annonce> getAllByUser(int iduser) {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		SousCatDAO ut = new SousCatDAO();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE id_user=? AND del=0");
			preparedStatement.setInt(1,iduser);
			ResultSet resultat=preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Annonce o = new Annonce();
				o.setId(resultat.getInt( "id" ));
				o.setId_souscat(resultat.getInt( "id_souscat" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setDescription(resultat.getString( "description" ));
				o.setDate_pub(resultat.getDate( "date_pub" ));
				o.setImage(resultat.getString( "image" ));
				o.setVille(resultat.getString( "ville" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setDel(resultat.getBoolean( "del" ));
    			o.setVal(resultat.getBoolean( "val" ));
    			o.setSouscat(ut.getById(resultat.getInt( "id_souscat" )));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Annonce> getAllByIdUser(int iduser) {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		SousCatDAO ut = new SousCatDAO();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE id_user=? AND del=0 AND val=1");
			preparedStatement.setInt(1,iduser);
			ResultSet resultat=preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Annonce o = new Annonce();
				o.setId(resultat.getInt( "id" ));
				o.setId_souscat(resultat.getInt( "id_souscat" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setDescription(resultat.getString( "description" ));
				o.setDate_pub(resultat.getDate( "date_pub" ));
				o.setImage(resultat.getString( "image" ));
				o.setVille(resultat.getString( "ville" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setDel(resultat.getBoolean( "del" ));
    			o.setVal(resultat.getBoolean( "val" ));
    			o.setSouscat(ut.getById(resultat.getInt( "id_souscat" )));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Annonce> getAllDel(int iduser) {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		SousCatDAO ut = new SousCatDAO();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE id_user=?");
			preparedStatement.setInt(1,iduser);
			ResultSet resultat=preparedStatement.executeQuery();
			
			while(resultat.next()) {
				Annonce o = new Annonce();
				o.setId(resultat.getInt( "id" ));
				o.setId_souscat(resultat.getInt( "id_souscat" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setDescription(resultat.getString( "description" ));
				o.setDate_pub(resultat.getDate( "date_pub" ));
				o.setImage(resultat.getString( "image" ));
				o.setVille(resultat.getString( "ville" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setDel(resultat.getBoolean( "del" ));
    			o.setVal(resultat.getBoolean( "val" ));
    			o.setSouscat(ut.getById(resultat.getInt( "id_souscat" )));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Annonce> getAllByIdCat(int id) {
	    ArrayList<Annonce> list = new ArrayList<Annonce>();
	    try {

	            PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE val=1 and del=0 AND id_souscat  IN (SELECT id from souscat WHERE id_categorie=?)");
	            preparedStatement.setInt(1,id);

	            ResultSet resultat=preparedStatement.executeQuery();

	            while(resultat.next()) {
	            	Annonce u = new Annonce();
	            	u.setId(resultat.getInt( "id" ));
	    			u.setId_souscat(resultat.getInt( "id_souscat" ));
	    			u.setId_user(resultat.getInt( "id_user" ));
	    			u.setTitre(resultat.getString( "titre" ));
	    			u.setDescription(resultat.getString( "description" ));
	    			u.setDate_pub(resultat.getDate( "date_pub" ));
	    			u.setImage(resultat.getString( "image" ));
	    			u.setVille(resultat.getString( "ville" ));
	    			u.setPrix(resultat.getDouble( "prix" ));
	    			u.setDel(resultat.getBoolean( "del" ));
	    			u.setVal(resultat.getBoolean( "val" ));
	                list.add(u);
	            }


	            return list;

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}
	public int getMax() {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT Max(id) as max FROM annonce ");
				
				
				
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();

				int max = resultat.getInt( "max" );
				return max;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return 0;
        }
	}
	public ArrayList<Annonce> Rechercher(String mot) {
		ArrayList<Annonce> list = new ArrayList<Annonce>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM annonce WHERE val=1 AND (titre like ? or description like ?) AND del=0");
				preparedStatement.setString(1,"%"+mot+"%");
				preparedStatement.setString(2,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Annonce u = new Annonce();
					u.setId(resultat.getInt( "id" ));
					u.setId_souscat(resultat.getInt( "id_souscat" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setTitre(resultat.getString( "titre" ));
					u.setDescription(resultat.getString( "description" ));
					u.setDate_pub(resultat.getDate( "date_pub" ));
					u.setImage(resultat.getString( "image" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPrix(resultat.getDouble( "prix" ));
					u.setVal(resultat.getBoolean( "val" ));
					u.setDel(resultat.getBoolean( "del" ));
					
					list.add(u);
				}
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	
	    }
		return list;
	}

}
