package voyageScolaire.dal.jdbc;

import papeterie.part2.src.fr.eni.papeterie.bo.Article;

import java.util.List;

public interface CarDao {

    void insert(Article article) throws VoyageDalException;
    List<Article> selectAll() throws VoyageDalException;
    Article selectById(int id) throws VoyageDalException;
    void update(Article article) throws VoyageDalException;
    void delete(int idArticle) throws VoyageDalException;

}
