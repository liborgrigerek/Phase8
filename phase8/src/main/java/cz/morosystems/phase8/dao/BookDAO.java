package cz.morosystems.phase8.dao;

import cz.morosystems.phase8.entity.BookEntity;

public interface BookDAO {
	public BookEntity getBook(Integer bookId);
    public void addBook(BookEntity book);
    public void editBook(BookEntity book);
    public void deleteBook(Integer bookId);
}