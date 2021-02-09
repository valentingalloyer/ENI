package gestionnaireDeNotes.perso.bll;



import gestionnaireDeNotes.perso.bo.Eleve;

import java.util.List;

public interface GestionnaireDeNotesManager {

    void saisieEleveNotes(Eleve eleve);

    float calculMoyenneGenerale(List<Eleve> listeEleves);

    float calculMoyenneGenerale(List<Eleve> listeEleves, String classe);

    Eleve getMeilleurEleve(List<Eleve> listeEleves);

}
