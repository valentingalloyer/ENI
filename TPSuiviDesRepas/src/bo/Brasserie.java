package bo;

public class Brasserie {
	
	private int idBrasserie;
	private String codePostal;
	private String region;
	private String adresse;
	private String nom;
	
	
	
	public Brasserie(int idBrasserie, String codePostal, String region, String adresse, String nom) {
		super();
		this.idBrasserie = idBrasserie;
		this.codePostal = codePostal;
		this.region = region;
		this.adresse = adresse;
		this.nom = nom;
	}
	
	public Brasserie( String codePostal, String region, String adresse, String nom) {
		super();

		this.codePostal = codePostal;
		this.region = region;
		this.adresse = adresse;
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Brasserie [idBrasserie=" + idBrasserie + ", codePostal=" + codePostal + ", region=" + region
				+ ", adresse=" + adresse + ", nom=" + nom + "]";
	}

	public int getIdBrasserie() {
		return idBrasserie;
	}
	public void setIdBrasserie(int idBrasserie) {
		this.idBrasserie = idBrasserie;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
