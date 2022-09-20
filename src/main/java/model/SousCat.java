package model;

public class SousCat {
private int id;
private String titre;
private int id_categorie;
private boolean del;






public boolean isDel() {
	return del;
}



public void setDel(boolean del) {
	this.del = del;
}



//public Categorie getCategorie() {
//	return categorie;
//}



//public void setCategorie(Categorie categorie) {
//	this.categorie = categorie;
//}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getTitre() {
	return titre;
}



public void setTitre(String titre) {
	this.titre = titre;
}



public int getId_categorie() {
	return id_categorie;
}



public void setId_categorie(int id_categorie) {
	this.id_categorie = id_categorie;
}


public SousCat(String titre, int id_categorie) {
	super();
	this.titre = titre;
	this.id_categorie = id_categorie;
}
public SousCat() {

}
public SousCat(int id, String titre, int id_categorie) {
	super();
	this.id = id;
	this.titre = titre;
	this.id_categorie = id_categorie;
}



//public SousCat(String titre, int id_cat, Categorie categorie) {
//	super();
//	this.titre = titre;
//	this.id_cat = id_cat;
//	this.categorie = categorie;
//}



//public SousCat(int id, String titre, int id_cat, Categorie categorie) {
//	super();
//	this.id = id;
//	this.titre = titre;
//	this.id_cat = id_cat;
//	this.categorie = categorie;
//}



@Override
public String toString() {
	return "Souscategorie [id=" + id + ", titre=" + titre + ", id_categorie=" + id_categorie +  "]";
}
//", categorie=" + categorie +





}
