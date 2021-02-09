package voyageScolaire.bo;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Integer nombrePlacesMax, nombreDeProfesseurs, nombreDeLyceens;
    private List<Passager> listeDesPassagers;
    private List<String> listeDifferentesClasses;

    public Car() {
        this.nombreDeLyceens = 0;
        this.nombreDeProfesseurs = 0;
        this.listeDifferentesClasses = new ArrayList<>();
        this.listeDesPassagers = new ArrayList<>();
    }

    public Car(Integer nombrePlacesMax) {
        super();
        this.nombrePlacesMax = nombrePlacesMax;
    }

    public Integer getNombrePlacesMax() {
        return nombrePlacesMax;
    }

    public void setNombrePlacesMax(Integer nombrePlacesMax) {
        this.nombrePlacesMax = nombrePlacesMax;
    }

    public List<Passager> getListeDesPassagers() {
        return listeDesPassagers;
    }

    public void setListeDesPassagers(List<Passager> listeDesPassagers) {
        this.listeDesPassagers = listeDesPassagers;
    }

    public Integer getNombreDeProfesseurs() {
        return nombreDeProfesseurs;
    }

    public void setNombreDeProfesseurs(Integer nombreDeProfesseurs) {
        this.nombreDeProfesseurs = nombreDeProfesseurs;
    }

    public Integer getNombreDeLyceens() {
        return nombreDeLyceens;
    }

    public void setNombreDeLyceens(Integer nombreDeLyceens) {
        this.nombreDeLyceens = nombreDeLyceens;
    }

    public List<String> getListeDifferentesClasses() {
        return listeDifferentesClasses;
    }

    public void setListeDifferentesClasses(List<String> listeDifferentesClasses) {
        this.listeDifferentesClasses = listeDifferentesClasses;
    }

    @Override
    public String toString() {
        return "Car : " +
                "nombrePlacesMax=" + nombrePlacesMax +
                ", nombreDeProfesseurs=" + nombreDeProfesseurs +
                ", nombreDeLycéens=" + nombreDeLyceens +
                ", listeDesPassagers=" + listeDesPassagers;
    }
}
