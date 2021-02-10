package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.ihm;


import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bll.EleveManager;
import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bll.EleveManagerFact;

public class Exec {

	public static void main(String[] args) throws Exception {
		EleveManager manager = EleveManagerFact.getInstance();
		/*
		manager.addEleve(new Eleve("Cérien", "Jean", 2, "DL"));
		manager.addEleve(new Eleve("Terrieur", "Alex", 20, "DL"));
		manager.addEleve(new Eleve("Terrieur", "Alain", 12, "DL"));
		manager.addEleve(new Eleve("Zita", "Eva", 5, "CDA"));
		manager.addEleve(new Eleve("Dupont", "Jean", 15, "CDA"));
		
		try {
			manager.addEleve(new Eleve("Plufort", "Amélie", 25, "CDA"));
		} catch (Exception e) {
			System.out.println("ERREUR "+e.getMessage());
		}
		
		try {
			manager.addEleve(new Eleve("Dupont", "Jean", 20, "CDA"));
		} catch (Exception e) {
			System.out.println("ERREUR "+e.getMessage());
		}
		*/
		
		
		System.out.println("la moyenne générale est : "+manager.getMoyenneGenerale());
		System.out.println("la moyenne des DL est "+manager.getMoyenne("DL"));
		System.out.println("la moyenne des CDA est "+manager.getMoyenne("CDA"));
	}

}
