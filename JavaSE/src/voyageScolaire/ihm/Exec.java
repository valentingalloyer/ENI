package voyageScolaire.ihm;

import voyageScolaire.bll.VoyageScolaireManager;
import voyageScolaire.bll.VoyageScolaireManagerFact;
import voyageScolaire.bo.Car;
import voyageScolaire.bo.Lyceen;
import voyageScolaire.bo.Passager;
import voyageScolaire.bo.Professeur;

import java.util.ArrayList;
import java.util.List;

public class Exec {

    public static void main(String[] args) {

        VoyageScolaireManager v = VoyageScolaireManagerFact.getInstance();

        Car car1 = v.saisirCar(25);

        try {
            v.addPassager(car1, new Lyceen("Valentin", "CDA"));
            List<Passager> listePassagers = new ArrayList<>();
            listePassagers.add(new Lyceen("Téo", "CDA"));
            listePassagers.add(new Lyceen("Maxime", "CDA"));
            listePassagers.add(new Professeur("Emmanuel"));
            v.addPassagers(car1, listePassagers);
            v.afficherCarsEtPassagers();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }

}
