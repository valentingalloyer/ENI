package vote1.src.fr.formation.vote.ihm;


import vote1.src.fr.formation.vote.bll.VoteManager;

public class Exec {

	public static void main(String[] args) {
		System.out.println(VoteManager.peutVoter(17, "FR", "national"));
		System.out.println(VoteManager.peutVoter(19, "FR", "national"));
		System.out.println(VoteManager.peutVoter(21, "ES", "national"));
		System.out.println(VoteManager.peutVoter(25, "ES", "européenne"));
	}

}
