package tp_rpg;

public class GameCharacter {

    private String name;
    private int hp, mp, atk, def;
    private boolean alive;

    public GameCharacter(String name, int hp, int mp, int atk, int def, boolean alive) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.alive = alive;
    }

    public void loseHP(int damage) {
        this.hp -= damage;
    }

    public void onDead() {

    }

    public void attaquer(GameCharacter targetCharacter) {
        targetCharacter.loseHP(this.atk);
    }

    public String afficherInfo() {
        return (isAlive() ? "VIVANT" : "MORT") + "\n" +
                "Nom : " + this.name + "\n" +
                "HP : " + this.hp + " \n" +
                "MP : " + this.mp + " \n" +
                "Atk : " + this.atk + " \n" +
                "Def : " + this.def + " \n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
