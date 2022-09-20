package model;

import java.sql.Date;

public class Annonce {
private int id;
private String titre;
private int id_souscat;
private int id_user;
private String description;
private Date date_pub;
private String image;
private String ville;
private boolean val;
private boolean del;
private double prix;
private  SousCat souscat;



public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
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
public int getId_souscat() {
	return id_souscat;
}
public void setId_souscat(int id_souscat) {
	this.id_souscat = id_souscat;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDate_pub() {
	return date_pub;
}
public void setDate_pub(Date date_pub) {
	this.date_pub = date_pub;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public boolean isVal() {
	return val;
}
public void setVal(boolean val) {
	this.val = val;
}
public boolean isDel() {
	return del;
}
public void setDel(boolean del) {
	this.del = del;
}
public SousCat getSouscat() {
	return souscat;
}
public void setSouscat(SousCat souscat) {
	this.souscat = souscat;
}


public Annonce(String titre, int id_souscat, int id_user, String description, Date date_pub, String image,
		String ville, double prix) {
	super();

	this.titre = titre;
	this.id_souscat = id_souscat;
	this.id_user = id_user;
	this.description = description;
	this.date_pub = date_pub;
	this.image = image;
	this.ville = ville;
	this.prix = prix;
}
public Annonce(String titre, int id_souscat, int id_user, String description, Date date_pub, String image, String ville,
		boolean val, boolean del, double prix) {
	super();
	this.titre = titre;
	this.id_souscat = id_souscat;
	this.id_user = id_user;
	this.description = description;
	this.date_pub = date_pub;
	this.image = image;
	this.ville = ville;
	this.val = val;
	this.del = del;
	this.prix = prix;
}
public Annonce(int id, String titre, int id_souscat, int id_user, String description, Date date_pub, String image,
		String ville, boolean val, boolean del, double prix) {
	super();
	this.id = id;
	this.titre = titre;
	this.id_souscat = id_souscat;
	this.id_user = id_user;
	this.description = description;
	this.date_pub = date_pub;
	this.image = image;
	this.ville = ville;
	this.val = val;
	this.del = del;
	this.prix = prix;
}


public Annonce(int id, String titre, int id_souscat, int id_user, String description, Date date_pub, String image,
		String ville, boolean val, boolean del, double prix, SousCat souscat) {
	super();
	this.id = id;
	this.titre = titre;
	this.id_souscat = id_souscat;
	this.id_user = id_user;
	this.description = description;
	this.date_pub = date_pub;
	this.image = image;
	this.ville = ville;
	this.val = val;
	this.del = del;
	this.prix = prix;
	this.souscat = souscat;
}
public Annonce() {
	super();
}
@Override
public String toString() {
	return "Annonce [id=" + id + ", titre=" + titre + ", id_souscat=" + id_souscat + ", id_user=" + id_user
			+ ", description=" + description + ", date_pub=" + date_pub + ", image=" + image + ", ville=" + ville
			+ ", val=" + val + ", del=" + del + ", prix=" + prix + "]";
}
public SousCat getCat() {
    SousCatDAO ud = new SousCatDAO();
    SousCat u = ud.getById(this.id_souscat);
    return u;
}


public Favoris getFavoris(int id) {
	FavorisDAO fav = new FavorisDAO();
	Favoris f = fav.getByIdAnnonce(id);
	return f;
	
}
public User getUser() {
	UserDAO fav = new UserDAO();
	User f = fav.getById(this.id_user);
	return f;
	
}
public int getVisite(int idan) {
	VisiteDAO vdao = new VisiteDAO();
	int v = vdao.getVisite(idan);
	return v;
}

}
