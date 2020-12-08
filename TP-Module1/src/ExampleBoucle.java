import java.util.Scanner;

public class ExampleBoucle {
	public enum Groupe {
		GARE,
		SERVICE_PUBLIC,
		MAUVE,
		BLEU,
		VIOLET,
		ORANGE,
		ROUGE,
		JAUNE,
		VERT,
		MARINE;
		}
	

	private static void exampleBoucleFor() {
		float[] valeurs = {10.5f, 14.2f, 15,78f, 20, 19.2f};
		for (int i = 0; i < valeurs.length; i++) {
			System.out.format("%.2f%n", valeurs[i]);
		}
	}
	
	private static void exampleBoucleForeach() {
		float[] valeurs = {10.5f, 14.2f, 15,78f, 20, 19.2f};
		for(float f : valeurs) {
			System.out.format("%.2f%n",f);
		}
	}
	
	private static void exampleWhile() {
		Scanner s = new Scanner(System.in);
		float total = 0;
		System.out.println("Saisissez une valeur ou rien pour terminer la saisie");
		String saisie = s.nextLine();
		while (!saisie.isEmpty()) {
			float valeur = Float.parseFloat(saisie);
			total += valeur;
			System.out.println("Saisissez une note ou rien pour terminer la saisie");
			saisie = s.nextLine();
		}
		System.out.printf("Total des valeurs saisies : %f%n", total);
	}
	
	private static void exampleDoWhile() {
		int min = 1;
		int max = 10;
		System.out.println("Entrez un nombre");
		Scanner s = new Scanner(System.in);
		int val = 0;
		boolean ok;
		do {
			val = s.nextInt();
			s.nextLine();
			ok = val >= min && val <= max;
			if (!ok)
			System.err.printf("La valeur doit �tre un entier compris entre %d et %d%nRessaisissez... ",
			min, max);
		} while (!ok);

	}

	private static void exampleEnums() {
		for (Groupe groupe : Groupe.values()) {
			System.err.printf("Mon enums %s %nRessaisissez... ", groupe);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Example 1
		// exampleBoucleFor();
		// Example 2 
		// exampleBoucleForeach();
		// Example 3
		// exampleWhile();
		// Example 4 
		// exampleDoWhile();
		// Example 5
		exampleEnums();
	}

}
