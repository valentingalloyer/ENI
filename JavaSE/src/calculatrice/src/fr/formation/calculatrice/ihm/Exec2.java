package calculatrice.src.fr.formation.calculatrice.ihm;

import calculatrice.src.fr.formation.calculatrice.bll.Calculatrice;

public class Exec2 {

	public static void main(String[] args) {
		
		System.out.println(Calculatrice.plus(2, 3));
		try {
			System.out.println(Calculatrice.div(4, 0));
		} catch (Exception e) {
			System.out.println("ERREUR : " + e.getMessage());
		}
		Integer test = 3;
		new Integer(2).equals(test);

	}

}
