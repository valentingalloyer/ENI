package tp345.fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {

    private String numeroDeTelephone, nom, prenom;
    private static float tarif = 25;
    Adresse adresse;

    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.adresse = adresse;
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
        if (this.adresse != null) this.adresse.afficher();
    }
}
