package fr.formation.calculatrice.ihm;

import java.util.Scanner;

import fr.formation.calculatrice.bll.Calculatrice;

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
