package calculatrice;

public class Operation {

    public static int ajouter(int a, int b) throws DepassementCapaciteException {
        long longResult = (long) a + (long) b;
        if ((long) a + (long) b != a + b)
            throw new DepassementCapaciteException(longResult);
        else
            return a + b;
    }

    public static int multiplication(int a, int b) throws DepassementCapaciteException {
        long longResult = (long) a * (long) b;
        if ((long) a * (long) b != a * b)
            throw new DepassementCapaciteException(longResult);
        else
            return a * b;
    }

    public static int soustraire (int a, int b) throws DepassementCapaciteException {
        long longResult = (long) a - (long) b;
        if ((long) a - (long) b != a - b)
            throw new DepassementCapaciteException(longResult);
        else
            return a - b;
    }

}
