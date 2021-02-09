package vote1.src.fr.formation.vote.bll;

public class VoteManager {
	public static String[] europe = {"FR","IT","ES"};
	
	public static boolean peutVoter(Integer age, String nationalite, String tyElection) {
		boolean result = true;
		
		// régle : Le votant doit avoir 18 ans ou plus
		if(age<18) {
			result = false;
		}
		
		// régle nationalité
		if("national".equals(tyElection)) {
			if(!"FR".equals(nationalite)) {
				result = false;
			}
		}
		else {
			result= false;
			for (String nat : europe) {
				if(nationalite.equals(nat)) {
					result= true;
				}
			}
		}
		
		return result;
	}
}
