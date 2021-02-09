package gestionnaireDeNotes.perso.bll;


import gestionnaireDeNotes.perso.bo.Eleve;

import java.util.List;
import java.util.stream.Collectors;

public class GestionnaireDeNotesManagerImpl implements GestionnaireDeNotesManager {


    public void saisieEleveNotes(Eleve e) {

    }

    @Override
    public float calculMoyenneGenerale(List<Eleve> listeEleves) {
        float sommeNotes = 0, nombreNotes = 0;
        for (Eleve eleve:listeEleves) {
            sommeNotes += eleve.getNote();
            nombreNotes++;
        }
        return sommeNotes/nombreNotes;
    }

    @Override
    public float calculMoyenneGenerale(List<Eleve> listeEleves, String classe) {
        listeEleves.forEach(Eleve::toString);
        List<Eleve> nouvelleListe = listeEleves.stream().filter(eleve -> eleve.getClasse().equals(classe)).collect(Collectors.toList());
        listeEleves.forEach(Eleve::toString);
        return calculMoyenneGenerale(nouvelleListe);
    }

    @Override
    public Eleve getMeilleurEleve(List<Eleve> listeEleves) {
        Eleve meilleurEleve = listeEleves.get(0);

        for (Eleve eleve : listeEleves) {
            if (eleve.getNote() > meilleurEleve.getNote()) {
                meilleurEleve = eleve;
            }
        }

        return meilleurEleve;
    }
}
