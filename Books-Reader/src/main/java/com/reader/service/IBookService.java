package com.reader.service;

import java.util.List;

import com.reader.entity.Books;
import com.reader.entity.CartItem;

public interface IBookService {

	List<Books> searchBook(String title, String author, Integer price);

	void purchaseBooks(CartItem cartItem);

	List<Books> getMyBooks(Integer userId);

}
