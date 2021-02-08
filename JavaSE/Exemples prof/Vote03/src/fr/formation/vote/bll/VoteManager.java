package fr.formation.vote.bll;

import fr.formation.vote.bo.Electeur;

public interface VoteManager {
	public boolean peutVoter(Electeur electeur);
}
