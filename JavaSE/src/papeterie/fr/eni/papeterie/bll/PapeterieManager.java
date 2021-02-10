package papeterie.fr.eni.papeterie.bll;

import papeterie.fr.eni.papeterie.bo.Article;
import papeterie.fr.eni.papeterie.bo.Ligne;

import java.util.List;

public interface PapeterieManager {

    // PANIER
    Ligne getLigne(int index);
    List<Ligne> getLignesPanier();
    void addLigne(Article article, int qte);
    void updateLigne(int index, int newQte);
    void removeLigne(int index);

    // LIGNE
    Article getArticle();
    float getPrix();
    Article setArticle();
    void setQte(int qte);

}
