package calculatrice.src.fr.formation.calculatrice.ihm;

import calculatrice.src.fr.formation.calculatrice.bll.Calculatrice;

import java.util.Scanner;


public class Exec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("entrer a : ");
		Integer a = sc.nextInt();sc.nextLine();
		System.out.println("entrer b : ");
		Integer b = sc.nextInt();sc.nextLine();
		
		System.out.println(Calculatrice.plus(a, b));
	}

}
