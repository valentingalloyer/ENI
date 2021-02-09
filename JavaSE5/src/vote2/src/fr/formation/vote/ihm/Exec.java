package vote2.src.fr.formation.vote.ihm;

import vote2.src.fr.formation.vote.bll.VoteManager;
import vote2.src.fr.formation.vote.bo.Electeur;

public class Exec {

	public static void main(String[] args) {
		System.out.println(VoteManager.peutVoter(new Electeur("Marie", 17, "FR"), "national"));
		System.out.println(VoteManager.peutVoter(new Electeur("Léo", 18, "FR"), "national"));
		
	}

}
