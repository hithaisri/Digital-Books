package com.reader.service;

import java.util.List;

import com.reader.entity.Books;

public interface IBookService {

	List<Books> searchBook(String title, String author, Integer price);

}
