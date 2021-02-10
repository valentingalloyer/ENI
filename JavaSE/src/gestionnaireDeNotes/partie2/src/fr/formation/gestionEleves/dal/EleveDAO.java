package gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.dal;

import gestionnaireDeNotes.partie2.src.fr.formation.gestionEleves.bo.Eleve;

import java.util.List;


public interface EleveDAO {
	public void insert(Eleve eleve) throws EleveDALException;
	public List<Eleve> getAll() throws EleveDALException;
}
