package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part3.src.fr.eni.papeterie.bo.Panier;

import java.util.List;

public interface PanierDao {

    void insert(Panier panier) throws DalException;
    List<Panier> selectAll() throws DalException;
    Panier selectById(int id) throws DalException;
    void update(Panier panier) throws DalException;
    void delete(int id) throws DalException;

}
