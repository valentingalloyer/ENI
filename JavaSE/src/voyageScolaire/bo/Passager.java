package voyageScolaire.bo;

public abstract class Passager {

    private String nom;

    public Passager() {
    }

    public Passager(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Passager : " + nom;
    }
}
