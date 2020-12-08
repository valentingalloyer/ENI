package eni.tpModule;

import java.io.File;
import java.util.*;

public class Programme {


    public static ArrayList<Character> tirerMotAleatoirement() {
        File dico = new File("./dictionnaire.txt");
        try {
            Scanner s = new Scanner(dico);
            int nbLignes = 22506;
            Random rand = new Random();
            int randomInt = rand.nextInt(nbLignes);
            int cpt = 0;
            try {
                while (s.hasNextLine() && cpt < randomInt) {
                    s.nextLine();
                    cpt++;
                }
                String randomWordPicked = s.nextLine();
                randomWordPicked = randomWordPicked.toUpperCase();

                ArrayList<Character> wordCharList = new ArrayList<>();
                for (int i = 0; i < randomWordPicked.length(); i++) {
                    wordCharList.add(randomWordPicked.charAt(i));
                }
                s.close();
                return wordCharList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Character> melanger(ArrayList<Character> liste) {
        ArrayList newListe = new ArrayList<>();
        newListe = liste;Collections.shuffle(newListe);
        return newListe;
    }

    public static ArrayList<Character> afficher(ArrayList<Character> lettres) {
        System.out.println(lettres);
        return lettres;
    }

    public static boolean bonnesLettres(String bonnesLettres, String lettresProposees) {
        // Si les deux listes ne sont pas de la même taille, alors c'est forcément faux
        if (bonnesLettres.length() != lettresProposees.length())
            return false;
        // Conversion en list
        ArrayList<Character> bonnesLettresList = new ArrayList<>();
        ArrayList<Character> lettresProposeesList = new ArrayList<>();
        for (int i=0 ; i<bonnesLettres.length() ; i++) {
            bonnesLettresList.add(bonnesLettres.charAt(i));
            lettresProposeesList.add(lettresProposees.charAt(i));
        }
        char lettre = 'a';

        for (int i = 0; i < bonnesLettresList.size(); i++) {
            // Si bonnesLettres ne contient pas la lettre i de lettresProposees, alors c'est faux
            if (!bonnesLettresList.contains(lettresProposeesList.get(i))) {
                return false;
            }
            // Si bonnesLettres la contient, on la supprime de lettresProposees
            lettre = lettresProposeesList.get(i);
            for (int j=0 ; j<bonnesLettresList.size() ; j++) {
                if (bonnesLettresList.get(j) == lettre) {
                    bonnesLettresList.remove(j);
                }
                break;
            }
        }
        return true;
    }

    public static boolean dansLeDico(String proposition) {
        File dico = new File("./dictionnaire.txt");
        try {
            Scanner s = new Scanner(dico);
            int nbLignes = 22506;
            try {
                String motEssaye = proposition.toUpperCase();
                while (s.hasNextLine()) {
                    String motDuDico = s.nextLine().toUpperCase();
                    if (motEssaye.equals(motDuDico))
                        return true;
                }
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Pas dans le dico");
        return false;
    }

    private static String saisirProposition() {
        Scanner s = new Scanner(System.in);
        System.out.println("Quelle est votre proposition ?");
        String proposition = s.nextLine();
        s.close();
        return proposition;
    }

    public static void main(String[] args) {
        System.out.println(bonnesLettres("ADR", "RAR"));
        ArrayList<Character> motAleatoire = new ArrayList<>();
        motAleatoire = tirerMotAleatoirement();
        String motATrouver = "";
        for (int i=0 ; i<motAleatoire.size() ; i++) {
            motATrouver += motAleatoire.get(i);
        }
        System.out.println("Petit indice : " + motATrouver);
        List<Character> bonMot = afficher(melanger(motAleatoire));

        String proposition = saisirProposition();
        proposition = proposition.toUpperCase();
        if (bonnesLettres(motATrouver, proposition) && dansLeDico(proposition))
            System.out.println("Vous avez gagné, le bon mot était effectivement " + proposition + " !");
        else
            System.out.println("T'es mauvais, la réponse c'était " + motATrouver);

    }

}
