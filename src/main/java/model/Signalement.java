package model;

public class Signalement {
private int id;
private int id_annonce;
private int id_user;
private String  sujet;
private String message;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_annonce() {
	return id_annonce;
}
public void setId_annonce(int id_annonce) {
	this.id_annonce = id_annonce;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getSujet() {
	return sujet;
}
public void setSujet(String sujet) {
	this.sujet = sujet;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Signalement(int id, int id_annonce, int id_user, String sujet, String message) {
	super();
	this.id = id;
	this.id_annonce = id_annonce;
	this.id_user = id_user;
	this.sujet = sujet;
	this.message = message;
}
public Signalement(int id_user, int id_annonce,  String sujet, String message) {
	super();
	this.id_annonce = id_annonce;
	this.id_user = id_user;
	this.sujet = sujet;
	this.message = message;
}
public Signalement() {
	super();
}
@Override
public String toString() {
	return "Signalement [id=" + id + ", id_annonce=" + id_annonce + ", id_user=" + id_user + ", sujet=" + sujet
			+ ", message=" + message + "]";
}



}
