package voyageScolaire.bo;

public class Professeur extends Passager {

    public Professeur() {
    }

    public Professeur(String nom) {
        super(nom);
    }

    @Override
    public String toString() {
        return "Professeur : " + super.getNom();
    }
}
