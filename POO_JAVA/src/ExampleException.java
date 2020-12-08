import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleException {

	
	public static int saisie(String message, int min, int max) {
		Scanner s = new Scanner(System.in);
		System.out.printf("%s ", message);
		int val = 0; 
		boolean ok;
		do {
			try {
			val = s.nextInt();
			ok = (val <= min && val >= max);
			} catch (InputMismatchException e) {
			ok = false;
			} finally {
			s.nextLine();
		}
		if (!ok)
			System.err.printf("Saisissez un entier n'est pas compris entre %d et %d%n", min, max);
		} while (!ok);
		return val;
	}
	
	private static void verifNbFaces(int nbFaces) throws Exception {
		if (nbFaces <= 1)
		throw new Exception("Un d� doit avoir au moins deux faces");
	}
	
	private static void exampleException1() {
		saisie("Des bonbons", 1, 5);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exampleException1();
	}

}
