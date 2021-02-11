package voyageScolaire.dal.jdbc;

public class CarDaoFact {


    public static CarDao getArticleDAO() {
        return new CarDaoImpl();
    }
}
