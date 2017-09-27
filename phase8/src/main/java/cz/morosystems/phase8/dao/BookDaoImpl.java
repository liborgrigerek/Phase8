package cz.morosystems.phase8.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase8.entity.BookEntity;

@Repository
public class BookDaoImpl implements BookDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	@Transactional
	public BookEntity getBook(Integer bookId) {
		return (BookEntity) this.sessionFactory.getCurrentSession().createQuery("from BookEntity book where book.id = :bookid").setParameter("bookid", bookId).uniqueResult();
	}
	@Transactional
	public void addBook(BookEntity book) {
		// nova kniha
		this.sessionFactory.getCurrentSession().save(book);
	}
	@Transactional
	public void editBook(BookEntity book) {
		// editace knihy
		this.sessionFactory.getCurrentSession().merge(book);
	}
	@Transactional
	public void deleteBook(Integer bookId) {
		BookEntity book = (BookEntity) sessionFactory.getCurrentSession().load(
				BookEntity.class, bookId);
        if (null != book) {
        	this.sessionFactory.getCurrentSession().delete(book);
        }
	}
}
