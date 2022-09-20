package model;

public class Image {
private int id;
private int id_annonce;
private String lien;
private boolean del;
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
public String getLien() {
	return lien;
}
public void setLien(String lien) {
	this.lien = lien;
}
public boolean isDel() {
	return del;
}
public void setDel(boolean del) {
	this.del = del;
}
public Image(int id, int id_annonce, String lien, boolean del) {
	super();
	this.id = id;
	this.id_annonce = id_annonce;
	this.lien = lien;
	this.del = del;
}
public Image(int id_annonce, String lien, boolean del) {
	super();
	this.id_annonce = id_annonce;
	this.lien = lien;
	this.del = del;
}
public Image(int id_annonce, String lien) {
	super();
	this.id_annonce = id_annonce;
	this.lien = lien;
}
public Image(int id, int id_annonce, String lien) {
	super();
	this.id = id;
	this.id_annonce = id_annonce;
	this.lien = lien;
}
public Image() {
	super();
}
@Override
public String toString() {
	return "Image [id=" + id + ", id_annonce=" + id_annonce + ", lien=" + lien + ", del=" + del + "]";
}



}
