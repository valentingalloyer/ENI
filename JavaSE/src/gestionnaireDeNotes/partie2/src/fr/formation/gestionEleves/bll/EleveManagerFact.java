package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bll;

public class EleveManagerFact {
	
	private EleveManagerFact() {
	}
	
	public static EleveManager getInstance() {
		return new EleveManagerImpl();
	}
}
