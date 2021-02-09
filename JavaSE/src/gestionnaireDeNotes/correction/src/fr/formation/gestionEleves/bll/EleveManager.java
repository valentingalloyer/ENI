package gestionnaireDeNotes.correction.src.fr.formation.gestionEleves.bll;


import gestionnaireDeNotes.correction.src.fr.formation.gestionEleves.bo.Eleve;

public interface EleveManager {

	public void addEleve(Eleve eleve) throws Exception;
	public Integer getMoyenneGenerale();
	public Integer getMoyenne(String classe);
}
