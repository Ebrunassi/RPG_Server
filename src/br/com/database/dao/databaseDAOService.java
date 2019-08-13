package br.com.database.dao;

import java.util.List;

import br.com.database.model.Usuarios;

public class databaseDAOService {
	private static databaseDAO bookDao;
	 
    public databaseDAOService() {
        bookDao = new databaseDAO();
    }
 
    public void persist(Usuarios entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Usuarios entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.update(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public Usuarios findById(String id) {
        bookDao.openCurrentSession();
        Usuarios book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }
 
    public void delete(String id) {
        bookDao.openCurrentSessionwithTransaction();
        Usuarios book = bookDao.findById(id);
        bookDao.delete(book);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Usuarios> findAll() {
        bookDao.openCurrentSession();
        List<Usuarios> books = bookDao.findAll();
        bookDao.closeCurrentSession();
        return books;
    }
 
    public void deleteAll() {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public databaseDAO bookDao() {
        return bookDao;
    }
}
