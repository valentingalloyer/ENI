package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bll;

import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bo.Eleve;
import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal.EleveDALException;
import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal.EleveDAOFact;

class EleveManagerImpl implements EleveManager {

	@Override
	public void addEleve(Eleve eleve) throws Exception {
		// contrainte de la note entre 0 et 20
		if (eleve.getNote() < 0 || eleve.getNote() > 20) {
			throw new Exception("Note non conformes");
		}
		
		// contrainte de l'absence d'homonyme
		for (Eleve e : EleveDAOFact.getEleveDAO().getAll()) {
			if(eleve.getNom().equals(e.getNom()) && eleve.getPrenom().equals(e.getPrenom())){
				throw new Exception("Élève déjà présent");
			}
		}

		EleveDAOFact.getEleveDAO().insert(eleve);

	}

	@Override
	public float getMoyenneGenerale() throws EleveDALException {
		Integer somme = 0;
		for (Eleve eleve : EleveDAOFact.getEleveDAO().getAll()) {
			somme += eleve.getNote();
		}
		return (float) somme / EleveDAOFact.getEleveDAO().getAll().size();
	}

	@Override
	public float getMoyenne(String classe) throws EleveDALException {
		Integer somme = 0;
		int cpt = 0;
		for (Eleve eleve : EleveDAOFact.getEleveDAO().getAll()) {
			if (classe.equals(eleve.getClasse())) {
				somme += eleve.getNote();
				cpt++;
			}
		}
		return (float) somme / cpt;
	}

}
