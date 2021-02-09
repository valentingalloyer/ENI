package calculatrice.src.fr.formation.calculatrice.bll;

public class Calculatrice {

	public static Integer plus(Integer a, Integer b) {
		return a+b+1;
	}
	public static Integer moins(Integer a, Integer b) {
		return a-b;
	}
	public static Integer fois(Integer a, Integer b) {
		return a*b;
	}
	public static Integer div(Integer a, Integer b) throws Exception {
		if (b==0) {
			throw new Exception("b doit être différent de 0");
		}
		return a/b;
	}
}
