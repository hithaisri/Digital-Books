package com.author.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.Books;
import com.author.exception.ResourceNotFoundException;
import com.author.repository.IBookRepoistory;
import com.author.service.IBookService;

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
	public Optional<Books> getBook(Integer id) {
		return bookRepoistory.findById(id);
	}
	
	@Override
	public List<Books> getAllBooks(){
		return bookRepoistory.findAll();
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepoistory.deleteById(id);		
	}

	@Override
	public void deleteAllBooks() {
		bookRepoistory.deleteAll();
	}

	@Override
	public Books updateBook(Books book, Integer id) {
		Books existingBook=bookRepoistory.findById(id).orElseThrow(()->new ResourceNotFoundException("Book", "id", id));
		existingBook.setTitle(book.getTitle());
		existingBook.setCategory(book.getCategory());
		existingBook.setImage(book.getImage());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setActive(book.getActive());
		existingBook.setContent(book.getContent());

		bookRepoistory.save(existingBook);
		return existingBook;
	}

	@Override
	public List<Books> searchBook(String title, String publisher, Integer price) {
		List<Books> books=null;
		if(title!=null && !title.equals("")) {
			books=bookRepoistory.findByTitle(title);
		}else if(publisher!=null && !publisher.equals("")) {
			books=bookRepoistory.findByPublisher(publisher);
		}else if(price!=null && price>0) {
			books=bookRepoistory.findByPrice(price);
		}
		return books;
	}

	
}
