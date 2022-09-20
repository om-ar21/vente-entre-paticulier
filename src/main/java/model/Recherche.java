package model;

import java.sql.Date;

public class Recherche {
private int id;
private int id_user;
private String mot;
private Date date_rech;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getMot() {
	return mot;
}
public void setMot(String mot) {
	this.mot = mot;
}
public Date getDate_rech() {
	return date_rech;
}
public void setDate_rech(Date date_rech) {
	this.date_rech = date_rech;
}
public Recherche(int id, int id_user, String mot, Date date_rech) {
	super();
	this.id = id;
	this.id_user = id_user;
	this.mot = mot;
	this.date_rech = date_rech;
}
public Recherche(int id_user, String mot, Date date_rech) {
	super();
	this.id_user = id_user;
	this.mot = mot;
	this.date_rech = date_rech;
}
public Recherche() {
	super();
}
@Override
public String toString() {
	return "Recherche [id=" + id + ", id_user=" + id_user + ", mot=" + mot + ", date_rech=" + date_rech + "]";
}



}
