import java.util.Scanner;

public class TestProgrammee {

	private static String saisirPrenom() {
		Scanner s = new Scanner(System.in);
		System.out.println("Quel est votre prénom ?");
		String prenom = s.nextLine();
		s.close();
		return prenom;
	}
	
	private static void salutation() {
		String prenom = saisirPrenom();
		afficherSalutation(prenom);
	}
	
	private static void afficherSalutation(String prenom) {
		System.out.println("Bonjour " + prenom + " !");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salutation();
	}

}
