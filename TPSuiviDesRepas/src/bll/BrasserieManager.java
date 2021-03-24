package bll;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import bo.Biere;
import bo.Brasserie;
import dal.DALException;
import dal.DAOFact;

public class BrasserieManager implements IBrasserieManager {

	@Override
	public List<Biere> recupererBiereByType(String type) throws DALException {
		List<Biere> biereTypeOf = null;
		try {
			biereTypeOf = DAOFact.getBiereDAO().selectAll().stream().filter(biere -> biere.getType().equals(type))
					.collect(Collectors.toList());
		} catch (DALException e) {
			throw new DALException(e.getMessage());

		}
		return biereTypeOf;
	}

	@Override
	public List<Biere> recupererBiereByRegion(String region) throws DALException {
		List<Biere> biereRegionOf = null;
		try {
			biereRegionOf = DAOFact.getBiereDAO().selectAll().stream()
					.filter(biere -> biere.getBrasserie().getRegion().equals(region)).collect(Collectors.toList());
		} catch (DALException e) {
			throw new DALException(e.getMessage());

		}
		return biereRegionOf;
	}

	@Override
	public List<Biere> recupererBiereByBrasserie(int id) throws DALException {
		List<Biere> biereByBrasserie = null;
		try {
			biereByBrasserie = DAOFact.getBiereDAO().selectAll().stream()
					.filter(biere -> biere.getBrasserie().getIdBrasserie() == id).collect(Collectors.toList());
		} catch (DALException e) {
			throw new DALException(e.getMessage());

		}
		return biereByBrasserie;
	}

	@Override
	public List<Biere> recupererBiereByBrasserie(Brasserie brasserie) throws DALException {
		return recupererBiereByBrasserie(brasserie.getIdBrasserie());
	}

	@Override
	public void supprimerAnciennesBieres() throws DALException {
		List<Biere> anciennesBieres = null;
		try {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.YEAR, -2);
			anciennesBieres = DAOFact.getBiereDAO().selectAll().stream()
					.filter(biere -> biere.getDateInsert().before(c)).collect(Collectors.toList());
			for (Biere biere : anciennesBieres) {
				DAOFact.getBiereDAO().delete(biere.getIdBiere());
			}
		} catch (DALException e) {
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public void supprimerBieresMauvaisesNotes() throws DALException {
		List<Biere> mauvaisesBieres = null;
		try {
			mauvaisesBieres = DAOFact.getBiereDAO().selectAll().stream()
					.filter(biere -> biere.getNote() >= 1 && biere.getNote() <= 2).collect(Collectors.toList());
			for (Biere biere : mauvaisesBieres) {
				DAOFact.getBiereDAO().delete(biere.getIdBiere());
			}
		} catch (DALException e) {
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public void noterBiere(Biere biere, int note) throws DALException {
		biere.setNote(note);
		DAOFact.getBiereDAO().update(biere);
	}

	@Override
	public Brasserie brasserieById(int id) throws DALException {
		// TODO Auto-generated method stub
		return DAOFact.getBrasserieDAO().selectById(id);
	}

	@Override
	public List<Brasserie> recupererBrasseries() throws DALException {
		// TODO Auto-generated method stub
		return DAOFact.getBrasserieDAO().selectAll();
	}

	@Override
	public void insererBrasserie(Brasserie b) throws DALException {
		DAOFact.getBrasserieDAO().insert(b);

	}

	@Override
	public void mettreAJourBrasserie(Brasserie b) throws DALException {
		DAOFact.getBrasserieDAO().update(b);

	}

	@Override
	public void supprimerBrasserie(Brasserie b) throws DALException {
		DAOFact.getBrasserieDAO().delete(b.getIdBrasserie());

	}

	@Override
	public Biere biereById(int id) throws DALException {
		return DAOFact.getBiereDAO().selectById(id);

	}

	@Override
	public List<Biere> recupererBieres() throws DALException {
		// TODO Auto-generated method stub
		return DAOFact.getBiereDAO().selectAll();
	}

	@Override
	public void insererBiere(Biere b) throws DALException {

		List<String> othersBeers = recupererBiereByBrasserie(b.getBrasserie()).stream().map(biere -> biere.getNom())
				.collect(Collectors.toList());
		boolean containsInBlackList = DAOFact.getBlackList().getBlackListTypeof("biere").contains(b.getNom().trim());
		boolean alreadyExistInBrasserie = othersBeers.contains(b.getNom().trim());
		int nbOfType = DAOFact.getBiereDAO().selectAll().stream()
				.filter(biere -> biere.getType().trim().equals(b.getType().trim())).collect(Collectors.toList()).size();
		int totalBeer = DAOFact.getBiereDAO().selectAll().size();

		boolean moreHalfCount = ((float) nbOfType / (float) totalBeer > 0.5) ? true : false;

		if (!containsInBlackList && !alreadyExistInBrasserie && !moreHalfCount) {
			DAOFact.getBiereDAO().insert(b);
		} else {
			if (containsInBlackList) {
				throw new DALException("Le nom de cette bière est interdite");
			} else if (alreadyExistInBrasserie) {
				throw new DALException("Le nom de cette bière existe déjà dans sa brasserie");
			} else if (moreHalfCount) {
				throw new DALException("Il y a plus de la moitié des bières de ce type");
			}

			throw new DALException("Erreur inconnue lors de l'insertion d'une bière");
			
		}
	}

	@Override
	public void mettreAJourBiere(Biere b) throws DALException {
		DAOFact.getBiereDAO().update(b);
	}

	@Override
	public void supprimerBiere(Biere b) throws DALException {
		DAOFact.getBiereDAO().delete(b.getIdBiere());

	}

}
