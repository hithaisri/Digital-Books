package com.reader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Books;
import com.reader.repository.IBookRepoistory;
import com.reader.service.IBookService;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	IBookRepoistory bookRepoistory;
	
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

}
