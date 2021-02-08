package GestionnaireDeNotes.bll;

import GestionnaireDeNotes.bo.Eleve;

import java.util.List;

public interface GestionnaireDeNotesManager {

    void saisieEleveNotes(Eleve eleve);

    float calculMoyenneGenerale(List<Eleve> listeEleves);

    float calculMoyenneGenerale(List<Eleve> listeEleves, String classe);

    Eleve getMeilleurEleve(List<Eleve> listeEleves);

}
