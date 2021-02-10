package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal;

public class EleveDAOFact {
	public static EleveDAO getEleveDAO() {
		return new EleveDAOImpl();
	}
}
