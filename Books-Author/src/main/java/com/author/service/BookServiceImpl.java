package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.model.Books;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	IBookRepoistory bookRepoistory;
	
	@Override
	public Integer saveBook(Books book) {
	Books newBook= bookRepoistory.save(book);	
	return newBook.getId();
	}

	@Override
	public Books getBook(Integer id) {
		return bookRepoistory.getById(id);
	}

}
