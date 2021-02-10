package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal;

import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bo.Eleve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EleveDAOImpl implements EleveDAO {
	private String INSERT = "INSERT INTO eleves (nom, prenom, note, classe) VALUES (?,?,?,?)";
	private String SELECT = "SELECT * FROM eleves";
	
	@Override
	public void insert(Eleve eleve) throws EleveDALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(INSERT);
			stmt.setString(1, eleve.getNom());
			stmt.setString(2, eleve.getPrenom());
			stmt.setInt(3, eleve.getNote());
			stmt.setString(4, eleve.getClasse());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new EleveDALException("problème dans l'insertion d'un car");
		}
	}

	@Override
	public List<Eleve> getAll() throws EleveDALException {
		List<Eleve> result = new ArrayList<Eleve>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Eleve eleve = new Eleve();
				eleve.setNom(rs.getString("nom"));
				eleve.setPrenom(rs.getString("prenom"));
				eleve.setNote(rs.getInt("note"));
				eleve.setClasse(rs.getString("classe"));
				result.add(eleve);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EleveDALException("problème dans la selection des élèves");
		}
		return result;
	}

}
