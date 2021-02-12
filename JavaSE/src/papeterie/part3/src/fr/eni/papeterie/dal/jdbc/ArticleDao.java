package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part3.src.fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDao {

    void insert(Article article) throws DalException;
    List<Article> selectAll() throws DalException;
    Article selectById(int id) throws DalException;
    void update(Article article) throws DalException;
    void delete(int idArticle) throws DalException;

}
