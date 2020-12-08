import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExampleEcritureFichier {

	private static void ecrireExample1() {
		double[] valeurs = { 17.99, 22.41, 6.0, 39.02, 78.45, 44.7854 };
		try {
		FileWriter f = null;
		try {
			f = new FileWriter("./valeurs.txt");
			for (int i = 0; i < valeurs.length; i++)
				f.write(String.format("%.2f%n", valeurs[i]));
			System.out.println("Enregistrement termin� avec succ�s");
			} finally {
				if (f != null)
				f.close();
			}
		} catch (IOException e) {
			System.err.println("�criture impossible");
		}
	}
	
	private static void ecrireExample2() {
		double[] valeurs = { 17.99, 22.41, 6.0, 39.02, 78.45, 44.7854 };
		try (FileWriter f = new FileWriter("./valeurs.txt")) {
		for (int i = 0; i < valeurs.length; i++)
			f.write(String.format("%.2f%n", valeurs[i]));
		System.out.println("Enregistrement termin� avec succ�s");
		} catch (IOException e) {
			System.err.println("�criture impossible");
		}
	}
	
	private static void lectureExample1() {
		try {
			FileInputStream fichier = null;
			Scanner s = null;
			try {
			fichier = new FileInputStream("./valeurs.txt");
			s = new Scanner(fichier);
			while (s.hasNextLine())
				System.out.println(s.nextLine());
				System.out.println("Fichier lu int�gralement avec succ�s");
				} finally {
				if (s != null)
				s.close();
				if (fichier != null)
				fichier.close();
				}
			} catch (IOException e) {
				System.out.println("Lecture impossible");
		}
	}
	
	private static void lectureExample2() {
		try (FileInputStream fichier = new FileInputStream("./valeurs.txt");
			Scanner s = new Scanner(fichier)) {
			while (s.hasNextLine())
				System.out.println(s.nextLine());
			System.out.println("Fichier lu int�gralement avec succ�s");
			} catch (IOException e) {
				System.out.println("Lecture impossible");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Example 1
		ecrireExample1();
		// Example 2 
		// ecrireExample2();
		// Example 3
		// lectureExample1();
		// Example 4 
		// lectureExample2();
	}

}
