package tp345.fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Patient {
    private String nom, prenom, numeroDeTelephone;
    private char sexe;
    private long numeroSecuriteSociale;
    private LocalDate dateDeNaissance;
    private String commentaire;
    private Adresse adresse;

    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecuriteSociale, LocalDate dateDeNaissance, String commentaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.sexe = sexe;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.dateDeNaissance = dateDeNaissance;
        if (commentaire != null)
            this.commentaire = commentaire;
        else
            this.commentaire = "[Pas de commentaires]";
    }

    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecuriteSociale, LocalDate dateDeNaissance, String commentaire, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.sexe = sexe;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.dateDeNaissance = dateDeNaissance;
        if (commentaire != null)
            this.commentaire = commentaire;
        else
            this.commentaire = "[Pas de commentaires]";
        this.adresse = adresse;
    }

    public void afficher() {
        System.out.println(nom + " " + prenom);
        System.out.println("Numéro de téléphone : " + numeroDeTelephone);
        System.out.println("Sexe : " + sexe);
        System.out.println("Numéro de sécurité sociale : " + numeroSecuriteSociale);
        System.out.println("Date de naissance : " + dateDeNaissance.format(DateTimeFormatter.ofPattern("dd MMMM yyyy",Locale.FRENCH)));
        System.out.println("Commentaires : " + commentaire);
        if (this.adresse != null) this.adresse.afficher();
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

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public long getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(long numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
