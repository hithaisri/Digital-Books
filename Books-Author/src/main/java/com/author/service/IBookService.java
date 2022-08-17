package com.author.service;

import java.util.List;
import java.util.Optional;

import com.author.model.Books;

public interface IBookService {

	Integer saveBook(Books book);

	Optional<Books> getBook(Integer id);

	List<Books> getAllBooks();

	void deleteBook(Integer id);
	
	void deleteAllBooks();

	Books updateBook(Books book, Integer id);

}
