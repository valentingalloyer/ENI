package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bo.Brasserie;


public class BrasserieDAOImpl implements DAO<Brasserie> {

	private String SELECT_BY_ID = "  USE BRASSERIE_DB SELECT * FROM Brasserie WHERE idBrasserie=?";
	private String SELECT_ALL = "  USE BRASSERIE_DB SELECT * FROM Brasserie";
	private String UPDATE = "  USE BRASSERIE_DB UPDATE Brasserie SET codePostal = ? ,region = ? ,adresse = ? ,nom = ?  WHERE idBrasserie= ?";
	private String INSERT = "  USE BRASSERIE_DB INSERT INTO Brasserie (codePostal, region, adresse, nom) VALUES (?,?,?,?)";
	private String DELETE = "   USE BRASSERIE_DB DELETE FROM Brasserie WHERE idBrasserie= ?";

	@Override
	public Brasserie selectById(int id) throws DALException {
		Brasserie brasserie = null;
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
				// gitignore

				int idBrasserie = rs.getInt("idBrasserie");
				String codePostal = rs.getString("codePostal");
				// Brasserie brasserie =
				String region = rs.getString("region");
				String adresse = rs.getString("adresse");
				String nom = rs.getString("nom");
				

				brasserie = new Brasserie( idBrasserie,  codePostal,  region,  adresse,  nom);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la sélection d'une Brasserie");
		}
		return brasserie;
	}

	@Override
	public List<Brasserie> selectAll() throws DALException {
		List<Brasserie> listBrasserie = new ArrayList<Brasserie>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
				// gitignore

				int idBrasserie = rs.getInt("idBrasserie");
				String codePostal = rs.getString("codePostal");
				// Brasserie brasserie =
				String region = rs.getString("region");
				String adresse = rs.getString("adresse");
				String nom = rs.getString("nom");
				

				listBrasserie.add(new Brasserie( idBrasserie,  codePostal,  region,  adresse,  nom));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la sélection des Brasseries");
		}
		return listBrasserie;
	}
	
	@Override
	public void update(Brasserie b) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);

			stmt.setString(1, b.getCodePostal());
			stmt.setString(2, b.getRegion());
			stmt.setString(3, b.getAdresse());
			stmt.setString(4, b.getNom());
			
			stmt.setInt(5, b.getIdBrasserie());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans la mise à jour d'une brasserie");
		}

	}

	@Override
	public void insert(Brasserie b) throws DALException {

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, b.getCodePostal());
			stmt.setString(2, b.getRegion());
			stmt.setString(3, b.getAdresse());
			stmt.setString(4, b.getNom());
			
			

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

			b.setIdBrasserie(generatedKey);
			System.out.println(generatedKey);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème dans l'insertion d'une brasseroe");
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
			throw new DALException("Problème dans la suppression d'une brasserie");

		}

	}

}
