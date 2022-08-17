package com.author.service;

import com.author.model.Books;

public interface IBookService {

	Integer saveBook(Books book);

	Books getBook(Integer id);

}
