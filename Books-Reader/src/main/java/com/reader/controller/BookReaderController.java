package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reader.entity.Books;
import com.reader.entity.CartItem;
import com.reader.service.IBookService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reader")
public class BookReaderController {
	
	@Autowired
	IBookService bookService;
	

	@GetMapping("/search")
	public List<Books> searchBooks(@RequestParam(required=false) String title,@RequestParam(required=false) String author,@RequestParam(required=false) Integer price) {
		return bookService.searchBook(title,author,price);
	}
	
	@GetMapping("/getMyBooks/{id}")
	public List<Books> getBooks(@PathVariable Integer id) {
		List<Books> books=bookService.getMyBooks(id);
		return books;
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<String> purchaseBook(@RequestBody CartItem cartItem){
		bookService.purchaseBooks(cartItem);
		return new ResponseEntity<String>("Purchased books Successfully!",HttpStatus.OK);
		}

}
