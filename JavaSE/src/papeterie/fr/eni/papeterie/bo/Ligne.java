package papeterie.fr.eni.papeterie.bo;

public class Ligne {

    protected int qte;

    public Ligne(int qte) {
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
