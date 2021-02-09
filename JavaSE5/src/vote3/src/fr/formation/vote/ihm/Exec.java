package vote3.src.fr.formation.vote.ihm;

import vote3.src.fr.formation.vote.bll.VoteManager;
import vote3.src.fr.formation.vote.bll.VoteManagerEuropeen;
import vote3.src.fr.formation.vote.bll.VoteManagerFact;
import vote3.src.fr.formation.vote.bll.VoteManagerNational;
import vote3.src.fr.formation.vote.bo.Electeur;

public class Exec {

	public static void main(String[] args) {
		VoteManager manager = VoteManagerFact.getInstance();
		
		
		System.out.println(manager.peutVoter(new Electeur("Marie", 17, "FR")));
		System.out.println(manager.peutVoter(new Electeur("Léo", 18, "FR")));
		
	}

}
