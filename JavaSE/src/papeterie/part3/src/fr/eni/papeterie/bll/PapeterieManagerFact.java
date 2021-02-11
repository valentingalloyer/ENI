package papeterie.part3.src.fr.eni.papeterie.bll;



public class PapeterieManagerFact {
    public static PapeterieManager getInstance() {
        return new PapeterieManagerImpl();
    }

}
