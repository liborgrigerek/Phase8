package cz.morosystems.phase8.service;

import cz.morosystems.phase8.entity.BookEntity;

public interface BookManager {
	public BookEntity getBook(Integer bookId);
    public void addBook(BookEntity book);
    public void editBook(BookEntity book);
    public void deleteBook(Integer bookId);
}
