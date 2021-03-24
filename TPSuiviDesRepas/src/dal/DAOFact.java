package dal;

import bo.Biere;
import bo.Brasserie;

public class DAOFact {
	public static DAO<Brasserie> getBrasserieDAO() {
		return new BrasserieDAOImpl();
	}
	
	
	public static DAO<Biere> getBiereDAO() {
		return new BiereDAOImpl();
	}
	
	public static BlackList getBlackList() {
		return new BlackList();
	}
}
