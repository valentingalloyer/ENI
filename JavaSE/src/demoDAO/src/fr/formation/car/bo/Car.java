package demoDAO.src.fr.formation.car.bo;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private String immat;
	private Integer nbPlaces;

	public Car() {
	}

	public Car(String immat, Integer nbPlace) {
		super();
		this.immat = immat;
		this.nbPlaces = nbPlace;
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlace) {
		this.nbPlaces = nbPlace;
	}

	@Override
	public String toString() {
		return "Car [immat=" + immat + ", nbPlaces=" + nbPlaces + "]";
	}


}
