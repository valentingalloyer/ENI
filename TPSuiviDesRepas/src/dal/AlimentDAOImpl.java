package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bo.Aliment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class AlimentDAOImpl implements DAO<Aliment> {

    private String SELECT_BY_ID = "USE SuiviRepas SELECT * FROM Aliment WHERE idAliment=?";
    private String SELECT_ALL = "USE SuiviRepas SELECT * FROM Aliment";
    private String UPDATE = "USE SuiviRepas UPDATE Aliment SET nomAliment = ?  WHERE idAliment= ?";
    private String INSERT = "USE SuiviRepas INSERT INTO Aliment (nomAliment) VALUES (?)";
    private String DELETE = "USE SuiviRepas DELETE FROM Aliment WHERE idAliment= ?";


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
    public Aliment selectById(int id) throws DALException {
        Aliment aliment = null;
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idAliment = rs.getInt("idAliment");
                String nomAliment = rs.getString("nomAliment");
                aliment = new Aliment(idAliment, nomAliment);

            }
            cnx.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probl�me dans la s�lection d'un Aliment");
        }
        return aliment;
    }

    @Override
    public List<Aliment> selectAll() throws DALException {
        List<Aliment> listAliment = new ArrayList<Aliment>();
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // TODO : ajouter la gestion de l'idCar dans la BO et le r�cup�rer ici
                // gitignore
                int idAliment = rs.getInt("idAliment");
                String nomAliment = rs.getString("nomAliment");
                listAliment.add(new Aliment(idAliment, nomAliment));

            }
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probl�me dans la s�lection des Aliments");
        }
        return listAliment;
    }

    @Override
    public void update(Aliment b) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
            stmt.setString(1, b.getNomAliment());
            stmt.setInt(2, b.getIdAliment());
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probl�me dans la mise � jour d'un Aliment");
        }

    }

    @Override
    public void insert(Aliment b) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, b.getNomAliment());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            b.setIdAliment(generatedKey);
            System.out.println(generatedKey);
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probl�me dans l'insertion d'un aliment");
        }
    }

    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            //
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probl�me dans la suppression d'un Aliment");

        }

    }

}