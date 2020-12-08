package tp345.fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {

    private String numeroDeTelephone, nom, prenom;
    private static float tarif = 25;

    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getNom() {
        return nom;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public static float getTarif() {
        return tarif;
    }

    public static void setTarif(float tarif) {
        MedecinGeneraliste.tarif = tarif;
    }

    public void afficher() {
        System.out.println(nom + " " + prenom);
        System.out.println("Téléphone : " + numeroDeTelephone);
        System.out.println("Tarif : " + tarif + "€");
    }
}
