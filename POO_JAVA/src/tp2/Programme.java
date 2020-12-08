package tp2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Programme {

    public static void afficherMois(int mois, int annee) {
        int m = mois - 1;
        GregorianCalendar jour = new GregorianCalendar(annee, m, 1);
        jour.get(Calendar.DAY_OF_WEEK);
        System.out.format(" * %s %d *%n",
                jour.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
                jour.get(GregorianCalendar.YEAR));
        System.out.println("L  Ma Me J  V  S  D");
        int decalage = 0;
        switch (jour.get(GregorianCalendar.DAY_OF_WEEK)) {
            case GregorianCalendar.TUESDAY:
                decalage = 3;
                break;
            case GregorianCalendar.WEDNESDAY:
                decalage = 6;
                break;
            case GregorianCalendar.THURSDAY:
                decalage = 9;
                break;
            case GregorianCalendar.FRIDAY:
                decalage = 12;
                break;
            case GregorianCalendar.SATURDAY:
                decalage = 15;
                break;
            case GregorianCalendar.SUNDAY:
                decalage = 18;
                break;
        }
        for (int i = 0; i < decalage; i++) {
            System.out.print(" ");
        }
        int nbJoursDansLeMois = jour.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        for (int i = 1; i <= nbJoursDansLeMois; i++) {
            if (i < 10)
                System.out.print("0" + i + " ");
            else
                System.out.print(i + " ");
            jour.add(GregorianCalendar.DAY_OF_MONTH, 1);
            if (jour.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY)
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int mois = 12, annee = 2020, nb = 0;
        afficherMois(12, annee);
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Pour passer au mois précédent, écrire 0");
            System.out.println("Pour passer au mois suivant, écrire 13");
            System.out.println("Sinon, écrire le mois voulu");
            System.out.println("Pour quitter, écrire un autre nombre");
            nb = s.nextInt();
            if (nb == 0) {
                afficherMois(mois - 1, annee+0);
                mois -= 1;
            }
            else if (nb == 13) {
                afficherMois(mois + 1, annee+0);
                mois ++;
            }
            else if (nb > 0 && nb < 13) {
                mois = nb;
                System.out.println("Quelle année ?");
                annee = s.nextInt();
                afficherMois(nb+0, annee+0);
            }
        } while (true);
    }
}
