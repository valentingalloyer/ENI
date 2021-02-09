package gestionnaireDeNotes.ihm;



import gestionnaireDeNotes.bll.GestionnaireDeNotesManager;
import gestionnaireDeNotes.bll.GestionnaireDeNotesManagerFact;
import gestionnaireDeNotes.bo.Eleve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exec {

    public static void main(String[] args) {
        System.out.println("Voulez-vous une notation gentille ? (taper false)");
        Scanner sc = new Scanner(System.in);
        boolean notation = sc.nextBoolean();
        GestionnaireDeNotesManager manager = new GestionnaireDeNotesManagerFact().getInstance(notation);
//        GestionnaireDeNotesManager manager = GestionnaireDeNotesManagerFact.getInstance();

        manager.saisieEleveNotes(new Eleve("Galloyer", "Valentin", "A", 20));
        manager.saisieEleveNotes(new Eleve("Bryer", "Téo", "A", 17.5F));
        manager.saisieEleveNotes(new Eleve("Ravard", "Maxime", "B", 14));
        manager.saisieEleveNotes(new Eleve("Fauveau", "Nicolas", "B", 8));
        manager.saisieEleveNotes(new Eleve("Cathelinais", "Corentin", "B", 13));


//        List<Eleve> listeEleves = manager.saisieEleveNotes();
//        System.out.println("Moyenne générale : " + manager.calculMoyenneGenerale(listeEleves));
//        System.out.println("Moyenne générale (classe A) : " + manager.calculMoyenneGenerale(listeEleves, "a"));
//        System.out.println("Meilleur élève : " + manager.getMeilleurEleve(listeEleves));

    }
}
