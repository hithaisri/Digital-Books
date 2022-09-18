package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reader.entity.Books;
import com.reader.service.IBookService;


@RestController("/reader")
public class BookReaderController {
	

	@Autowired
	IBookService bookService;

	@GetMapping("/search")
	public List<Books> searchBooks(@RequestParam(required=false) String title,@RequestParam(required=false) String author,@RequestParam(required=false) Integer price) {
		return bookService.searchBook(title,author,price);
	}

}
