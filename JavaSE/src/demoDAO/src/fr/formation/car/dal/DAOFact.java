package demoDAO.src.fr.formation.car.dal;

public class DAOFact {
	public static CarDAO getCarDAO() {
		return new CarDAOImpl();
	}
}
