package vote2.src.fr.formation.vote.bll;

import vote2.src.fr.formation.vote.bo.Electeur;

public class VoteManager {
	public static String[] europe = {"FR","IT","ES"};
	
	public static boolean peutVoter(Electeur electeur, String tyElection) {
		boolean result = true;
		
		// régle : Le votant doit avoir 18 ans ou plus
		if(electeur.getAge()<18) {
			result = false;
		}
		
		// régle nationalité
		if("national".equals(tyElection)) {
			if(!"FR".equals(electeur.getNat())) {
				result = false;
			}
		}
		else {
			result= false;
			for (String nat : europe) {
				if(electeur.getNat().equals(nat)) {
					result= true;
				}
			}
		}
		
		return result;
	}
}
