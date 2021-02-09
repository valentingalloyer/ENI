package vote3.src.fr.formation.vote.bll;

public class VoteManagerFact {

	public static VoteManager getInstance() {
		return new VoteManagerNational();
	}

}
