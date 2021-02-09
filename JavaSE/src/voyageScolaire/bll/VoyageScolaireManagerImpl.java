package voyageScolaire.bll;

import voyageScolaire.bo.Car;
import voyageScolaire.bo.Lyceen;
import voyageScolaire.bo.Passager;

import java.util.ArrayList;
import java.util.List;

public class VoyageScolaireManagerImpl implements VoyageScolaireManager {

    public static List<Car> listeCars = new ArrayList<>();

    @Override
    public Car saisirCar(Integer nombreDePlaces) {
        Car c = new Car(nombreDePlaces);
        listeCars.add(c);
        return c;
    }

    @Override
    public Car addPassager(Car car, Passager passager) throws Exception {
        List<Passager> listePassagers = car.getListeDesPassagers();
        // Règle de gestion : Il ne peut pas y avoir plus de passagers que la capacité maximale du bus
        if (listePassagers.size() >= car.getNombrePlacesMax())
            throw new Exception("Le car est plein, plus personne ne peut y rentrer !");

        if (passager instanceof Lyceen) {
            //Règle de gestion : Pas plus de 3 classes différentes par bus
            if (!car.getListeDifferentesClasses().contains(((Lyceen) passager).getClasse())) {
                if (car.getListeDifferentesClasses().size() >= 3)
                    throw new Exception("Il ne peut pas y avoir d'élèves de plus de trois classes différentes !");
                else {
                    List<String> nouvelleListeClasses = new ArrayList<>();
                    nouvelleListeClasses = car.getListeDifferentesClasses();
                    nouvelleListeClasses.add(((Lyceen) passager).getClasse());
                    car.setListeDifferentesClasses(nouvelleListeClasses);
                }
            }
            // Règle de gestion : un lycéen a forcément un nom de classe
            if (((Lyceen) passager).getClasse() == null)
                throw new Exception("Le lycéen n'a pas de nom de classe");
        }
        listePassagers.add(passager);
        car.setListeDesPassagers(listePassagers);
        return car;
    }

    @Override
    public Car addPassagers(Car car, List<Passager> listPassagers) throws Exception {
        for (Passager passager:listPassagers) {
            addPassager(car, passager);
        }
        return car;
    }

    @Override
    public void afficherCarsEtPassagers() {
        for (Car car:listeCars) {
            System.out.println("Car " + car.toString());
            for (Passager passager: car.getListeDesPassagers()) {
                System.out.println(passager.toString());
            }
            System.out.println("------------------------------------");
        }
    }

    @Override
    public boolean isLesCarsPeuventPartir() {
        for (Car car:listeCars) {
            // Règle de gestion : au moins 1 prof pour 10 lycéens
            if (((float) car.getNombreDeLyceens()/car.getNombreDeProfesseurs()) < 10)
                return false;
            // Règle de gestion : un car ne part pas à vide
            if (car.getNombreDeProfesseurs() + car.getNombreDeLyceens() == 0)
                return false;

        }
        return true;
    }
}
