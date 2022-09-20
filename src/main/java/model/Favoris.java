package model;

public class Favoris {
	private int id;
	private int id_annonce;
	private int id_user;
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
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public Favoris(int id, int id_annonce, int id_user, boolean del) {
		super();
		this.id = id;
		this.id_annonce = id_annonce;
		this.id_user = id_user;
		this.del = del;
	}
	public Favoris(int id_annonce, int id_user, boolean del) {
		super();
		this.id_annonce = id_annonce;
		this.id_user = id_user;
		this.del = del;
	}
	public Favoris() {
		super();
	}
	@Override
	public String toString() {
		return "Favoris [id=" + id + ", id_annonce=" + id_annonce + ", id_user=" + id_user + ", del=" + del + "]";
	}
	
	public Annonce getAnnonce(int id_annonce) {
		AnnonceDAO an = new AnnonceDAO();
		Annonce p = an.getById(id_annonce);
		return p;
	}

}
