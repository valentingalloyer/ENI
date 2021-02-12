package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

public class DaoFact {


    public static ArticleDao getArticleDAO() {
        return new ArticleDaoImpl();
    }

    public static PanierDao getPanierDAO() {
        return new PanierDaoImpl();
    }

    public static LigneDao getLigneDAO() {
        return new LigneDaoImpl();
    }

}
