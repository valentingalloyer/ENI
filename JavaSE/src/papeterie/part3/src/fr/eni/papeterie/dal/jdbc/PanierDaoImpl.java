package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part3.src.fr.eni.papeterie.bo.Article;
import papeterie.part3.src.fr.eni.papeterie.bo.Panier;
import papeterie.part3.src.fr.eni.papeterie.bo.Ramette;
import papeterie.part3.src.fr.eni.papeterie.bo.Stylo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PanierDaoImpl implements PanierDao {

    private final String INSERT = "INSERT INTO panier (montant) VALUES (?)";
    private final String SELECT = "SELECT * FROM panier";
    private final String SELECTBYID = "SELECT * FROM panier WHERE id=?";
    private final String UPDATE = "UPDATE panier SET " +
            "montant=?" +
            "WHERE id=?";
    private final String DELETE = "DELETE FROM panier WHERE id=?";

    @Override
    public void insert(Panier panier) throws DalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setFloat(1, panier.getMontant());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            panier.setId(generatedKey);

        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("problème dans l'insertion d'un panier");
        }
    }

    @Override
    public List<Panier> selectAll() throws DalException {
        List<Panier> result = new ArrayList<Panier>();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECT);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Panier panier = new Panier();
                panier.setMontant(rs.getFloat("montant"));
                panier.setId(rs.getInt("id"));
                result.add(panier);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("problème dans la selection des paniers");
        }
        return result;
    }

    @Override
    public Panier selectById(int id) throws DalException {
        Panier result = new Panier();
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECTBYID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                // gitignore

                Panier panier = new Panier();
                panier.setMontant(rs.getFloat("montant"));
                panier.setId(rs.getInt("id"));

                result = panier;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("Problème dans la sélection d'article");
        }
        return result;
    }

    @Override
    public void update(Panier panier) throws DalException {
        try (Connection cnx = JdbcTools.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setFloat(1, panier.getMontant());

            stmt.setInt(2, panier.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DalException("Problème dans la modification");
        }
    }

    @Override
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
