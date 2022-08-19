package com.author.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.Books;
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
	public Optional<Books> getBookById(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Books> deleteBook(@PathVariable Integer id) {
		ResponseEntity<Books> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
		bookService.deleteBook(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/deleteAllBooks")
	public void deleteAllBooks() {
		bookService.deleteAllBooks();
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Books> updateBook(@RequestBody Books book,@PathVariable Integer id){
		return new ResponseEntity<Books>(bookService.updateBook(book,id),HttpStatus.OK);
		
	}
	
}
