package vote3.src.fr.formation.vote.bo;

public class Electeur {
	private String nom;
	private Integer age;
	private String nat;

	public Electeur() {
	}

	public Electeur(String nom, Integer age, String nat) {
		super();
		this.nom = nom;
		this.age = age;
		this.nat = nat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	@Override
	public String toString() {
		return "Electeur [nom=" + nom + ", age=" + age + ", nat=" + nat + "]";
	}

}
