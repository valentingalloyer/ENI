package tp_rpg;

import java.util.ArrayList;
import java.util.Collections;

public class TeamBattle {

    private String name;
    private ArrayList<GameCharacter> fighterList, aliveFighterList;


    public TeamBattle(String name, ArrayList<GameCharacter> fighterList) {
        this.name = name;
        this.fighterList = fighterList;
        this.aliveFighterList = fighterList;
    }

//    public ArrayList<GameCharacter> triList() {
//        int max = -1;
//        for (int i=0 ; i<this.fighterList.size() ; i++) {
//            for (int j=0 ; j<this.fighterList.size() ; j++) {
//                if (this.getFighter(i).getVit() > max) {
//                    max = this.getFighter(i).getVit();
//
//                }
//            }
//        }
//
//    }

    public GameCharacter getFighter(int i) {
        return this.fighterList.get(i);
    }

    public GameCharacter getFighter(int i, boolean onlyAlive) {
        if (onlyAlive) {
            return this.aliveFighterList.get(i);
        }
        return this.fighterList.get(i);
    }

    public int countNbFighter() {
        return this.fighterList.size();
    }

    public int countNbAliveFighter() {
        return this.aliveFighterList.size();
    }

    public boolean teamIsDead() {
        return this.aliveFighterList.size() == 0;
    }

    public void afficherEquipe() {
        System.out.println("Équipe : " + this.name + (teamIsDead() ? " (MORTE)" : "") + "\n" +
                countNbAliveFighter() + " combattants vivants sur " + countNbFighter());
        for (int i = 0; i < this.fighterList.size(); i++) {
            System.out.println("------------ MEMBRE n°" + i + " ------------");
            getFighter(i).afficherInfo();
        }
        System.out.println("------------------------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GameCharacter> getFighterList() {
        return fighterList;
    }

    public void setFighterList(ArrayList<GameCharacter> fighterList) {
        this.fighterList = fighterList;
    }

    public ArrayList<GameCharacter> getAliveFighterList() {
        return aliveFighterList;
    }

    public void setAliveFighterList(ArrayList<GameCharacter> aliveFighterList) {
        this.aliveFighterList = aliveFighterList;
    }
}
