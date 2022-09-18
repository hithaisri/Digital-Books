package com.author.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.Books;
import com.author.service.IBookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/book")
public class BooksController {

	
	@Autowired
	IBookService bookService;
	
	
	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Books book) {
		String response="Failed to save book!";
		Integer id=bookService.saveBook(book);
		if(id!=null && id>0)
			response="Book saved";
		return response;
	}
	
	@GetMapping("/getBook/{id}")
	public Optional<Books> getBookById(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getBooksByAuthor/{id}")
	public List<Books> getAllBooks(@PathVariable Integer id) {
		return bookService.getAllBooksByAuthor(id);
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
	
	@GetMapping("/search")
	public List<Books> searchBooks(@RequestParam(required=false) String title,@RequestParam(required=false) String author,@RequestParam(required=false) Integer price) {
		return bookService.searchBook(title,author,price);
	}
	
	@GetMapping("/getMyBooks/{id}")
	public List<Books> getMyBooks(@PathVariable Integer id) {
		return bookService.getMyBooks(id);
	}
	
}
