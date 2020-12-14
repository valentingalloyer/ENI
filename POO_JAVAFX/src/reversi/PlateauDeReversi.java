package reversi;

public class PlateauDeReversi {

    private Pion caze[][] = new Pion[8][8];

    public PlateauDeReversi() {

        for (int i=1 ; i<=8 ; i++) {
            for (int j=1 ; j<=8 ; j++) {
                caze[i-1][j-1] = Pion.NOIR;
            }
        }
        caze[3][2] = Pion.LIBRE;
        caze[0][0] = Pion.LIBRE;
        caze[7][0] = Pion.BLANC;
        caze[0][7] = Pion.BLANC;
        caze[7][7] = Pion.BLANC;

        /** Vrai plateau */
        /*
        caze[3][4] = Pion.NOIR;
        caze[4][3] = Pion.NOIR;
        caze[3][3] = Pion.BLANC;
        caze[4][4] = Pion.BLANC;
        caze[6][7] = Pion.BLANC;
        */

        /** Plateau de test */
//
//        caze[3][3] = Pion.NOIR;
//        caze[3][4] = Pion.NOIR;
//        caze[3][5] = Pion.NOIR;
//        caze[3][6] = Pion.BLANC;
//
//        caze[3][1] = Pion.NOIR;
//        caze[3][0] = Pion.NOIR;
//
//        caze[1][2] = Pion.NOIR;
//        caze[2][2] = Pion.NOIR;
//        caze[0][2] = Pion.BLANC;
//
//        caze[4][2] = Pion.NOIR;
//        caze[5][2] = Pion.NOIR;
//        caze[6][2] = Pion.NOIR;
//        caze[7][2] = Pion.BLANC;
//
//        caze[6][1] = Pion.BLANC;
//
//        caze[2][1] = Pion.NOIR;
//        caze[1][0] = Pion.BLANC;
//
//        caze[4][3] = Pion.NOIR;
//        caze[5][4] = Pion.NOIR;
//        caze[6][5] = Pion.BLANC;
//
//        caze[2][3] = Pion.NOIR;
//        caze[1][4] = Pion.NOIR;
//        caze[0][5] = Pion.BLANC;
//
//        caze[4][1] = Pion.NOIR;
//        caze[5][0] = Pion.BLANC;
    }


    public void afficher() {
        System.out.println(Pion.BLANC.getNombre() + " " + Pion.BLANC.getSymbole());
        System.out.println(Pion.NOIR.getNombre() + " " + Pion.NOIR.getSymbole());

        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i=1 ; i<=8 ; i++) {
            System.out.print(i-1 + " ");
            for (int j=1 ; j<=8 ; j++) {
                System.out.print(this.caze[i-1][j-1].getSymbole() + " ");
            }
            System.out.println();
        }
    }

    public int tester(Pion pion, int x, int y) {
        if (this.caze[x][y] != Pion.LIBRE) {
            System.err.println("Impossible de jouer ici, il y a déjà un pion");
            return 0;
        }
        final int xDeBase = x, yDeBase = y;
        int nbPionsQuiChangent = 0, possibiliteChangement = 0;
        Pion autreCouleurPionXY = pion.autrePion();

        // Vérif vers la droite
        while (y < 6 && this.caze[x][y+1] == autreCouleurPionXY) {
            y++;
            possibiliteChangement++;
        }
        if (y < 6 && this.caze[x][y+1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers la gauche
        while (y != 0 && this.caze[x][y-1] == autreCouleurPionXY) {
            y--;
            possibiliteChangement++;
        }
        if (y != 0 && this.caze[x][y-1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers le haut
        while (x != 0 && this.caze[x-1][y] == autreCouleurPionXY) {
            x--;
            possibiliteChangement++;
        }
        if (x != 0 && this.caze[x-1][y] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers le bas
        while (x < 6 && this.caze[x+1][y] == autreCouleurPionXY) {
            x++;
            possibiliteChangement++;
        }
        if (x < 6 && this.caze[x+1][y] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers la diagonale haut gauche
        while (x != 0 && y != 0 && this.caze[x-1][y-1] == autreCouleurPionXY) {
            x--;y--;
            possibiliteChangement++;
        }
        if (x != 0 && y != 0 && this.caze[x-1][y-1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers la diagonale bas gauche
        while (x < 6 && y != 0 && this.caze[x+1][y-1] == autreCouleurPionXY) {
            x++;y--;
            possibiliteChangement++;
        }
        if (x < 6 && y != 0 && this.caze[x+1][y-1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers la diagonale bas droite
        while (x < 6 && y < 6 && this.caze[x+1][y+1] == autreCouleurPionXY) {
            x++;y++;
            possibiliteChangement++;
        }
        if (x < 6 && y < 6 && this.caze[x+1][y+1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }
        x = xDeBase;
        y = yDeBase;
        possibiliteChangement = 0;

        // Vérif vers la diagonale haut droite
        while (x != 0 && y < 6 && this.caze[x-1][y+1] == autreCouleurPionXY) {
            x--;y++;
            possibiliteChangement++;
        }
        if (x != 0 && y < 6 && this.caze[x-1][y+1] == pion) {
            nbPionsQuiChangent += possibiliteChangement;
        }

        return nbPionsQuiChangent;
    }

}
