package fr.formation.vote.ihm;

import fr.formation.vote.bll.VoteManager;
import fr.formation.vote.bll.VoteManagerEuropeen;
import fr.formation.vote.bll.VoteManagerFact;
import fr.formation.vote.bll.VoteManagerNational;
import fr.formation.vote.bo.Electeur;

public class Exec {

	public static void main(String[] args) {
		VoteManager manager = VoteManagerFact.getInstance();
		
		
		System.out.println(manager.peutVoter(new Electeur("Marie", 17, "FR")));
		System.out.println(manager.peutVoter(new Electeur("Léo", 18, "FR")));
		
	}

}
