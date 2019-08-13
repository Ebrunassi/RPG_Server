package br.com.database.dao;

import java.io.Serializable;
import java.util.List;

import br.com.database.model.Usuarios;

public abstract class GenericDao<T, I extends Serializable> {
	private static databaseDAO bookDao;
	 
    public GenericDao(Class<Usuarios> class1) {
        bookDao = new databaseDAO();
    }
 
    public void persist(Class<T> entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Class<T> entity) {
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
 
//    public List<Class<T>> findAll() {
//        bookDao.openCurrentSession();
//        List<Class<T>> books = bookDao.findAll();
//        bookDao.closeCurrentSession();
//        return books;
//    }
 
    public void deleteAll() {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public databaseDAO bookDao() {
        return bookDao;
    }
}
