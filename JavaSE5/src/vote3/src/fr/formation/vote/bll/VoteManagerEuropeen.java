package vote3.src.fr.formation.vote.bll;

import vote3.src.fr.formation.vote.bo.Electeur;

public class VoteManagerEuropeen implements VoteManager {
	public static String[] europe = { "FR", "IT", "ES" };

	public boolean peutVoter(Electeur electeur) {
		boolean result = true;

		// régle : Le votant doit avoir 18 ans ou plus
		if (electeur.getAge() < 18) {
			result = false;
		}

		// régle nationalité
		result = false;
		for (String nat : europe) {
			if (electeur.getNat().equals(nat)) {
				result = true;
			}
		}

		return result;
	}
}
