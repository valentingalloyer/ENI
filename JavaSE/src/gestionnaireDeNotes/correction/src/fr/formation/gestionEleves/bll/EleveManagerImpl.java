package gestionnaireDeNotes.correction.src.fr.formation.gestionEleves.bll;

import gestionnaireDeNotes.correction.src.fr.formation.gestionEleves.bo.Eleve;

import java.util.ArrayList;
import java.util.List;


class EleveManagerImpl implements EleveManager {
	private static List<Eleve> lstEleves = new ArrayList<Eleve>();

	@Override
	public void addEleve(Eleve eleve) throws Exception {
		// contrainte de la note entre 0 et 20
		if (eleve.getNote() < 0 || eleve.getNote() > 20) {
			throw new Exception("Note non conformes");
		}
		
		// contrainte de l'absence d'homonyme
		for (Eleve e : lstEleves) {
			if(eleve.getNom().equals(e.getNom()) && eleve.getPrenom().equals(e.getPrenom())){
				throw new Exception("Eleve déjà présent");
			}
		}
		lstEleves.add(eleve);

	}

	@Override
	public Integer getMoyenneGenerale() {
		Integer somme = 0;
		for (Eleve eleve : lstEleves) {
			somme += eleve.getNote();
		}
		return somme / lstEleves.size();
	}

	@Override
	public Integer getMoyenne(String classe) {
		Integer somme = 0;
		Integer cpt = 0;
		for (Eleve eleve : lstEleves) {
			if (classe.equals(eleve.getClasse())) {
				somme += eleve.getNote();
				cpt++;
			}
		}
		return somme / cpt;
	}

}
