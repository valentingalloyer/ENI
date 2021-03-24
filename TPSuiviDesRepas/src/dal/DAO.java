package dal;

import java.util.List;

public interface DAO<E> {

	public E selectById(int id) throws DALException;

	public List<E> selectAll() throws DALException;

	public void update(E e) throws DALException;

	public void insert(E e) throws DALException;

	public void delete(int id) throws DALException;

}