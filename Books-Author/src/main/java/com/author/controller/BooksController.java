package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Books;
import com.author.service.IBookService;

@RestController
public class BooksController {

	
	@Autowired
	IBookService bookService;
	
	
	@PostMapping("/saveBook")
	public Integer saveBook(@RequestBody Books book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping("/getBook/{id}")
	public Books getBookById(@PathVariable Integer id) {
		return bookService.getBook(id);
		
	}
	
}
