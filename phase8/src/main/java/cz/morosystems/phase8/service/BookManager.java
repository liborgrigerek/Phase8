package cz.morosystems.phase8.service;

import java.util.List;

import cz.morosystems.phase8.entity.BookEntity;
import cz.morosystems.phase8.entity.UserEntity;

public interface BookManager {
	public BookEntity getBook(Integer bookId);
    public void addBook(BookEntity book);
    public void editBook(BookEntity book);
    public void deleteBook(Integer bookId);
}
