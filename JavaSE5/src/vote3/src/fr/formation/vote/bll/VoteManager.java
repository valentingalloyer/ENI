package vote3.src.fr.formation.vote.bll;

import vote3.src.fr.formation.vote.bo.Electeur;

public interface VoteManager {
	public boolean peutVoter(Electeur electeur);
}
