package papeterie.part3.src.fr.eni.papeterie.dal.jdbc;

import papeterie.part3.src.fr.eni.papeterie.bo.Ligne;

import java.util.List;

public interface LigneDao {

    void insert(Ligne ligne) throws DalException;
    List<Ligne> selectAll() throws DalException;
    Ligne selectById(int id) throws DalException;
    void update(Ligne ligne) throws DalException;
    void delete(int idLigne) throws DalException;

}
