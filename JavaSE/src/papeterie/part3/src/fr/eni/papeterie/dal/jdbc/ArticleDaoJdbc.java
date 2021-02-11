package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part2.src.fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDaoJdbc {

    void insert(Article article) throws ArticleDalException;
    List<Article> selectAll() throws ArticleDalException;
    Article selectById(int id) throws ArticleDalException;
    void update(Article article) throws ArticleDalException;
    void delete(int idArticle) throws ArticleDalException;

}
