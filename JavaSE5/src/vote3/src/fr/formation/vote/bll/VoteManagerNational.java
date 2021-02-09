package vote3.src.fr.formation.vote.bll;

import vote3.src.fr.formation.vote.bo.Electeur;

public class VoteManagerNational implements VoteManager{
	
	public boolean peutVoter(Electeur electeur) {
		boolean result = true;
		
		// régle : Le votant doit avoir 18 ans ou plus
		if(electeur.getAge()<18) {
			result = false;
		}
		
		// régle nationalité
		if(!"FR".equals(electeur.getNat())) {
				result = false;
		}
		
		return result;
	}
}
