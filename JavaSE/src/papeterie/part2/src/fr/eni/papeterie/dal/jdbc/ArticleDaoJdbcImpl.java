package papeterie.part2.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part2.src.fr.eni.papeterie.bo.Article;
import papeterie.part2.src.fr.eni.papeterie.bo.Ramette;
import papeterie.part2.src.fr.eni.papeterie.bo.Stylo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJdbcImpl implements ArticleDaoJdbc {

    private String INSERT = "INSERT INTO articles (reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type) VALUES (?,?,?,?,?,?,?,?)";
    private String SELECT = "SELECT * FROM articles";
    private String SelectWhere = "SELECT * FROM articles WHERE idArticle=?";
    private String UPDATE = "UPDATE articles SET " +
            "reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=? " +
            "WHERE idArticle=?";
    private String DELETE = "DELETE FROM articles WHERE idArticle=?";


    public void insert(Article article) throws ArticleDalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, article.getReference());
            stmt.setString(2, article.getMarque());
            stmt.setString(3, article.getDesignation());
            stmt.setFloat(4, article.getPrixUnitaire());
            stmt.setInt(5, article.getQteStock());
            if (article instanceof Ramette) {
                stmt.setInt(6, ((Ramette)article).getGrammage());
                stmt.setString(7, null);
                stmt.setString(8, "Ramette");
            }
            else {
                stmt.setString(6, null);
                stmt.setString(7, ((Stylo) article).getCouleur());
                stmt.setString(8, "Stylo");
            }

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            article.setIdArticle(generatedKey);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ArticleDalException("problème dans l'insertion d'un article");
        }
    }

    public List<Article> selectAll() throws ArticleDalException {
        List<Article> result = new ArrayList<Article>();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECT);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Article article;
                if (rs.getString("type").equals("Ramette".replaceAll("\\s", "")))
                    article = new Ramette();
                else
                    article = new Stylo();

                article.setIdArticle(rs.getInt("idArticle"));
                article.setReference(rs.getString("reference"));
                article.setMarque(rs.getString("marque"));
                article.setDesignation(rs.getString("designation"));
                article.setPrixUnitaire(rs.getInt("prixUnitaire"));
                article.setQteStock(rs.getInt("qteStock"));
                if (article instanceof Ramette)
                    ((Ramette) article).setGrammage(rs.getInt("grammage"));
                else
                    ((Stylo)article).setCouleur(rs.getString("couleur"));
                result.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ArticleDalException("problème dans la selection des Articles");
        }
        return result;
    }

    public Article selectById(int id) throws ArticleDalException {
        // TODO Auto-generated method stub
        Article art = new Ramette();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SelectWhere);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                // TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
                // gitignore

                String type = rs.getString("type").replaceAll("\\s", "");
                if(type.equals("Ramette")) {
                    Ramette ramette = new Ramette();
                    ramette.setDesignation(rs.getString("designation"));
                    ramette.setGrammage(rs.getInt("grammage"));
                    ramette.setIdArticle(rs.getInt("idArticle"));
                    ramette.setMarque(rs.getString("marque"));
                    ramette.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    ramette.setQteStock(rs.getInt("qteStock"));
                    ramette.setReference(rs.getString("reference"));

                    art = ramette;

                }
                if( type.equals("Stylo")) {
                    Stylo stylo = new Stylo();
                    stylo.setDesignation(rs.getString("designation"));
                    stylo.setCouleur(rs.getString("couleur"));
                    stylo.setIdArticle(rs.getInt("idArticle"));
                    stylo.setMarque(rs.getString("marque"));
                    stylo.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    stylo.setQteStock(rs.getInt("qteStock"));
                    stylo.setReference(rs.getString("reference"));

                    art = stylo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ArticleDalException("Problème dans la sélection d'article");
        }
        return art;
    }

    public void update(Article article) throws ArticleDalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, article.getReference());
            stmt.setString(2, article.getMarque());
            stmt.setString(3, article.getDesignation());
            stmt.setFloat(4, article.getPrixUnitaire());
            stmt.setInt(5, article.getQteStock());
            if (article instanceof Ramette) {
                stmt.setInt(6, ((Ramette)article).getGrammage());
                stmt.setString(7, null);
                stmt.setString(8, "Ramette");
            }
            else {
                stmt.setString(6, null);
                stmt.setString(7, ((Stylo) article).getCouleur());
                stmt.setString(8, "Stylo");
            }

            stmt.setInt(9, article.getIdArticle());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ArticleDalException("Problème dans la modification");
        }
    }

    public void delete(int idArticle) throws ArticleDalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, idArticle);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ArticleDalException("Problème lors de la suppression");
        }
    }

}
