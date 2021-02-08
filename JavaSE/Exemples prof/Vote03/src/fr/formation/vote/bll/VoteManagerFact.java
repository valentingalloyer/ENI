package fr.formation.vote.bll;

public class VoteManagerFact {

	public static VoteManager getInstance() {
		return new VoteManagerNational();
	}

}
