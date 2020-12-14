package tp_rpg;

import java.util.ArrayList;

public class TeamBattle {

    String name;
    ArrayList<GameCharacter> fighterList;
    boolean aliveFighterList;

    public TeamBattle(String name, ArrayList<GameCharacter> fighterList, boolean aliveFighterList) {
        this.name = name;
        this.fighterList = fighterList;
        this.aliveFighterList = aliveFighterList;
    }

    public GameCharacter getFighter(int i) {
        return this.fighterList.get(i);
    }

    public GameCharacter getFighter(int i, boolean onlyAlive) {
        int j=0;
        while (j<i && j < this.fighterList.size()) {
            if(getFighter(j).isAlive()) {
                j++;
            }
        }
        if (j == i)
            return getFighter(j);
        return null;
    }


}
