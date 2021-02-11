package papeterie.part2.src.fr.eni.papeterie.dal.jdbc;

public class ArticleDaoFact {


    public static ArticleDaoJdbc getArticleDAO() {
        return new ArticleDaoJdbcImpl();
    }
}
