package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import bo.Aliment;
import bo.Repas;
import com.google.gson.Gson;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RepasDAOImpl implements DAO<Repas> {

    private String SELECT_BY_ID = "USE SuiviRepas SELECT * FROM Repas WHERE idRepas=?";
    private String SELECT_ALL = "USE SuiviRepas SELECT * FROM Repas";
    private String UPDATE = "USE SuiviRepas UPDATE Repas SET nom = ? ,idRepas = ? ,dateRepas = ? ,listeAliment = ? WHERE idRepas = ?";
    private String INSERT = "USE SuiviRepas INSERT INTO Repas (idRepas, dateRepas, listeAliment) VALUES (?,?,?)";
    private String DELETE = "USE SuiviRepas DELETE FROM Repas WHERE idRepas= ?";

    private Connection connect() {
        try {
            // Je vais chercher le fichier context.xml
            Context context = new InitialContext();
            // Je vais lire le fichier context.xml
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            // J'ouvre une connection
            Connection cnx = ds.getConnection();
            return cnx;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Repas selectById(int id) throws DALException {
        Repas repas = null;
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
                // gitignore

                int idRepas = rs.getInt("idRepas");
                String nom = rs.getString("nom");
                Calendar dateRepas = rs.getDate("dateRepas")
                List<Aliment> listeAliment = rs.getString("listeAliment");

                repas = new Repas(idRepas, dateRepas, listeAliment);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un repas");
        }
        return repas;
    }

    @Override
    public List<Repas> selectAll() throws DALException {
        List<Repas> listRepas = new ArrayList<Repas>();
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idRepas = rs.getInt("idRepas");
                String nom = rs.getString("nom");
                Calendar dateRepas = rs.getDate("dateRepas")
                List<Aliment> listeAliment = rs.getString("listeAliment");

                listRepas.add(new Repas(idRepas, dateRepas, listeAliment));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un repas");
        }
        return listRepas;
    }

    @Override
    public void update(Repas r) throws DALException {
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);

            stmt.setInt(1, r.getIdRepas());
            java.sql.Date sqlDate = new java.sql.Date(r.getDateRepas().getTimeInMillis());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, r.getListeAliment());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'un repas");
        }

    }

    @Override
    public void insert(Repas r) throws DALException {

        try {
            Connection cnx = connect();

            SALUT BEAU GOSSE
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, r.getIdRepas());
            java.sql.Date sqlDate = new java.sql.Date(r.getDateRepas().getTimeInMillis());
            stmt.setDate(2, sqlDate);
            stmt.setString(r.getListeAliment());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            r.setIdRepas(generatedKey);
            System.out.println(generatedKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'un repas");
        }
    }

    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(DELETE);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la suppression d'un repas");

        }

    }

}
