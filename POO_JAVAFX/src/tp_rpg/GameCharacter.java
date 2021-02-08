package tp_rpg;

public class GameCharacter {

    private String name;
    private int hp, mp, atk, def, vit;
    private boolean alive;

    public GameCharacter(String name, int hp, int mp, int atk, int def, int vit) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.vit = vit;
        this.alive = hp > 0;
    }

    public void loseHP(int damage) {
        this.hp -= damage * ((100 - def) / 100);
        if (this.hp > 0) {
            this.setAlive(true);
            System.out.print(this.name + " perd " + damage + "hp ! BOUMSHAKALAKA\nACTUALISATION : ");
            this.afficherInfo();
        } else {
            this.onDead();
        }
    }

    public void onDead() {
        System.out.println(this.name + " : Je meurs !");
        this.setHp(0);
        this.setAlive(false);
    }

    public void attaquer(GameCharacter targetCharacter) {
        if (targetCharacter.isAlive()) {
            System.out.println(this.name + " attaque " + targetCharacter.getName() + " !!!! OWWWWWW");
            targetCharacter.loseHP(this.atk);
        } else {
            System.out.println("ARRÊTE, il est déjà mort !!!");
        }
    }

    public void afficherInfo() {
        System.out.println(this.name + (isAlive() ? "" : "(MORT)") + "\n" +
                "HP | MP | Atk | Def | Vit\n" +
                this.hp + " | " + this.mp + " | " + this.atk + "  | " + this.def + " | " + this.vit);
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

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }
}
