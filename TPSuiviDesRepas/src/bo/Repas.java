package bo;

import java.util.Calendar;
import java.util.List;

import dal.DALException;
import dal.DAOFact;

public class Repas {

    private int idRepas;
    private Calendar dateRepas;
    private List<Aliment> listeAliment;

    public Repas() {

    }

    public Repas(int idRepas, Calendar dateRepas, List<Aliment> listeAliment) {
        this.idRepas = idRepas;
        this.dateRepas = dateRepas;
        this.listeAliment = listeAliment;
    }

    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public Calendar getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(Calendar dateRepas) {
        this.dateRepas = dateRepas;
    }

    public List<Aliment> getListeAliment() {
        return listeAliment;
    }

    public void setListeAliment(List<Aliment> listeAliment) {
        this.listeAliment = listeAliment;
    }
}
