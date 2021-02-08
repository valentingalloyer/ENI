package fr.eni.election.ihm;

import fr.eni.election.bll.Election;

import java.util.Scanner;

public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer age;
        boolean francais = true, eur = true;

        System.out.println("Entrez votre age ");
        age = sc.nextInt();sc.nextLine();
        if (Election.isMajeur(age)) {
            System.out.println("Êtes vous français ? ");
            francais = sc.nextBoolean();sc.nextLine();
            if (!Election.isFrancais(francais)) {
                System.out.println("Êtes vous européen ? ");
                eur = sc.nextBoolean(); sc.nextLine();
            }
        }

        if (Election.isMajeur(age)) {
            if (Election.isFrancais(francais)) {
                System.out.println("Vous pouvez voter aux élections françaises et européeennes");
            } else if (Election.isEuropeen(eur)) {
                System.out.println("Vous pouvez voter aux élections européennes");
            } else {
                System.out.println("Vous ne pouvez voter ni aux élections européennes ni aux élections françaises");
            }
        }
        else
            System.out.println("Vous ne pouvez voter ni aux élections françaises ni aux européennes");


    }

}
