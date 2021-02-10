package demoDAO.src.fr.formation.car.test;


import demoDAO.src.fr.formation.car.bo.Car;
import demoDAO.src.fr.formation.car.dal.CarDALException;
import demoDAO.src.fr.formation.car.dal.CarDAO;
import demoDAO.src.fr.formation.car.dal.DAOFact;

public class TestCarDAO {
	private static CarDAO carDAO = DAOFact.getCarDAO();
	
	public static void main(String[] args) throws CarDALException {
		carDAO.insert(new Car("nouveau",6));
		
		System.out.println(carDAO.getAll());
	}

}
