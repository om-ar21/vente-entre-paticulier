package model;
import java.sql.Timestamp;
public class Messagerie {
	private int id;
	private int id_rec;
	private int id_em;
	private int id_annonce;
	private String message;
	private boolean etat;
	private Timestamp  date_message;
	private int contact;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_rec() {
		return id_rec;
	}


	public void setId_rec(int id_rec) {
		this.id_rec = id_rec;
	}


	public int getId_em() {
		return id_em;
	}


	public void setId_em(int id_em) {
		this.id_em = id_em;
	}


	public int getId_annonce() {
		return id_annonce;
	}


	public void setId_annonce(int id_annonce) {
		this.id_annonce = id_annonce;
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


	public Timestamp getDate_message() {
		return date_message;
	}


	public void setDate_message(Timestamp date_message) {
		this.date_message = date_message;
	}


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}

	

	public Messagerie() {
		super();
	}


	public Messagerie(int id_rec, int id_em, int id_annonce, String message, Timestamp date_message, int contact) {
		super();
		this.id_rec = id_rec;
		this.id_em = id_em;
		this.id_annonce = id_annonce;
		this.message = message;
		this.date_message = date_message;
		this.contact = contact;
	}


	public Messagerie( int id_em,int id_rec, int id_annonce, String message, boolean etat, Timestamp date_message,
			int contact) {
		super();
		this.id_rec = id_rec;
		this.id_em = id_em;
		this.id_annonce = id_annonce;
		this.message = message;
		this.etat = etat;
		this.date_message = date_message;
		this.contact = contact;
	}


	public Messagerie(int id, int id_rec, int id_em, int id_annonce, String message, boolean etat,
			Timestamp date_message, int contact) {
		super();
		this.id = id;
		this.id_rec = id_rec;
		this.id_em = id_em;
		this.id_annonce = id_annonce;
		this.message = message;
		this.etat = etat;
		this.date_message = date_message;
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Messagerie [id=" + id + ", id_rec=" + id_rec + ", id_em=" + id_em + ", id_annonce=" + id_annonce
				+ ", message=" + message + ", etat=" + etat + ", date_message=" + date_message + ", contact=" + contact
				+ "]";
	}


	public Annonce getAnnonce() {
		AnnonceDAO an = new AnnonceDAO();
		Annonce p = an.getById(this.id_annonce);
		return p;
	}
	public User getUser(int id) {
		UserDAO an = new UserDAO();
		User p = an.getById(id);
		return p;
	}
	
}
