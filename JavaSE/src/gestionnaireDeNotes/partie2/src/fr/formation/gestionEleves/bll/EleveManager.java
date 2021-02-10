package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bll;


import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bo.Eleve;
import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal.EleveDALException;

public interface EleveManager {

	public void addEleve(Eleve eleve) throws Exception;
	public float getMoyenneGenerale() throws EleveDALException;
	public float getMoyenne(String classe) throws EleveDALException;
}
