package voyageScolaire.bo;

public class Lyceen extends Passager {

    private String classe;

    public Lyceen(String nom, String classe) {
        super(nom);
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Lyceen : " + super.getNom() +
                ", classe=" + classe;
    }
}
