package bll;

import java.util.Calendar;

import bo.Biere;
import dal.DALException;

public class AppliTestBLL {

	public static void main(String[] args) {
	IBrasserieManager managerBrasserie	= BrasserieManagerSingleton.getInstance();
	 
		try {
			Biere b = managerBrasserie.biereById(1);
			managerBrasserie.noterBiere(b, 4);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
////			for (Biere b : managerBrasserie.recupererBieres()) {
////				int nombreAleatoire = 1 + (int)(Math.random() * ((5 - 1) + 1));
////				managerBrasserie.noterBiere(b, nombreAleatoire);
////			}
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			managerBrasserie.supprimerAnciennesBieres();
			managerBrasserie.supprimerBieresMauvaisesNotes();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			for (Biere biereBrasserie1 : managerBrasserie.recupererBiereByBrasserie(managerBrasserie.brasserieById(2))) {
				System.out.println(biereBrasserie1.toString());
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			for (Biere biereBretagne : managerBrasserie.recupererBiereByRegion("Bretagne")) {
				System.out.println(biereBretagne.toString());
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BIERE BLONDES  : ");
		try {
			for (Biere biereBretagne : managerBrasserie.recupererBiereByType("Blonde")) {
				System.out.println(biereBretagne.toString());
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			managerBrasserie.insererBiere(	new Biere("Maurice1", managerBrasserie.brasserieById(1) , "Ambré", Calendar.getInstance()));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
