package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import bo.Biere;
import bo.Brasserie;

public class BiereDAOImpl implements DAO<Biere> {

	private String SELECT_BY_ID = "  USE BRASSERIE_DB SELECT * FROM Biere WHERE idBiere=?";
	private String SELECT_ALL = "  USE BRASSERIE_DB SELECT * FROM Biere";
	private String UPDATE = "  USE BRASSERIE_DB UPDATE Biere SET nom = ? ,idBrasserie = ? ,type = ? ,dateInsert = ?, note = ?  WHERE idBiere= ?";
	private String INSERT = "  USE BRASSERIE_DB INSERT INTO Biere ( nom  ,idBrasserie ,type  ,dateInsert ) VALUES (?,?,?,?)";
	private String DELETE = "   USE BRASSERIE_DB DELETE FROM Biere WHERE idBiere= ?";

	@Override
	public Biere selectById(int id) throws DALException {
		Biere biere = null;
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
				// gitignore

				int idBiere = rs.getInt("idBiere");
				String nom = rs.getString("nom");
				Brasserie brasserie = DAOFact.getBrasserieDAO().selectById(rs.getInt("idBrasserie"));
				String type = rs.getString("type");
				int note = rs.getInt("note");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("dateInsert"));

				biere = new Biere(idBiere, nom, brasserie, type, calendar, note);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la sélection d'une biere");
		}
		return biere;
	}

	@Override
	public List<Biere> selectAll() throws DALException {
		List<Biere> listBiere = new ArrayList<Biere>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
				// gitignore

				int idBiere = rs.getInt("idBiere");
				String nom = rs.getString("nom");
				Brasserie brasserie = DAOFact.getBrasserieDAO().selectById(rs.getInt("idBrasserie"));
				String type = rs.getString("type");
				int note = rs.getInt("note");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("dateInsert"));

				listBiere.add(new Biere(idBiere, nom, brasserie, type, calendar, note));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la sélection d'une biere");
		}
		return listBiere;
	}

	@Override
	public void update(Biere b) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);

			stmt.setString(1, b.getNom());
			stmt.setInt(2, b.getBrasserie().getIdBrasserie());
			stmt.setString(3, b.getType());
			java.sql.Date sqlDate = new java.sql.Date(b.getDateInsert().getTimeInMillis());
			stmt.setDate(4, sqlDate);
			stmt.setInt(5, b.getNote());
			stmt.setInt(6, b.getIdBiere());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la mise à jour d'une bière");
		}

	}

	@Override
	public void insert(Biere b) throws DALException {

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, b.getNom());
			stmt.setInt(2, b.getBrasserie().getIdBrasserie());
			stmt.setString(3, b.getType());
			java.sql.Date sqlDate = new java.sql.Date(b.getDateInsert().getTimeInMillis());
			stmt.setDate(4, sqlDate);

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

			b.setIdBiere(generatedKey);
			System.out.println(generatedKey);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans l'insertion d'une bière");
		}
	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(DELETE);

			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la suppression d'une bière");

		}

	}

}
