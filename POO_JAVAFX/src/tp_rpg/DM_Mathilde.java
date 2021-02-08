package tp_rpg;

public class DM_Mathilde {

    public static void main(String[] args) {
        double u = 4;
        int n = 0;

        System.out.println("u : " + u + "\n" +
                "n : " + n + "\n" +
                "---------------------------");

        while (u<40) {
            u = 0.92*u + 8;
            n++;
            System.out.println("u : " + u + "\n" +
                    "n : " + n + "\n" +
                    "---------------------------");
        }

        System.out.println("PROGRAMME TERMINE, au final n = " + n);
    }





}
