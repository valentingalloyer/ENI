package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part3.src.fr.eni.papeterie.bo.Ligne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LigneDaoImpl implements LigneDao {

    private String INSERT = "INSERT INTO ligne (qte, idPanier, idArticle) VALUES (?,?,?)";
    private String SELECT = "SELECT * FROM ligne";
    private String SELECTBYID = "SELECT * FROM ligne WHERE id=?";
    private String UPDATE = "UPDATE ligne SET qte=?, idPanier=?, idArticle=? WHERE idArticle=?";
    private String DELETE = "DELETE FROM ligne WHERE id=?";


    public void insert(Ligne ligne) throws DalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, ligne.getQte());
//            stmt.setInt(2, ligne.getPanier().getId());
            stmt.setInt(3, ligne.getArticle().getIdArticle());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            ligne.setId(generatedKey);

        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("problème dans l'insertion d'une ligne");
        }
    }

    public List<Ligne> selectAll() throws DalException {
        List<Ligne> result = new ArrayList<Ligne>();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ligne ligne = new Ligne();

                ligne.setId(rs.getInt("id"));
                ligne.setQte(rs.getInt("qte"));
                ligne.setArticle(rs.getString("idArticle"));
                ligne.setPanier(rs.getString("idPanier"));

                result.add(ligne);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("problème dans la selection des lignes");
        }
        return result;
    }

    public Ligne selectById(int id) throws DalException {
        Ligne result = new Ligne();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECTBYID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // gitignore

                Ligne ligne = new Ligne();
                ligne.setId(rs.getInt("id"));
                ligne.setQte(rs.getInt("qte"));
//                    ligne.setPanier(rs.getInt("idArticle"));
//                    ligne.setArticle(rs.getString("marque"));


                result = ligne;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("Problème dans la sélection d'une ligne");
        }
        return result;
    }

    public void update(Ligne ligne) throws DalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setInt(1, ligne.getQte());
            stmt.setInt(2, ligne.getPanier());
            stmt.setInt(3, ligne.getArticle().getIdArticle());

            stmt.setInt(4, ligne.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("Problème dans la modification");
        }
    }

    public void delete(int id) throws DalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DalException("Problème lors de la suppression");
        }
    }

}
