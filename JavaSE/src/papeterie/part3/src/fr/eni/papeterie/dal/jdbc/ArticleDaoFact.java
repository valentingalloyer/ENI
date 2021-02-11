package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

public class ArticleDaoFact {


    public static ArticleDaoJdbc getArticleDAO() {
        return new ArticleDaoJdbcImpl();
    }
}
