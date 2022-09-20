package model;

import java.sql.Date;

public class User {
	private int id;
	private String nom;
	private String prenom;
	private Date date_inscription;
	private String tel;
	private String email;
	private String mdp;
	private boolean del;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public User(int id, String nom, String prenom, Date date_inscription, String tel, String email, String mdp,
			boolean del) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_inscription = date_inscription;
		this.tel = tel;
		this.email = email;
		this.mdp = mdp;
		this.del = del;
	}
	public User(String nom, String prenom, Date date_inscription, String tel, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_inscription = date_inscription;
		this.tel = tel;
		this.email = email;
		this.mdp = mdp;
		
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_inscription=" + date_inscription
				+ ", tel=" + tel + ", email=" + email + ", mdp=" + mdp + ", del=" + del + "]";
	}
	
	
	
	
}
