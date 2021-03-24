package ihm;

import java.util.Calendar;

import bo.Biere;
import bo.Brasserie;
import dal.DALException;

public class BiereModel {
	
	private String nom;
	private int idBrasserie;
	private String type;
	private Calendar dateInsert;
	private int note;
	
	private Biere biere;
	
	private String message;
	
	public BiereModel() {
		super();
		this.nom = "";
		this.idBrasserie = -1;
		this.type = "";
		this.dateInsert = Calendar.getInstance();
		this.note = 0;
	}

	@Override
	public String toString() {
		return "BiereModel [nom=" + nom + ", idBrasserie=" + idBrasserie + ", type=" + type + ", dateInsert="
				+ dateInsert + ", note=" + note + ", biere=" + biere + ", message=" + message + "]";
	}

	public BiereModel(Biere b) {
		super();
		this.biere = b;
		this.nom = b.getNom();
		this.idBrasserie = b.getBrasserie().getIdBrasserie();
		this.type = b.getType();
		this.dateInsert = b.getDateInsert();
		this.note = b.getNote();
	}
	
	public void setCurrentBiere(Biere b) {
		this.biere = b;
		this.nom = b.getNom();
		this.idBrasserie = b.getBrasserie().getIdBrasserie();
		this.type = b.getType();
		this.dateInsert = b.getDateInsert();
		this.note = b.getNote();
	}

	public Biere getCurrentBiere() throws DALException {
		return new Biere(getNom(), getIdBrasserie(), getType(), getDateInsert());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdBrasserie() {
		return idBrasserie;
	}

	public void setIdBrasserie(int idBrasserie) {
		this.idBrasserie = idBrasserie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Calendar getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Calendar dateInsert) {
		this.dateInsert = dateInsert;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
