package com.reader.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reader.entity.Books;
import com.reader.entity.CartItem;
import com.reader.repository.IBookRepoistory;
import com.reader.repository.ICartItemRepository;
import com.reader.service.IBookService;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	IBookRepoistory bookRepoistory;
	
	@Autowired
	ICartItemRepository cartItemRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Books> searchBook(String title, String author, Integer price) {
		List<Books> books=null;
		if(title!=null && !title.equals("")) {
			books=bookRepoistory.findByTitleAndActive(title,true);
		}else if(author!=null && !author.equals("")) {
			books=bookRepoistory.getByAuthorAndActive(author,true);
		}else if(price!=null && price>0) {
			books=bookRepoistory.findByPriceAndActive(price,true);
		}
		return books;
	}

	@Override
	public void purchaseBooks(CartItem cartItem) {
			cartItemRepo.save(cartItem);
	}

	@Override
	public List<Books> getMyBooks(Integer userId) {
		List<Books> books=new ArrayList<Books>();
		List<CartItem> cartItems=cartItemRepo.findByUserId(userId);
		for(CartItem item:cartItems) {
			
		Books book = this.restTemplate.getForObject("http://author-service/book/getBook/"+item.getBookId(), Books.class);
		books.add(book);
		}
		return books;

	}

	
}
