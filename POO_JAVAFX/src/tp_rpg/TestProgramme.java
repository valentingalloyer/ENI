package tp_rpg;

import java.util.*;

public class TestProgramme {

    public static List<GameCharacter> listeOrdonneeTourParTour(TeamBattle t1, TeamBattle t2) {
        int totalPlayers = t1.countNbFighter() + t2.countNbFighter();
        GameCharacter[] arrayTPT = new GameCharacter[totalPlayers];
        int cptteam1 = 0;
        int cptteam2 = 0;
        for (int i = 0; i < totalPlayers; i++) {
            if (i % 2 == 0) { // si i est pair

            }
        }
        return Arrays.asList(arrayTPT);
    }

//    public ArrayList<GameCharacter> triList(ArrayList<GameCharacter> l) {
//        int max = -1;
//        for (int i=0 ; i<l.size() ; i++){
//            if (l.)
//        }
//
//    }

    public static void main(String[] args) {

        GameCharacter valentin = new GameCharacter("Valentin", 100, 50, 25, 25, 90);
        GameCharacter teo = new GameCharacter("T2Ø", 50, 25, 10, 10, 80);
        GameCharacter nicolas = new GameCharacter("Nicolas", 40, 60, 20, 60, 70);
        GameCharacter aline = new GameCharacter("Aline", 100, 40, 2, 0, 95);
        GameCharacter amandine = new GameCharacter("Amandine", 40, 20, 20, 50, 10);

        ArrayList list1 = new ArrayList<GameCharacter>() {
            {add(valentin); add(teo); add(nicolas);}
        };
        ArrayList list2 = new ArrayList<GameCharacter>() {
            {add(aline); add(amandine);}
        };
        ArrayList listTousLesJoueurs = new ArrayList<GameCharacter>() {
            {add(valentin); add(teo); add(nicolas); add(aline); add(amandine);}
        };
        ArrayList listOrdonneeParVitesse = new ArrayList<GameCharacter>();

        TeamBattle teamJoueur = new TeamBattle("La TeamFoufou !", list1);
        TeamBattle teamOrdi = new TeamBattle("La Team Sans Internet", list2);

        teamJoueur.afficherEquipe();

        valentin.attaquer(teo);
        System.out.println("------------------------------------");
        valentin.attaquer(teo);

        int i=1;
        int max;
        Scanner sc = new Scanner(System.in);

        while (!teamJoueur.teamIsDead() && !teamOrdi.teamIsDead()) {
            System.out.println(
                    "==========================================\n" +
                    "================ TOUR " + i + " ==================\n" +
                    "==========================================\n");
            teamJoueur.afficherEquipe();
            teamOrdi.afficherEquipe();
            for (int j=0 ; j < teamJoueur.countNbAliveFighter() + teamOrdi.countNbAliveFighter() ; j++) {

            }

            System.out.println("Sélectionner une cible");
            break;

        }

    }

}
