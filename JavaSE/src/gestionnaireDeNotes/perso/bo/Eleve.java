package gestionnaireDeNotes.perso.bo;

public class Eleve {

    private String nom, prenom, classe;
    private float note;

    public Eleve() {
    }

    public Eleve(String nom, String prenom, String classe, float note) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.note = note;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", classe='" + classe + '\'' +
                ", note=" + note +
                '}';
    }
}
