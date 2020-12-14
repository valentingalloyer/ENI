package reversi;

public class Main {

    public static void main(String[] args) {
        PlateauDeReversi plateauDeReversi = new PlateauDeReversi();

        plateauDeReversi.afficher();
        System.out.println("Nombre de pions gagnés : " + plateauDeReversi.tester(Pion.BLANC, 3,2));
        System.out.println("Nombre de pions gagnés : " + plateauDeReversi.tester(Pion.BLANC, 0,0));
    }

}
