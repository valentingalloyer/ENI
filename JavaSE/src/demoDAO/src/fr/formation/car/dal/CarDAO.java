package demoDAO.src.fr.formation.car.dal;

import demoDAO.src.fr.formation.car.bo.Car;

import java.util.List;



public interface CarDAO {
	public void insert(Car car) throws CarDALException;
	public List<Car> getAll() throws CarDALException;
}
