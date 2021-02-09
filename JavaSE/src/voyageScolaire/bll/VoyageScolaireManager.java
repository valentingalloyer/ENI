package voyageScolaire.bll;

import voyageScolaire.bo.Car;
import voyageScolaire.bo.Passager;

import java.util.List;

public interface VoyageScolaireManager {

    Car saisirCar(Integer nombreDePlaces);

    Car addPassager(Car car, Passager passager) throws Exception;

    Car addPassagers(Car car, List<Passager> listPassagers) throws Exception;

    void afficherCarsEtPassagers();

    boolean isLesCarsPeuventPartir();


}
