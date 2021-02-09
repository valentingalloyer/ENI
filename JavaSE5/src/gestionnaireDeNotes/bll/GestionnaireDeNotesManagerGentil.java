package gestionnaireDeNotes.bll;


import gestionnaireDeNotes.bo.Eleve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestionnaireDeNotesManagerGentil extends GestionnaireDeNotesManagerImpl {


    @Override
    public void saisieEleveNotes(Eleve e) {
        ArrayList<Eleve> listeEleve = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i=0 ; i<4; i++) {
            System.out.println("Entrez un prénom");
            String prenom = sc.nextLine();
            System.out.println("Entrez un nom");
            String nom = sc.nextLine();
            System.out.println("Quelle est sa classe ?");
            String classe = sc.nextLine();
            System.out.println("La note ?");
            float note = sc.nextFloat() + 5;
            note = note >= 20 ? 20 : note;
            Eleve eleve = new Eleve(nom, prenom, classe, note);
            listeEleve.add(eleve);
        }
    }


}
