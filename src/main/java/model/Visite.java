package model;

import java.sql.Date;

public class Visite {
private int id;
private int id_user;
private int id_annonce;
private Date date_visite;
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
public int getId_annonce() {
	return id_annonce;
}
public void setId_annonce(int id_annonce) {
	this.id_annonce = id_annonce;
}
public Date getDate_visite() {
	return date_visite;
}
public void setDate_visite(Date date_visite) {
	this.date_visite = date_visite;
}
public Visite(int id, int id_user, int id_annonce, Date date_visite) {
	super();
	this.id = id;
	this.id_user = id_user;
	this.id_annonce = id_annonce;
	this.date_visite = date_visite;
}
public Visite(int id_user, int id_annonce, Date date_visite) {
	super();
	this.id_user = id_user;
	this.id_annonce = id_annonce;
	this.date_visite = date_visite;
}
public Visite() {
	super();
}
@Override
public String toString() {
	return "Visite [id=" + id + ", id_user=" + id_user + ", id_annonce=" + id_annonce + ", date_visite=" + date_visite
			+ "]";
}



}
