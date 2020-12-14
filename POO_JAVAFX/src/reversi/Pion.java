package reversi;

public enum Pion {

    LIBRE("Libre", "·"),
    BLANC("Blanc", "o"),
    NOIR("Noir", "●");

    Pion(String couleur, String symbole) {
        this.couleur = couleur;
        this.symbole = symbole;
        this.nombre = (couleur == "Libre") ? 60 : 2;
    }

    private int nombre;
    private String couleur, symbole;

    public Pion autrePion() {
        if (this == BLANC)
            return NOIR;
        else if(this == NOIR) {
            return BLANC;
        }
        return null;
    }

    public void gagne(int nbPionsGagnes) {
        this.nombre += nbPionsGagnes;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getNombre() {
        return this.nombre;
    }

    public String getSymbole() {
        return this.symbole;
    }
}
