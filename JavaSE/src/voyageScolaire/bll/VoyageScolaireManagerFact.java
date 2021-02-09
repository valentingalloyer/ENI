package voyageScolaire.bll;

public class VoyageScolaireManagerFact {

    public static VoyageScolaireManager getInstance() {
        return new VoyageScolaireManagerImpl();
    }


}
