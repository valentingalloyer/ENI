package demoDAO.src.fr.formation.car.dal;

import demoDAO.src.fr.formation.car.bo.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CarDAOImpl implements CarDAO {
	private String INSERT = "INSERT INTO car (immat,nbPlace) VALUES (?,?)";
	private String SELECT = "SELECT idCar,immat,nbPlace FROM car";
	
	@Override
	public void insert(Car car) throws CarDALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(INSERT);
			stmt.setString(1, car.getImmat());
			stmt.setInt(2, car.getNbPlaces());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new CarDALException("problème dans l'insertion d'un car");
		}
	}

	@Override
	public List<Car> getAll() throws CarDALException {
		List<Car> result = new ArrayList<Car>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				// TODO : ajouter la gestion de l'idCar dans la BO et le récupérer ici
				Car car = new Car();
				car.setImmat(rs.getString("immat"));
				car.setNbPlaces(rs.getInt("nbPlace"));
				result.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CarDALException("problème dans la selection des cars");
		}
		return result;
	}

}
