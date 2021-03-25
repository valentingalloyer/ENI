package dal;

import java.util.Calendar;

import bo.Biere;

public class TestDAL {

	public static void main(String[] args) {
		/// TEST DAO BRASSERIE

//		try {
//			DAOFact.getBrasserieDAO().insert( new Brasserie("50000",  "Normandie",  "14 rue de la villa de papy",  "Brasserie du papy"));
//			System.out.println(DAOFact.getBrasserieDAO().selectById(3));
//			
//			//DAOFact.getBrasserieDAO().delete(5);
//		//	DAOFact.getBrasserieDAO().delete(6);
//			
//			
//		Brasserie b1 = DAOFact.getBrasserieDAO().selectById(3);
//		b1.setAdresse("4 rue de la villa de jean michel le papy ");
//			DAOFact.getBrasserieDAO().update(b1);
//			
//			
//			System.out.println(" AFFICHAGE DE TOUTES LES BRASSERIES");
//			for (Brasserie b : DAOFact.getBrasserieDAO().selectAll()) {
//				System.out.println(b);
//			}
//			
//			
//			
//			
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			Brasserie maBrasserie = DAOFact.getBrasserieDAO().selectById(2);
			DAOFact.getBiereDAO().insert(
					new Biere("Heineken", maBrasserie , "Blonde", Calendar.getInstance()));
			System.out.println(DAOFact.getBiereDAO().selectById(1));

			System.out.println(" AFFICHAGE DE TOUTES LES BIERES");
			for (Biere b : DAOFact.getBiereDAO().selectAll()) {
				System.out.println(b);
			}
			
			Biere biereUpdated = DAOFact.getBiereDAO().selectById(1);
			biereUpdated.setNom("Delirium RED");
			DAOFact.getBiereDAO().update(biereUpdated);
			System.out.println(" AFFICHAGE DE LA BIERE MODIFIÉE");
			System.out.println(DAOFact.getBiereDAO().selectById(1));
			
			DAOFact.getBiereDAO().delete(7);
			
			System.out.println(" AFFICHAGE DE TOUTES LES BIERES APRES SUPRRESSION");
			for (Biere b : DAOFact.getBiereDAO().selectAll()) {
				System.out.println(b);
			}
//			

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
