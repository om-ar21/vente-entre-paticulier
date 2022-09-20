package model;

public class Contact {
	private int id; 
	private int id_user;
	private String email;
	private String sujet;
	private String message;
	private boolean etat;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Contact(int id, int id_user, String email, String sujet, String message, boolean etat) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.email = email;
		this.sujet = sujet;
		this.message = message;
		this.etat = etat;
	}
	public Contact(int id_user, String email, String sujet, String message, boolean etat) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.sujet = sujet;
		this.message = message;
		this.etat = etat;
	}
	public Contact(int id_user, String email, String sujet, String message) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.sujet = sujet;
		this.message = message;
		
	}
	public Contact() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", id_user=" + id_user + ", email=" + email + ", sujet=" + sujet + ", message="
				+ message + ", etat=" + etat + "]";
	}
	
	
	

}
